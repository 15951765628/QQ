package com.hibernate.mapping;

import java.util.Date;

public class UserTable implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6875858512233088310L;
	
	private Integer id;
	private String username;
	private String realname;
	private String password;
	private String email;
	private String phone;
	private String mobile;
	private Date dateCreated;
	private Date lastVisit;
	private Short enabled;
	private Short protected_;
	private Short accessLevel;
	private StringBuffer accessLevelValue;
	private Integer loginCount;
	private Short lostPasswordRequestCount;
	private Short failedLoginCount;
	private Integer currentProjectId;
	private Integer isBookMail;
	private Integer projectRole;
	private Integer defaultPM;
	private Integer manager; //项目管理员
	// Constructors

	public Integer getIsBookMail() {
		return isBookMail;
	}

	public void setIsBookMail(Integer isBookMail) {
		this.isBookMail = isBookMail;
	}

	/** default constructor */
	public UserTable() {
	}

	/** full constructor */
	public UserTable(String username, String realname, String password,
			String email, String phone, String mobile, Date dateCreated,
			Date lastVisit, Short enabled, Short protected_, Short accessLevel,
			Integer loginCount, Short lostPasswordRequestCount,
			Short failedLoginCount, Integer currentProjectId) {
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.mobile = mobile;
		this.dateCreated = dateCreated;
		this.lastVisit = lastVisit;
		this.enabled = enabled;
		this.protected_ = protected_;
		this.accessLevel = accessLevel;
		this.loginCount = loginCount;
		this.lostPasswordRequestCount = lostPasswordRequestCount;
		this.failedLoginCount = failedLoginCount;
		this.currentProjectId = currentProjectId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastVisit() {
		return this.lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public Short getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}

	public Short getProtected_() {
		return this.protected_;
	}

	public void setProtected_(Short protected_) {
		this.protected_ = protected_;
	}

	public Short getAccessLevel() {
		return this.accessLevel;
	}

	public void setAccessLevel(Short accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Short getLostPasswordRequestCount() {
		return this.lostPasswordRequestCount;
	}

	public void setLostPasswordRequestCount(Short lostPasswordRequestCount) {
		this.lostPasswordRequestCount = lostPasswordRequestCount;
	}

	public Short getFailedLoginCount() {
		return this.failedLoginCount;
	}

	public void setFailedLoginCount(Short failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	public Integer getCurrentProjectId() {
		return currentProjectId;
	}

	public void setCurrentProjectId(Integer currentProjectId) {
		this.currentProjectId = currentProjectId;
	}

	public String getAccessLevelValue() {
		if(this.accessLevelValue == null)
			return "";
		if(this.accessLevelValue.length()>0)
			this.accessLevelValue.deleteCharAt(this.accessLevelValue.length()-1);
		return accessLevelValue.toString();
	}

	public void setAccessLevelValue(String accessLevelValue) {
		if(this.accessLevelValue == null){
			this.accessLevelValue = new StringBuffer();
		}
		this.accessLevelValue.append(accessLevelValue).append(";");
	}

	public Integer getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(Integer projectRole) {
		this.projectRole = projectRole;
	}

	public Integer getDefaultPM() {
		return defaultPM;
	}

	public void setDefaultPM(Integer defaultPM) {
		this.defaultPM = defaultPM;
	}	
	
	public Integer getManager() {
		return manager == null? 0:manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}	
	
}