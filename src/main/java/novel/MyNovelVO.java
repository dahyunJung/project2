package novel;

public class MyNovelVO {
	private String thumbnail,novelTitle;
	private boolean ageAble,openStatus;
	private int num_novel,end;
	public MyNovelVO() {
	}
	public MyNovelVO(String thumbnail, String novelTitle, boolean ageAble, boolean openStatus, int num_novel, int end) {
		this.thumbnail = thumbnail;
		this.novelTitle = novelTitle;
		this.ageAble = ageAble;
		this.openStatus = openStatus;
		this.num_novel = num_novel;
		this.end = end;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getNovelTitle() {
		return novelTitle;
	}
	public void setNovelTitle(String novelTitle) {
		this.novelTitle = novelTitle;
	}
	public boolean isAgeAble() {
		return ageAble;
	}
	public void setAgeAble(boolean ageAble) {
		this.ageAble = ageAble;
	}
	public boolean isOpenStatus() {
		return openStatus;
	}
	public void setOpenStatus(boolean openStatus) {
		this.openStatus = openStatus;
	}
	public int getNum_novel() {
		return num_novel;
	}
	public void setNum_novel(int num_novel) {
		this.num_novel = num_novel;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
