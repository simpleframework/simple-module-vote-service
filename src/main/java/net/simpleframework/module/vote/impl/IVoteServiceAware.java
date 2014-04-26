package net.simpleframework.module.vote.impl;

import net.simpleframework.module.vote.IVoteContextAware;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IVoteServiceAware extends IVoteContextAware {

	static VoteService vService = (VoteService) voteContext.getVoteService();
	static VoteGroupService vgService = (VoteGroupService) voteContext.getVoteGroupService();
	static VoteItemService viService = (VoteItemService) voteContext.getVoteItemService();
	static VoteLogService vlogService = (VoteLogService) voteContext.getVoteLogService();
}
