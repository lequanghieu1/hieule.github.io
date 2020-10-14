package Weapon.Entity;

public class Users {
private long id;
private String user;
private String password;
private String displayname;
private String address;
private long id_role;
private Roles role;
public Users() {
	super();
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDisplayname() {
	return displayname;
}
public void setDisplayname(String displayname) {
	this.displayname = displayname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getId_role() {
	return id_role;
}
public void setId_role(long id_role) {
	this.id_role = id_role;
}
public Roles getRole() {
	return role;
}
public void setRole(Roles role) {
	this.role = role;
}


}
