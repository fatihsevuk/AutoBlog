package com.fatih.blogproject.utility;
import org.mindrot.jbcrypt.BCrypt;

public class Hashing {
	
	private static int workload=12;
	
	public static String hashPassword(String password){
		
		String salt=BCrypt.gensalt(workload);
		
		String hashedPassword=BCrypt.hashpw(password, salt);
		
		return hashedPassword;
		
	}
	
	
	public static boolean checkPassword(String password, String stored_hash) {
		boolean passwordVerified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		passwordVerified = BCrypt.checkpw(password, stored_hash);

		return passwordVerified;
	}
	

}
