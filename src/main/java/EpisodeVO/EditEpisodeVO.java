package EpisodeVO;

public class EditEpisodeVO {
	
	private int userNum; // 유저 번호 (fk) 세션 
	private int epNum; // 에피소드 번호 (pk)
	private int novelNum; // 소설 번호 (fk) 
	private String epTitle; // 소설 제목
	private String detail; // 에피소드 내용
	private boolean openStatus; // 에피소드 공개여부
	
	
	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getEpNum() {
		return epNum;
	}

	public void setEpNum(int epNum) {
		this.epNum = epNum;
	}

	public int getNovelNum() {
		return novelNum;
	}

	public void setNovelNum(int novelNum) {
		this.novelNum = novelNum;
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

	
	
}
