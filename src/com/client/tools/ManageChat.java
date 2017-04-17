
//管理聊天界面的类
package com.client.tools;

import java.util.HashMap;

import com.client.view.*;
public class ManageChat {

	private static HashMap hm=new HashMap<String,Chat>();
	
	//加入
	public static void addChat(String loginIdAndFriendId,Chat chat){
		hm.put(loginIdAndFriendId, chat);
	}
	//取出
	public static Chat getChat(String loginIdAndFriendId){
		return (Chat)hm.get(loginIdAndFriendId);
	}
}
