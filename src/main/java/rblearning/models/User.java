package rblearning.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="users")
public class User extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=150)
	private String name;
	
	@Column(nullable=false, length=150)
	private String email;
	
	@Column(nullable=false, length=50)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=15)
	private Role role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
