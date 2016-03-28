package com.flxn.fake.model;

/**
 * Created by Gadzzzz on 24.03.2016.
 */
public class User {
	private int id;
	private String email;
	private String password;

	public User() {
	}

	public User(int id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public User(String email, String password) {
		this.id = -1;
		this.email = email;
		this.password = password;
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

	public static Builder getBuilder() {
		return new Builder();
	}

	public static class Builder{
		private int id = -1;
		private String email = "oda21101@mail.ru";
		private String password = "123";

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

		public User build(){return new User(id,email,password);
		}
	}

}
