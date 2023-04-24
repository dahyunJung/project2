package novel;

public class MyLikeVO {
	private String photo,subject,id;
	private int num_novel;
	
	public MyLikeVO() {
		
	}
	public MyLikeVO(String photo, String subject, String id, int num_novel) {
		this.photo = photo;
		this.subject = subject;
		this.id = id;
		this.num_novel = num_novel;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNum_novel() {
		return num_novel;
	}
	public void setNum_novel(int num_novel) {
		this.num_novel = num_novel;
	}
	
	@Override
	public String toString() {
		return "MyLikeVO [" + (photo != null ? "photo=" + photo + ", " : "")
				+ (subject != null ? "subject=" + subject + ", " : "") + (id != null ? "id=" + id + ", " : "")
				+ "num_novel=" + num_novel + "]";
	}
}
