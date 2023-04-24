package novel;

public class NewNovelVO {
	private String id,title,filephoto,story;
	private int age,open,end;
	
	public NewNovelVO() {
	}

	public NewNovelVO(String id, String title, String filephoto, String story, int age, int open, int end) {
		this.id = id;
		this.title = title;
		this.filephoto = filephoto;
		this.story = story;
		this.age = age;
		this.open = open;
		this.end = end;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilephoto() {
		return filephoto;
	}

	public void setFilephoto(String filephoto) {
		this.filephoto = filephoto;
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

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "NewNovelVO [" + (id != null ? "id=" + id + ", " : "") + (title != null ? "title=" + title + ", " : "")
				+ (filephoto != null ? "filephoto=" + filephoto + ", " : "")
				+ (story != null ? "story=" + story + ", " : "") + "age=" + age + ", open=" + open + ", end=" + end
				+ "]";
	}



}
