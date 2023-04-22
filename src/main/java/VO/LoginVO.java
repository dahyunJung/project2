package VO;

import java.sql.Date;

public class LoginVO {
private String id, password;
private Date create_date;

public LoginVO() {
}

public LoginVO(String id, String password, Date create_date) {
	this.id = id;
	this.password = password;
	this.create_date = create_date;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Date getCreate_date() {
	return create_date;
}

public void setCreate_date(Date create_date) {
	this.create_date = create_date;
}

@Override
public String toString() {
	return "LoginVO [id=" + id + ", password=" + password + ", create_date=" + create_date + "]";
}





}
