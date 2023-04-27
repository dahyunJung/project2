package EpisodeVO;

import java.util.Date;

public class ReportVO {
	
	private int reportNum;
	private int userNum;  //신고하는 사람
	private int novelNum;
	private String id; // 신고당하는 사람
	private int reportCode;
	private Date reportDate;
	
	public int getReportNum() {
		return reportNum;
	}
	public void setReportNum(int reportNum) {
		this.reportNum = reportNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public int getNovelNum() {
		return novelNum;
	}
	public void setNovelNum(int novelNum) {
		this.novelNum = novelNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getReportCode() {
		return reportCode;
	}
	public void setReportCode(int reportCode) {
		this.reportCode = reportCode;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	
}