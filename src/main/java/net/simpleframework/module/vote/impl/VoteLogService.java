package net.simpleframework.module.vote.impl;

import java.util.Calendar;
import java.util.Date;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.query.DataQueryUtils;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.vote.IVoteLogService;
import net.simpleframework.module.vote.Vote;
import net.simpleframework.module.vote.VoteItem;
import net.simpleframework.module.vote.VoteLog;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class VoteLogService extends AbstractDbBeanService<VoteLog> implements IVoteLogService,
		IVoteServiceImplAware {

	@Override
	public IDataQuery<VoteLog> query(final VoteItem item) {
		if (item == null) {
			return DataQueryUtils.nullQuery();
		}
		return query("itemId=?", item.getId());
	}

	@Override
	public IDataQuery<VoteLog> query(final Vote vote) {
		if (vote == null) {
			return DataQueryUtils.nullQuery();
		}
		return query("voteId=?", vote.getId());
	}

	@Override
	public IDataQuery<VoteLog> queryLog(final Vote vote, final Object userId) {
		if (userId == null) {
			return DataQueryUtils.nullQuery();
		}
		return query("voteId=? and userId=?", vote.getId(), userId);
	}

	@Override
	public IDataQuery<VoteLog> query(final Vote vote, final String ip, final int expirationTime) {
		if (vote == null) {
			return DataQueryUtils.nullQuery();
		}
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MILLISECOND, -expirationTime * 1000);
		return query("voteId=? and ip=? and createDate>?", vote.getId(), ip, cal.getTime());
	}

	@Override
	public void onInit() throws Exception {
		super.onInit();

		addListener(new DbEntityAdapterEx<VoteLog>() {
			@Override
			public void onBeforeDelete(final IDbEntityManager<VoteLog> manager,
					final IParamsValue paramsValue) throws Exception {
				super.onBeforeDelete(manager, paramsValue);
				for (final VoteLog log : coll(manager, paramsValue)) {
					updateVotes(log, -1);
				}
			}

			@Override
			public void onAfterInsert(final IDbEntityManager<VoteLog> manager, final VoteLog[] beans)
					throws Exception {
				super.onAfterInsert(manager, beans);
				for (final VoteLog o : beans) {
					updateVotes(o, 0);
				}
			}

			private void updateVotes(final VoteLog log, final int i) {
				final VoteItem item = viService.getBean(log.getItemId());
				if (item != null) {
					item.setVotes(query(item).getCount() + i);
					viService.update(new String[] { "votes" }, item);
				}
			}
		});
	}
}
