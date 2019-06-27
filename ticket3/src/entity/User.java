package entity;
/**
 * 用户类
 * @author Mr.DU
 * @date: 2019-06-24
 */
public class User {
	// uid
	private int id;
	// 用户名
	private String loginname;
	// 密码
	private String password;
	// 姓名
	private String username;
	// 身份证号
	private String identity;
	// 性别
	private String sex;
	// 手机号
	private String phone;
	// 电子邮箱
	private String email;
	// 地址
	private String address;
	//旅行社名字
	private String tra_name;
	//出发地
	private String start_place;
	//目的地
	private String end_place;
	//出发时间
	private String takeoff_time;

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTra_name() {
		return tra_name;
	}

	public void setTra_name(String tra_name) {
		this.tra_name = tra_name;
	}

	public String getStart_place() {
		return start_place;
	}

	public void setStart_place(String start_place) {
		this.start_place = start_place;
	}

	public String getEnd_place() {
		return end_place;
	}

	public void setEnd_place(String end_place) {
		this.end_place = end_place;
	}

	public String getTakeoff_time() {
		return takeoff_time;
	}

	public void setTakeoff_time(String takeoff_time) {
		this.takeoff_time = takeoff_time;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginname=" + loginname + ", password=" + password + ", username=" + username
				+ ", identity=" + identity + ", sex=" + sex + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", tra_name=" + tra_name + ", start_place=" + start_place + ", end_place=" + end_place
				+ ", takeoff_time=" + takeoff_time + "]";
	}
	
	
	
	
}
