package net.simpleframework.module.vote;

import net.simpleframework.ctx.IModuleContextAware;
import net.simpleframework.ctx.ModuleContextFactory;
import net.simpleframework.module.vote.impl.VoteGroupService;
import net.simpleframework.module.vote.impl.VoteItemService;
import net.simpleframework.module.vote.impl.VoteLogService;
import net.simpleframework.module.vote.impl.VoteService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IVoteContextAware extends IModuleContextAware {

	static IVoteContext voteContext = ModuleContextFactory.get(IVoteContext.class);

	static VoteService vService = (VoteService) voteContext.getVoteService();
	static VoteGroupService vgService = (VoteGroupService) voteContext.getVoteGroupService();
	static VoteItemService viService = (VoteItemService) voteContext.getVoteItemService();
	static VoteLogService vlogService = (VoteLogService) voteContext.getVoteLogService();
}