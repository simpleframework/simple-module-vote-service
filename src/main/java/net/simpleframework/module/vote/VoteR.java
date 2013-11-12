package net.simpleframework.module.vote;

import net.simpleframework.ado.bean.AbstractIdBean;
import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class VoteR extends AbstractIdBean {

	/* 投票id */
	private ID voteId;

	/* 内容id */
	private ID contentId;

	public ID getVoteId() {
		return voteId;
	}

	public void setVoteId(final ID voteId) {
		this.voteId = voteId;
	}

	public ID getContentId() {
		return contentId;
	}

	public void setContentId(final ID contentId) {
		this.contentId = contentId;
	}

	public static final DbEntityTable TBL = new DbEntityTable(VoteR.class, "sf_voter");

	private static final long serialVersionUID = -5508574948035204731L;
}
