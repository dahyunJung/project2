package LoginVO;

public class UpdateInfoVO {
private String id,email;
private String phone;
public UpdateInfoVO(String id, String email, String phone) {
	super();
	this.id = id;
	this.email = email;
	this.phone = phone;
}
public UpdateInfoVO() {
	super();
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
@Override
public String toString() {
	return "UpdateInfoVO [id=" + id + ", email=" + email + ", phone=" + phone + "]";
}


}
