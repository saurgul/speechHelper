package com.speechhelper.databasemanager;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserEntity{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="userId")
  private Long userId;
  
  @Column(name="userName")
  private String userName;
  
  @Column(name="password")
  private String password;
  
  @Column(name="name")
  private String name;
  
  @Column(name="age")
  private int age;

  public UserEntity() {}

  @Override
  public String toString() {
    return String.format(
        "User[userId=%d, userName='%s', password='%s', name='%s', age='%d']",
        userId, userName, password, name, age);
  }

  public Long getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
	  this.name = name;
  }


	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

