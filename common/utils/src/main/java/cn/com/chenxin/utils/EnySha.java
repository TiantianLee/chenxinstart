package cn.com.chenxin.utils;

import java.security.MessageDigest;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class EnySha {
	public static String gcode(String msg){
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-512"); 
	        byte[] digest = md.digest(msg.getBytes());  
	        
	        return new HexBinaryAdapter().marshal(digest);
		}
		catch(Exception e){
			return "NULL";
		}
	}
	
}
