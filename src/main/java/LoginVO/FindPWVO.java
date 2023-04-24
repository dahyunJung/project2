package LoginVO;

public class FindPWVO {
private String id,email,passTemp;
private int phone;

public FindPWVO() {
	super();
}




public FindPWVO(String id, String email, String passTemp, int phone) {
	super();
	this.id = id;
	this.email = email;
	this.passTemp = passTemp;
	this.phone = phone;
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
public String getPassTemp() {
	return passTemp;
}
public void setPassTemp(String passTemp) {
	this.passTemp = passTemp;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "FindPWVO [id=" + id + ", email=" + email + ", passTemp=" + passTemp + ", phone=" + phone + "]";
}



}
