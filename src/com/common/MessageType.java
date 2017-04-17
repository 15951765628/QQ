/*
 *定义包的种类
 */
package com.common;

public interface MessageType {
	String mes_succeed="1";//成功
	String mes_login_fail="2";//登录失败
	String mes_comm_mes="3";//普通信息包
	String mes_get_onLineFriends="4";//要求在线好友列表
	String mes_ret_onLoneFriends="5";//返回在线好友
	
	
}
