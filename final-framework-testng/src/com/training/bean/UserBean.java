package com.training.bean;

import org.testng.annotations.Test;

public class UserBean {
	private String firstname, lastname , email, profile, username , password, passwordConfirm, language;
	
	public  UserBean() {
	}
	
	public UserBean(String firstname,String lastname ,String email,String profile,String username ,String password,String passwordConfirm,String language) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.profile = profile;
			this.username = username;
			this.password = password;
			this.passwordConfirm = passwordConfirm;
			this.language = language;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getProfile() {
			return profile;
		}

		public void setProfile(String profile) {
			this.profile = profile;
		}
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getPasswordConfirm() {
			return passwordConfirm;
		}

		public void setPasswordConfirm(String confirmPassword) {
			this.passwordConfirm = confirmPassword;
		}
		
		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}
		
		@Override
		public String toString() {
			return "UserBean [firstname =" +firstname + ", lastname= "+lastname+", email ="+email+", profile= " +profile+ ", username = "+username+ ", password = "+password + ", passwordConfirm = "+passwordConfirm+", language =" + language+"]";
		}
}

