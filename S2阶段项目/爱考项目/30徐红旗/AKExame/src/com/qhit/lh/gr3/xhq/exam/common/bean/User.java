package com.qhit.lh.gr3.xhq.exam.common.bean;



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    
     private String name;
     private String pwd;
     private Integer role;


    // Constructors

	/** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String name, String pwd, Integer role) {
        this.name = name;
        this.pwd = pwd;
        this.role = role;
    }

   
    // Property accessors

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getRole() {
        return this.role;
    }
    
    public void setRole(Integer role) {
        this.role = role;
    }

}