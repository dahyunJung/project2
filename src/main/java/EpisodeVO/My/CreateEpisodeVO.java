package EpisodeVO.My;

import java.sql.Date;

public class CreateEpisodeVO {

	private int epNum; // 에피소드 번호 (pk)
	private int novelNum; // 소설 번호 (fk)
	private int userNum; // 유저 번호 (fk) 세션
	private String epTitle; // 소설 제목 (fk)
	private String detail; // 에피소드 내용
	private boolean openStatus; // 에피소드 공개여부
	private int views; // 조회수 시작은 0으로
	private Date createDate; // 에피소드 작성일자

	public int getNovelNum() {
		return novelNum;
	}

	public void setNovelNum(int novelNum) {
		this.novelNum = novelNum;
	}

	public int getEpNum() {
		return epNum;
	}

	public void setEpNum(int epNum) {
		this.epNum = epNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getEpTitle() {
		return epTitle;
	}

	public void setEpTitle(String epTitle) {
		this.epTitle = epTitle;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public boolean getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(boolean openStatus) {
		this.openStatus = openStatus;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
