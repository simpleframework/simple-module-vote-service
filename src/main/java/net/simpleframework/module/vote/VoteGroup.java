package net.simpleframework.module.vote;

import net.simpleframework.ado.bean.AbstractTextDescriptionBean;
import net.simpleframework.ado.bean.IOrderBeanAware;
import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.ado.db.common.EntityInterceptor;
import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
@EntityInterceptor(listenerTypes = "net.simpleframework.module.log.EntityDeleteLogAdapter")
public class VoteGroup extends AbstractTextDescriptionBean implements IOrderBeanAware {
	private ID voteId;

	/* 是否可以多选 */
	private short multiple;

	private long oorder;

	public ID getVoteId() {
		return voteId;
	}

	public void setVoteId(final ID voteId) {
		this.voteId = voteId;
	}

	public short getMultiple() {
		return multiple;
	}

	public void setMultiple(final short multiple) {
		this.multiple = multiple;
	}

	@Override
	public long getOorder() {
		return oorder;
	}

	@Override
	public void setOorder(final long oorder) {
		this.oorder = oorder;
	}

	public static final DbEntityTable TBL = new DbEntityTable(VoteGroup.class, "sf_vote_group");

	private static final long serialVersionUID = 3681123597338222603L;
}
