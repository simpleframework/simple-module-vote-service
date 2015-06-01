package net.simpleframework.module.vote.impl;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.db.common.ExpressionValue;
import net.simpleframework.ado.db.common.SQLValue;
import net.simpleframework.ado.query.DataQueryUtils;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.vote.IVoteService;
import net.simpleframework.module.vote.Vote;
import net.simpleframework.module.vote.VoteR;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class VoteService extends AbstractDbBeanService<Vote> implements IVoteService,
		IVoteServiceImplAware {

	@Override
	public void insertToContent(final Vote vote, final Object contentId) {
		insert(vote);
		if (contentId != null) {
			final VoteR r = new VoteR();
			r.setVoteId(vote.getId());
			r.setContentId(ID.of(contentId));
			getEntityManager(VoteR.class).insert(r);
		}
	}

	@Override
	public IDataQuery<Vote> queryVote(final int voteMark) {
		return query("votemark=?", voteMark);
	}

	@Override
	public IDataQuery<Vote> queryVote(final int voteMark, final Object userId) {
		if (userId == null) {
			return DataQueryUtils.nullQuery();
		}
		return query("votemark=? and userId=?", voteMark, userId);
	}

	@Override
	public IDataQuery<?> queryVotes(final Object contentId) {
		return query(new SQLValue("select a.* from " + getTablename(Vote.class) + " a right join "
				+ getTablename(VoteR.class)
				+ " b on a.id = b.voteid where b.contentid=? order by a.oorder", contentId));
	}

	@Override
	public void onInit() throws Exception {
		super.onInit();

		addListener(new DbEntityAdapterEx() {
			@Override
			public void onBeforeDelete(final IDbEntityManager<?> service,
					final IParamsValue paramsValue) throws Exception {
				super.onBeforeDelete(service, paramsValue);
				for (final Vote vote : coll(paramsValue)) {
					final ID voteId = vote.getId();
					if (vote.isGroups()) {
						vgService.deleteWith("voteId=?", voteId);
					} else {
						viService.deleteWith("voteId=?", voteId);
					}
					getEntityManager(VoteR.class).delete(new ExpressionValue("voteId=?", voteId));
					vlogService.deleteWith("voteId=?", voteId);
				}
			}
		});
	}
}
