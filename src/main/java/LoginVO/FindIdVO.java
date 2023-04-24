package LoginVO;

public class FindIdVO {
private String name;
private int phone;



public FindIdVO() {
	super();
}
public FindIdVO(String name, int phone) {
	super();
	this.name = name;
	this.phone = phone;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}

@Override
public String toString() {
	return "FindIdVO [name=" + name + ", phone=" + phone + "]";
}




}
