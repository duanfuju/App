package com.junl.apps.model;

public class UserModel {

	
	private String ids;
	private String username;
	private byte[] password;
	private byte[] salt;
	private String groupids;
	private String groupnames;
	private String status;
	private String phoneRole;
	
	
	
	public String getPhoneRole() {
		return phoneRole;
	}
	public void setPhoneRole(String phoneRole) {
		this.phoneRole = phoneRole;
	}
	public String getGroupnames() {
		return groupnames;
	}
	public void setGroupnames(String groupnames) {
		this.groupnames = groupnames;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGroupids() {
		return groupids;
	}
	public void setGroupids(String groupids) {
		this.groupids = groupids;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	
}
