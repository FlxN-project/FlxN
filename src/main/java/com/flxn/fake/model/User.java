package com.flxn.fake.model;

/**
 * Created by Gadzzzz on 24.03.2016.
 */
public class User {
	private int id;
	private String email;
	private String password;
	private String role;

	public User() {
	}

	public User(int id, String email, String password, String role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(String email, String password, String role) {
		this.id = -1;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static Builder getBuilder() {
		return new Builder();
	}

	public static class Builder{
		private int id = -1;
		private String email = "oda21101@mail.ru";
		private String password = "123";
		private String role = "USER_ROLE";

		public Builder id(int id){
			this.id = id;
			return this;
		}

		public Builder email(String email){
			this.email = email;
			return this;
		}

		public Builder password(String password){
			this.password = password;
			return this;
		}

		public Builder role(String role){
			this.role = role;
			return this;
		}

		public User build(){
			return new User(id,email,password,role);
		}
	}

}
