package net.simpleframework.module.vote.impl;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.ctx.Module;
import net.simpleframework.module.common.AbstractCommonModuleContext;
import net.simpleframework.module.vote.IVoteContext;
import net.simpleframework.module.vote.IVoteGroupService;
import net.simpleframework.module.vote.IVoteItemService;
import net.simpleframework.module.vote.IVoteLogService;
import net.simpleframework.module.vote.IVoteService;
import net.simpleframework.module.vote.Vote;
import net.simpleframework.module.vote.VoteGroup;
import net.simpleframework.module.vote.VoteItem;
import net.simpleframework.module.vote.VoteLog;
import net.simpleframework.module.vote.VoteR;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class VoteContext extends AbstractCommonModuleContext implements IVoteContext {

	@Override
	protected DbEntityTable[] getEntityTables() {

		return new DbEntityTable[] { Vote.TBL, VoteR.TBL, VoteGroup.TBL, VoteItem.TBL, VoteLog.TBL };
	}

	@Override
	protected Module createModule() {
		return new Module().setName(MODULE_NAME).setText($m("VoteContext.0")).setOrder(23);
	}

	@Override
	public IVoteService getVoteService() {
		return singleton(VoteService.class);
	}

	@Override
	public IVoteGroupService getVoteGroupService() {
		return singleton(VoteGroupService.class);
	}

	@Override
	public IVoteItemService getVoteItemService() {
		return singleton(VoteItemService.class);
	}

	@Override
	public IVoteLogService getVoteLogService() {
		return singleton(VoteLogService.class);
	}

	@Override
	public VotePluginRegistry getPluginRegistry() {
		return singleton(VotePluginRegistry.class);
	}
}
