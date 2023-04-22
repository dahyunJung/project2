package VO;

import java.sql.Date;

public class LoginHistoryVO {
	private String id, deviceOS, ip;
	private Date loginDate;
	
	public LoginHistoryVO() {
		
	}
	public LoginHistoryVO(String id, String deviceOS, String ip, Date loginDate) {
		this.id = id;
		this.deviceOS = deviceOS;
		this.ip = ip;
		this.loginDate = loginDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeviceOS() {
		return deviceOS;
	}
	public void setDeviceOS(String deviceOS) {
		this.deviceOS = deviceOS;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	@Override
	public String toString() {
		return "LoginHistoryVO [id=" + id + ", deviceOS=" + deviceOS + ", ip=" + ip + ", loginDate=" + loginDate + "]";
	}



	

}
