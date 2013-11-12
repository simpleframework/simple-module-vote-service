package net.simpleframework.module.vote;

import net.simpleframework.module.common.ICommonModuleContext;
import net.simpleframework.module.common.plugin.ModulePluginRegistry;
import net.simpleframework.module.vote.plugin.IVotePlugin;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public interface IVoteContext extends ICommonModuleContext {

	static final String MODULE_NAME = "simple-module-vote";

	/**
	 * 获取投票管理器
	 * 
	 * @return
	 */
	IVoteService getVoteService();

	/**
	 * 获取投票组管理器
	 * 
	 * @return
	 */
	IVoteGroupService getVoteGroupService();

	/**
	 * 获取投票项管理器
	 * 
	 * @return
	 */
	IVoteItemService getVoteItemService();

	/**
	 * 获取投票记录管理器
	 * 
	 * @return
	 */
	IVoteLogService getVoteLogService();

	VotePluginRegistry getPluginRegistry();

	public static class VotePluginRegistry extends ModulePluginRegistry<IVotePlugin> {
	}
}