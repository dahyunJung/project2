package novel;

import java.util.Date;

public class ListEpisodeVO2 {
	
	private int novelNum;
	private int epNum;
	private String epTitle;
	private int viewCnt;
	private Date createDate;
	
	
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
	public String getEpTitle() {
		return epTitle;
	}
	public void setEpTitle(String epTitle) {
		this.epTitle = epTitle;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}
