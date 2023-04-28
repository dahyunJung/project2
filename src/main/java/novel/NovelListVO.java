package novel;

public class NovelListVO {
	private String photo,title,id,story;
	private int age,end,open;

	public NovelListVO() {
	}

	public NovelListVO(String photo, String title, String id, String story, int age, int end, int open) {
		this.photo = photo;
		this.title = title;
		this.id = id;
		this.story = story;
		this.age = age;
		this.end = end;
		this.open = open;
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

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

}
