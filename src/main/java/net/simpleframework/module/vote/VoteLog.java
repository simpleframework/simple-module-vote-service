package net.simpleframework.module.vote;

import net.simpleframework.ado.bean.AbstractUserAwareBean;
import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class VoteLog extends AbstractUserAwareBean {
	/* 投票id */
	private ID voteId;

	/* 投票项id */
	private ID itemId;

	private String ip;

	public ID getVoteId() {
		return voteId;
	}

	public void setVoteId(final ID voteId) {
		this.voteId = voteId;
	}

	public ID getItemId() {
		return itemId;
	}

	public void setItemId(final ID itemId) {
		this.itemId = itemId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(final String ip) {
		this.ip = ip;
	}

	private static final long serialVersionUID = 3038260625073427675L;
}
