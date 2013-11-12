package net.simpleframework.module.vote;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public interface IVoteGroupService extends IDbBeanService<VoteGroup> {

	/**
	 * 
	 * @param vote
	 * @return
	 */
	IDataQuery<VoteGroup> query(Vote vote);
}
