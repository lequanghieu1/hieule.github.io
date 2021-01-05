package Weapon.Entity;

import java.sql.Date;

public class Bills {
private long id;
private String user;
private String phone;
private String displayname;
private String address;
private double total;
private int quanty;
private String note;
private Date date;
public Bills() {
	super();
}
public long getId() {
	return id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
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
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
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
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public int getQuanty() {
	return quanty;
}
public void setQuanty(int quanty) {
	this.quanty = quanty;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}

}
