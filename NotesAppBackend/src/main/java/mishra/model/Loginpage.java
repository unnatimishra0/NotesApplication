package mishra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Loginpage")
public class Loginpage{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="username")
	private String username;
	public boolean isValid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="password")
	private String password;
	public String  getUsername() {
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
	public Loginpage() {
//		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Loginpage [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	

}
