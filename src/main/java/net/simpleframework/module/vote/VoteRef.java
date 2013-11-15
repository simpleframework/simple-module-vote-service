package net.simpleframework.module.vote;

import net.simpleframework.ctx.AbstractModuleRef;
import net.simpleframework.ctx.ModuleContextFactory;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class VoteRef extends AbstractModuleRef {

	@Override
	public IVoteContext getModuleContext() {
		return ModuleContextFactory.get(IVoteContext.class);
	}
}
