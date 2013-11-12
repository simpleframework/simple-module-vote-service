package net.simpleframework.module.vote;

import java.util.Date;

import net.simpleframework.ado.bean.AbstractTextDescriptionBean;
import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.ado.db.common.EntityInterceptor;
import net.simpleframework.common.ID;
import net.simpleframework.module.common.content.EContentStatus;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
@EntityInterceptor(listenerTypes = { "net.simpleframework.module.log.EntityUpdateLogAdapter",
		"net.simpleframework.module.log.EntityDeleteLogAdapter" }, columns = { "expiredDate",
		"status", "anonymous", "multiple", "logging" })
public class Vote extends AbstractTextDescriptionBean {

	/* 投票标识 */
	private int voteMark;

	/* 创建日期 */
	private Date createDate;

	/* 创建人 */
	private ID userId;

	/* 过期时间 */
	private Date expiredDate;

	/* 状态 */
	private EContentStatus status;

	/* 是否允许匿名投票 */
	private boolean anonymous;

	/* 多选个数 */
	private short multiple;

	/* 以日志记录投票结果 */
	private boolean logging;

	/* 含有分组 */
	private boolean groups;

	public int getVoteMark() {
		return voteMark;
	}

	public void setVoteMark(final int voteMark) {
		this.voteMark = voteMark;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(final Date createDate) {
		this.createDate = createDate;
	}

	public ID getUserId() {
		return userId;
	}

	public void setUserId(final ID userId) {
		this.userId = userId;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(final Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	public void setAnonymous(final boolean anonymous) {
		this.anonymous = anonymous;
	}

	public short getMultiple() {
		return multiple;
	}

	public void setMultiple(final short multiple) {
		this.multiple = multiple;
	}

	public EContentStatus getStatus() {
		return status == null ? EContentStatus.edit : status;
	}

	public void setStatus(final EContentStatus status) {
		this.status = status;
	}

	public boolean isLogging() {
		return logging;
	}

	public void setLogging(final boolean logging) {
		this.logging = logging;
	}

	public boolean isGroups() {
		return groups;
	}

	public void setGroups(final boolean groups) {
		this.groups = groups;
	}

	public static final DbEntityTable TBL = new DbEntityTable(Vote.class, "sf_vote");

	private static final long serialVersionUID = -7313302415764825936L;
}
