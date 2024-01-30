package model;

public class User {
	
	
	private int uid;
	private String uname;
	private String upass;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int uid, String uname, String upass) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
	}


	public User(String uname, String upass) {
		super();
		this.uname = uname;
		this.upass = upass;
	}
	
	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUpass() {
		return upass;
	}


	public void setUpass(String upass) {
		this.upass = upass;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upass=" + upass + "]";
	}


	
}
