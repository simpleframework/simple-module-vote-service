package net.simpleframework.module.vote;

import net.simpleframework.common.th.RuntimeExceptionEx;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class VoteException extends RuntimeExceptionEx {

	public VoteException(final String msg, final Throwable cause) {
		super(msg, cause);
	}

	public static RuntimeException of(final String msg) {
		return _of(VoteException.class, msg);
	}

	public static RuntimeException of(final Throwable throwable) {
		return _of(VoteException.class, null, throwable);
	}

	private static final long serialVersionUID = 4637853474785248529L;
}
