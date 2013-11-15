package net.simpleframework.module.vote.impl;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.query.DataQueryUtils;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.module.vote.IVoteGroupService;
import net.simpleframework.module.vote.Vote;
import net.simpleframework.module.vote.VoteGroup;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class VoteGroupService extends AbstractVoteService<VoteGroup> implements IVoteGroupService {

	@Override
	public IDataQuery<VoteGroup> query(final Vote vote) {
		if (vote == null) {
			return DataQueryUtils.nullQuery();
		}
		return query("voteId=?", vote.getId());
	}

	@Override
	public void onInit() throws Exception {
		addListener(new DbEntityAdapterEx() {

			@Override
			public void onBeforeDelete(final IDbEntityManager<?> service,
					final IParamsValue paramsValue) {
				super.onBeforeDelete(service, paramsValue);
				for (final VoteGroup vg : coll(paramsValue)) {
					getVoteItemService().deleteWith("groupId=?", vg.getId());
				}
			}
		});
	}
}
