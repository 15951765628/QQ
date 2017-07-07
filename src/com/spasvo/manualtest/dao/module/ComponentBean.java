package com.spasvo.manualtest.dao.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ComponentBean implements java.io.Serializable{
	private Integer pkId;
	private Integer projectId;
	private Integer runnerId;
	private String rootName;
	private String groupName;
	private String name;
	private Integer type;
	private Integer extendId;
	private Integer parentId;
	private Integer level;
	private String description;
	private String scriptName;
	private String dataName;
	private String version;
	private String createUser;
	private String createDate;
	private String tier;
	private Vector<String []> vt;//当脚本runID=4时存放脚本参数

	private List<ComponentBean> children;
	public List<ComponentBean> getChildren() {
		return children;
	}

	private ComponentBean extendsBean;
	public ComponentBean getExtendsBean() {
		return extendsBean;
	}
	public void setExtendsBean(ComponentBean extendsBean) {
		this.extendsBean = extendsBean;
	}
	public Integer getPkId() {
		return pkId;
	}
	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getRunnerId() {
		return runnerId;
	}
	public void setRunnerId(Integer runnerId) {
		this.runnerId = runnerId;
	}
	public String getRootName() {
		return rootName;
	}
	public void setRootName(String rootName) {
		this.rootName = rootName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getExtendId() {
		return extendId;
	}
	public void setExtendId(Integer extendId) {
		this.extendId = extendId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getScriptName() {
		return scriptName;
	}
	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public void addChild(ComponentBean value){
		if(children == null){
			children = new ArrayList<ComponentBean>();
		}
		children.add(value);
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public Vector<String[]> getVt() {
		return vt;
	}
	public void setVt(Vector<String[]> vt) {
		this.vt = vt;
	}
	
	
}
