package net.simpleframework.module.vote.impl;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.query.DataQueryUtils;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.vote.IVoteItemService;
import net.simpleframework.module.vote.Vote;
import net.simpleframework.module.vote.VoteGroup;
import net.simpleframework.module.vote.VoteItem;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class VoteItemService extends AbstractDbBeanService<VoteItem> implements IVoteItemService,
		IVoteServiceImplAware {

	@Override
	public IDataQuery<VoteItem> query(final Vote vote) {
		if (vote == null) {
			return DataQueryUtils.nullQuery();
		}
		return query("voteId=? order by oorder", vote.getId());
	}

	@Override
	public int sum(final Vote vote) {
		return vote == null ? 0 : sum("votes", "voteId=?", vote.getId()).intValue();
	}

	@Override
	public IDataQuery<VoteItem> query(final VoteGroup vg) {
		if (vg == null) {
			return DataQueryUtils.nullQuery();
		}
		return query("groupId=? order by oorder", vg.getId());
	}

	@Override
	public void onInit() throws Exception {
		super.onInit();

		addListener(new DbEntityAdapterEx() {

			@Override
			public void onBeforeDelete(final IDbEntityManager<?> service,
					final IParamsValue paramsValue) throws Exception {
				super.onBeforeDelete(service, paramsValue);
				for (final VoteItem vi : coll(paramsValue)) {
					vlogService.deleteWith("itemId=?", vi.getId());
				}
			}
		});
	}
}
