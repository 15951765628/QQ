/**
 * 管理好友，黑名单，陌生人  界面类
 * 
 */

package com.client.tools;

import java.util.HashMap;

import com.client.view.List;

public class ManageList {

	private static HashMap hm=new HashMap<String ,List>();
	
	public static void addList(String id ,List list){
		hm.put(id, list);
	}
	
	public static List getList(String id){
		return (List)hm.get(id);
	}
}
