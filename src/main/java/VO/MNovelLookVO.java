package VO;

public class MNovelLookVO {
	private String novelTitle, id, thumbnail, intro;
	private int ageAble, reportReason, reportCnt;

	public MNovelLookVO() {
	}

	public MNovelLookVO(String novelTitle, String id, String thumbnail, String intro, int ageAble, int reportReason,
			int reportCnt) {
		this.novelTitle = novelTitle;
		this.id = id;
		this.thumbnail = thumbnail;
		this.intro = intro;
		this.ageAble = ageAble;
		this.reportReason = reportReason;
		this.reportCnt = reportCnt;
	}

	public String getNovelTitle() {
		return novelTitle;
	}

	public void setNovelTitle(String novelTitle) {
		this.novelTitle = novelTitle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getAgeAble() {
		return ageAble;
	}

	public void setAgeAble(int ageAble) {
		this.ageAble = ageAble;
	}

	public int getReportReason() {
		return reportReason;
	}

	public void setReportReason(int reportReason) {
		this.reportReason = reportReason;
	}

	public int getReportCnt() {
		return reportCnt;
	}

	public void setReportCnt(int reportCnt) {
		this.reportCnt = reportCnt;
	}

	@Override
	public String toString() {
		return "MNovelLookVO [novelTitle=" + novelTitle + ", id=" + id + ", thumbnail=" + thumbnail + ", intro=" + intro
				+ ", ageAble=" + ageAble + ", reportReason=" + reportReason + ", reportCnt=" + reportCnt + "]";
	}

}
