package net.simpleframework.module.vote;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IVoteService extends IDbBeanService<Vote> {

	/**
	 * 为内容添加投票
	 * 
	 * @param vote
	 * @param contentId
	 */
	void insertToContent(Vote vote, Object contentId);

	/**
	 * 
	 * @param voteMark
	 * @param userId
	 * @return
	 */
	IDataQuery<Vote> queryVote(int voteMark, Object userId);

	IDataQuery<Vote> queryVote(int voteMark);
}
