package LoginVO;

import java.util.Date;

public class LoginHistoryVO {
private int num_member;
private String ip, OS;
private Date visit;
public LoginHistoryVO() {
	super();
}
public LoginHistoryVO(int num_member, String ip, String oS, Date visit) {
	super();
	this.num_member = num_member;
	this.ip = ip;
	OS = oS;
	this.visit = visit;
}
public int getNum_member() {
	return num_member;
}
public void setNum_member(int num_member) {
	this.num_member = num_member;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public String getOS() {
	return OS;
}
public void setOS(String oS) {
	OS = oS;
}
public Date getVisit() {
	return visit;
}
public void setVisit(Date visit) {
	this.visit = visit;
}
@Override
public String toString() {
	return "LoginHistoryVO [num_member=" + num_member + ", ip=" + ip + ", OS=" + OS + ", visit=" + visit + "]";
}



}
