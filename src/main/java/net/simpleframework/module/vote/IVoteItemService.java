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
public interface IVoteItemService extends IDbBeanService<VoteItem> {

	/**
	 * 获取投票项
	 * 
	 * @param owner
	 * @return
	 */
	IDataQuery<VoteItem> query(Vote vote);

	/**
	 * 获取该投票的总数
	 * 
	 * @param vote
	 * @return
	 */
	int sum(Vote vote);

	/**
	 * 获取组中的投票项
	 * 
	 * @param owner
	 * @return
	 */
	IDataQuery<VoteItem> query(VoteGroup vg);
}
