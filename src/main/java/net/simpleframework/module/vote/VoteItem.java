package net.simpleframework.module.vote;

import net.simpleframework.ado.bean.AbstractTextDescriptionBean;
import net.simpleframework.ado.bean.IOrderBeanAware;
import net.simpleframework.ado.db.common.EntityInterceptor;
import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
@EntityInterceptor(listenerTypes = "net.simpleframework.module.log.EntityDeleteLogAdapter")
public class VoteItem extends AbstractTextDescriptionBean implements IOrderBeanAware {
	/* 投票id */
	private ID voteId;

	/* 投票组id，可为null */
	private ID groupId;

	/* 投票数 */
	private int votes;

	private int oorder;

	public int getVotes() {
		return votes;
	}

	public void setVotes(final int votes) {
		this.votes = votes;
	}

	public ID getVoteId() {
		return voteId;
	}

	public void setVoteId(final ID voteId) {
		this.voteId = voteId;
	}

	public ID getGroupId() {
		return groupId;
	}

	public void setGroupId(final ID groupId) {
		this.groupId = groupId;
	}

	@Override
	public int getOorder() {
		return oorder;
	}

	@Override
	public void setOorder(final int oorder) {
		this.oorder = oorder;
	}

	private static final long serialVersionUID = 9162644513334175204L;
}
