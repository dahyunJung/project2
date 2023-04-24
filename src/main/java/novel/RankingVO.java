package novel;

public class RankingVO {
	private String photo,title,id,story;
	private int age,like,visit,rank;
	public RankingVO() {
	}
	public RankingVO(String photo, String title, String id, String story, int age, int like, int visit, int rank) {
		this.photo = photo;
		this.title = title;
		this.id = id;
		this.story = story;
		this.age = age;
		this.like = like;
		this.visit = visit;
		this.rank = rank;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getVisit() {
		return visit;
	}
	public void setVisit(int visit) {
		this.visit = visit;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "RankingVO [" + (photo != null ? "photo=" + photo + ", " : "")
				+ (title != null ? "title=" + title + ", " : "") + (id != null ? "id=" + id + ", " : "")
				+ (story != null ? "story=" + story + ", " : "") + "age=" + age + ", like=" + like + ", visit=" + visit
				+ ", rank=" + rank + "]";
	}
	
}
