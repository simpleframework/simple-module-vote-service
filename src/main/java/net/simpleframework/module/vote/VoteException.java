package net.simpleframework.module.vote;

import net.simpleframework.ctx.ModuleException;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class VoteException extends ModuleException {

	public VoteException(final String msg, final Throwable cause) {
		super(msg, cause);
	}

	public static VoteException of(final String msg) {
		return _of(VoteException.class, msg);
	}

	public static VoteException of(final Throwable throwable) {
		return (VoteException) _of(VoteException.class, null, throwable);
	}

	private static final long serialVersionUID = 4637853474785248529L;
}
