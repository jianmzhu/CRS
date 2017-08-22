package cn.crs.reserve.entity;

import java.util.Date;

public class Notice {
    private Integer noticeId;

    private String noticeName;

    private String noticeType;

    private Date createTime;

    private Date updateTime;

    private Integer isDel;

    private String noticeDescription;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName == null ? null : noticeName.trim();
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getNoticeDescription() {
        return noticeDescription;
    }

    public void setNoticeDescription(String noticeDescription) {
        this.noticeDescription = noticeDescription == null ? null : noticeDescription.trim();
    }

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeName=" + noticeName
				+ ", noticeType=" + noticeType + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", isDel=" + isDel
				+ ", noticeDescription=" + noticeDescription + "]";
	}
    
}