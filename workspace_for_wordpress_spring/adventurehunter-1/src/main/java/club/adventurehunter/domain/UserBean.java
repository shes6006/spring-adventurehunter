package club.adventurehunter.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.util.*;
	
@Entity
@Table(name = "wp_user")
@Data
public class UserBean {
	@Id
	private String ID;
	private String user_login;
	private byte[] user_pass;
	private String user_nicename;
	private String email;
	private Date birth;
	private String user_url;
	private Date user_registered;
	private String user_activation_key;
	private Integer user_status;
	private String display_name;

}