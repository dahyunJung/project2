package VO;

import java.sql.Date;

public class MemberManageVO {
	private String id;
	private int num_member, novelCnt, reportCnt;
	private Date visitDate, joinDate, susPeriod;
	
	public MemberManageVO() {
		
	}

	public MemberManageVO(String id, int num_member, int novelCnt, int reportCnt, Date visitDate, Date joinDate,
			Date susPeriod) {
		this.id = id;
		this.num_member = num_member;
		this.novelCnt = novelCnt;
		this.reportCnt = reportCnt;
		this.visitDate = visitDate;
		this.joinDate = joinDate;
		this.susPeriod = susPeriod;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNum_member() {
		return num_member;
	}

	public void setNum_member(int num_member) {
		this.num_member = num_member;
	}

	public int getNovelCnt() {
		return novelCnt;
	}

	public void setNovelCnt(int novelCnt) {
		this.novelCnt = novelCnt;
	}

	public int getReportCnt() {
		return reportCnt;
	}

	public void setReportCnt(int reportCnt) {
		this.reportCnt = reportCnt;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getSusPeriod() {
		return susPeriod;
	}

	public void setSusPeriod(Date susPeriod) {
		this.susPeriod = susPeriod;
	}

	@Override
	public String toString() {
		return "MemberManageVO [id=" + id + ", num_member=" + num_member + ", novelCnt=" + novelCnt + ", reportCnt="
				+ reportCnt + ", visitDate=" + visitDate + ", joinDate=" + joinDate + ", susPeriod=" + susPeriod + "]";
	}
	
	
	


}
