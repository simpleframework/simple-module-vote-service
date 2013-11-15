package net.simpleframework.module.vote;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IVoteLogService extends IDbBeanService<VoteLog> {

	/**
	 * 获取投票项的日志记录
	 * 
	 * @param item
	 * @return
	 */
	IDataQuery<VoteLog> query(VoteItem item);

	/**
	 * 获取投票的日志记录
	 * 
	 * @param vote
	 * @return
	 */
	IDataQuery<VoteLog> query(Vote vote);

	/**
	 * 
	 * @param vote
	 * @param ip
	 * @param expirationTime
	 * @return
	 */
	IDataQuery<VoteLog> query(Vote vote, String ip, int expirationTime);

	/**
	 * 查询指定用户的投票日至
	 * 
	 * @param vote
	 * @param userId
	 * @return
	 */
	IDataQuery<VoteLog> queryLog(Vote vote, Object userId);
}
