package LoginVO;

import java.util.Date;

public class JoinVO {
	private String name,id,pw,email,phone;
	private Date birthDate;
	public JoinVO(String name, String id, String pw, String email, String phone, Date birthDate) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
	}
	public JoinVO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "JoinVO [name=" + name + ", id=" + id + ", pw=" + pw + ", email=" + email + ", phone=" + phone
				+ ", birthDate=" + birthDate + "]";
	}
	
	
	
	

	
}
