package novel;

import java.sql.Date;

public class SearchVO {
	private String photo,subject,id;
	private int num_novel,episode;
	private Date make;
	
	public SearchVO() {
		
	}
	public SearchVO(String photo, String subject, String id, int num_novel,int episode,Date make) {
		this.photo = photo;
		this.subject = subject;
		this.id = id;
		this.num_novel = num_novel;
		this.episode = episode;
		this.make = make;
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
	
	public int getEpisode() {
		return episode;
	}
	public void setEpisode(int episode) {
		this.episode = episode;
	}
	public Date getMake() {
		return make;
	}
	public void setMake(Date make) {
		this.make = make;
	}
}
