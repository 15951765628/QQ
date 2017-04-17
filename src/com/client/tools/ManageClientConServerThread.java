/**
 * 这是一个管理客户端和服务器保持通讯的线程类
 * 
 */
package com.client.tools;

import java.util.HashMap;

public class ManageClientConServerThread {
	
	private static HashMap hm=new HashMap<String,ClientConServerThread>();
	
	//把创建好的ClientConServerThread放到hm
	public static void addClientConServerThread(String qqid,ClientConServerThread ccst){
		hm.put(qqid, ccst);
		
	}
	
	//通过qqid过去该线程
	public static ClientConServerThread getClientConServerThread(String qqId){
		return (ClientConServerThread)hm.get(qqId);
	}
}
