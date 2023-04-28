package LoginVO;

import java.util.Date;

public class InfoVO {
private String name, id, email;
private Date birth;
private String phone;
public InfoVO() {
	super();
}
public InfoVO(String name, String id, String email, Date birth, String phone) {
	super();
	this.name = name;
	this.id = id;
	this.email = email;
	this.birth = birth;
	this.phone = phone;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "InfoVO [name=" + name + ", id=" + id + ", email=" + email + ", birth=" + birth + ", phone=" + phone + "]";
}


}
