package LoginVO;

public class SessionVO {
	private String id,name,photo;

	public SessionVO(String id, String name, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
	}

	public SessionVO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "SessionVO [id=" + id + ", name=" + name + ", photo=" + photo + "]";
	}
	
	
}
