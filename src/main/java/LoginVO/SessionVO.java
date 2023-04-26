package LoginVO;

public class SessionVO {
	private String id,name,photo;
	private int num_member;
	public SessionVO( int num_member,String id, String name, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.num_member = num_member;
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
	public int getNum_member() {
		return num_member;
	}
	public void setNum_member(int num_member) {
		this.num_member = num_member;
	}
	@Override
	public String toString() {
		return "SessionVO [id=" + id + ", name=" + name + ", photo=" + photo + ", num_member=" + num_member + "]";
	}
	
	

	
	
}
