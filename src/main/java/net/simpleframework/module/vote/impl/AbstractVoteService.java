package net.simpleframework.module.vote.impl;

import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.vote.IVoteContextAware;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class AbstractVoteService<T> extends AbstractDbBeanService<T> implements
		IVoteContextAware {

	protected VoteService getVoteService() {
		return (VoteService) voteContext.getVoteService();
	}

	protected VoteGroupService getVoteGroupService() {
		return (VoteGroupService) voteContext.getVoteGroupService();
	}

	protected VoteItemService getVoteItemService() {
		return (VoteItemService) voteContext.getVoteItemService();
	}

	protected VoteLogService getVoteLogService() {
		return (VoteLogService) voteContext.getVoteLogService();
	}
}
