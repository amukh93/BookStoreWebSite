package com.bookstore.entity2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (schema = "bookstoredb",name = "users")
public class Users {

		private Integer userId;
		private String email;
		private String password;
		private String fullName;
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column (name = "user_id") 
		public Integer getUserId() {
			return userId;
		}
		
		@Column (name = "email")
		public String getEmail() {
			return email;
		}
		
		@Column (name = "password")
		public String getPassword() {
			return password;
		}
		
		@Column (name = "full_name")
		public String getFullName() {
			return fullName;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		
		
}
