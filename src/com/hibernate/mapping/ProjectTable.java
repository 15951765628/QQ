package com.hibernate.mapping;

import java.util.Date;

public class ProjectTable implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;// 项目名
	private Short status;// 状态
	private Short enabled;// 是否启用
	private Short viewState;
	private Short accessMin;
	private String description;// 备注
	private Date createDate;
	private Integer workflow;
	private Integer manager;
	
	//新增属性
	private String pro_code; // 项目编码
	private String pro_info;// 项目介绍
	private Integer pro_type;// 项目类型
	private Integer pro_scope;// 项目规模
	private Integer pro_parent_system;// 所属系统
	private String pro_pm;// 项目经理
	private String pro_pm_phone;// 项目经理电话
	private Integer pro_test_type;// 测试类型
	private String pro_planBeginTime;// 测试计划开始时间
	private String pro_planEndTime;// 测试计划结束时间
	private String pro_testResouce;// 测试预估资源
	private String pro_testManager;// 测试经理
	private String pro_tm_phone;// 测试经理电话
	private String pro_beginTime;// 实际开始测试时间
	private String pro_endTime;// 实际结束测试时间
	private Integer pro_person_number;// 实际人数
	private String pro_req_code;// 需求代码

	// Constructors

	public String getPro_code() {
		return pro_code;
	}

	public void setPro_code(String proCode) {
		pro_code = proCode;
	}

	public String getPro_info() {
		return pro_info;
	}

	public void setPro_info(String proInfo) {
		pro_info = proInfo;
	}

	public Integer getPro_type() {
		return pro_type;
	}

	public void setPro_type(Integer proType) {
		pro_type = proType;
	}

	public Integer getPro_scope() {
		return pro_scope;
	}

	public void setPro_scope(Integer proScope) {
		pro_scope = proScope;
	}

	public Integer getPro_parent_system() {
		return pro_parent_system;
	}

	public void setPro_parent_system(Integer proParentSystem) {
		pro_parent_system = proParentSystem;
	}

	public String getPro_pm() {
		return pro_pm;
	}

	public void setPro_pm(String proPm) {
		pro_pm = proPm;
	}

	public String getPro_pm_phone() {
		return pro_pm_phone;
	}

	public void setPro_pm_phone(String proPmPhone) {
		pro_pm_phone = proPmPhone;
	}

	public Integer getPro_test_type() {
		return pro_test_type;
	}

	public void setPro_test_type(Integer proTestType) {
		pro_test_type = proTestType;
	}

	public String getPro_testResouce() {
		return pro_testResouce;
	}

	public void setPro_testResouce(String proTestResouce) {
		pro_testResouce = proTestResouce;
	}

	public String getPro_testManager() {
		return pro_testManager;
	}

	public void setPro_testManager(String proTestManager) {
		pro_testManager = proTestManager;
	}

	public String getPro_tm_phone() {
		return pro_tm_phone;
	}

	public void setPro_tm_phone(String proTmPhone) {
		pro_tm_phone = proTmPhone;
	}


	public String getPro_planBeginTime() {
		return pro_planBeginTime;
	}

	public void setPro_planBeginTime(String proPlanBeginTime) {
		pro_planBeginTime = proPlanBeginTime;
	}

	public String getPro_planEndTime() {
		return pro_planEndTime;
	}

	public void setPro_planEndTime(String proPlanEndTime) {
		pro_planEndTime = proPlanEndTime;
	}

	public String getPro_beginTime() {
		return pro_beginTime;
	}

	public void setPro_beginTime(String proBeginTime) {
		pro_beginTime = proBeginTime;
	}

	public String getPro_endTime() {
		return pro_endTime;
	}

	public void setPro_endTime(String proEndTime) {
		pro_endTime = proEndTime;
	}


	public String getPro_req_code() {
		return pro_req_code;
	}

	public void setPro_req_code(String proReqCode) {
		pro_req_code = proReqCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/** default constructor */
	public ProjectTable() {
	}

	/** full constructor */
	public ProjectTable(String name, Short status, Short enabled,
			Short viewState, Short accessMin, String description,
			Integer workflow) {
		this.name = name;
		this.status = status;
		this.enabled = enabled;
		this.viewState = viewState;
		this.accessMin = accessMin;
		this.description = description;
		this.workflow = workflow;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}

	public Short getViewState() {
		return this.viewState;
	}

	public void setViewState(Short viewState) {
		this.viewState = viewState;
	}

	public Short getAccessMin() {
		return this.accessMin;
	}

	public void setAccessMin(Short accessMin) {
		this.accessMin = accessMin;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Integer workflow) {
		this.workflow = workflow;
	}

	public Integer getPro_person_number() {
		return pro_person_number;
	}

	public void setPro_person_number(Integer proPersonNumber) {
		pro_person_number = proPersonNumber;
	}
	
	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}
	
}