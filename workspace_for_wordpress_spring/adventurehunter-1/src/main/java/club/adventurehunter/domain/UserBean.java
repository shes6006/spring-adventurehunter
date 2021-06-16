package club.adventurehunter.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.util.*;
	
@Entity
@Table(name = "wp_users")
@Data
public class UserBean {
	
	private Long ID;
	@Id
	private String user_login;
	private String user_pass;
	private String user_nicename;
	private String user_email;
	private Date birth;
	private String user_url;
	private Date user_registered;
	private String user_activation_key;
	private Integer user_status;
	private String display_name;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getUserß_login() {
		return user_login;
	}
	public void setUserß_login(String userß_login) {
		this.user_login = userß_login;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getUser_nicename() {
		return user_nicename;
	}
	public void setUser_nicename(String user_nicename) {
		this.user_nicename = user_nicename;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getUser_url() {
		return user_url;
	}
	public void setUser_url(String user_url) {
		this.user_url = user_url;
	}
	public Date getUser_registered() {
		return user_registered;
	}
	public void setUser_registered(Date user_registered) {
		this.user_registered = user_registered;
	}
	public String getUser_activation_key() {
		return user_activation_key;
	}
	public void setUser_activation_key(String user_activation_key) {
		this.user_activation_key = user_activation_key;
	}
	public Integer getUser_status() {
		return user_status;
	}
	public void setUser_status(Integer user_status) {
		this.user_status = user_status;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

}