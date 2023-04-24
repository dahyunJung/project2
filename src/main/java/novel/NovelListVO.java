package novel;

public class NovelListVO {
	private String photo,title,id,story;

	public NovelListVO() {
	}

	public NovelListVO(String photo, String title, String id, String story) {
		this.photo = photo;
		this.title = title;
		this.id = id;
		this.story = story;
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

	@Override
	public String toString() {
		return "NovelListVO [" + (photo != null ? "photo=" + photo + ", " : "")
				+ (title != null ? "title=" + title + ", " : "") + (id != null ? "id=" + id + ", " : "")
				+ (story != null ? "story=" + story : "") + "]";
	}


}
