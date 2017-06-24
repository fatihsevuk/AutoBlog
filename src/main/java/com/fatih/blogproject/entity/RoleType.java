package com.fatih.blogproject.entity;

public enum RoleType {
	  USER("USER"),
	  DBA("DBA"),
	  ADMIN("ADMIN");
	     
	    String userProfileType;
	     
	    private RoleType(String userProfileType){
	        this.userProfileType = userProfileType;
	    }
	     
	    public String getUserProfileType(){
	        return userProfileType;
	    }
}
