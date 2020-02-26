package kth.iv1201.grupp10.recruitmentApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Siavash
 * Represents the role-table in the relational database.
 * Used with to store and load from the database using jpa.
 */
@Entity
@Table(name="role")
public class RoleEntity {
	@Id
	@Column(unique = true)
	private int role_id;
	private String name;

	/**
	 * Creates a role entity and sets the role name based on the role id.
	 * @param role_id
	 */
	public RoleEntity(int role_id) {
		this.setRole_id(role_id);
		switch(role_id) {
		case(1):
			this.setName("recruit");
			break;
		case(2):
			this.setName("applicant");
			break;
		default:
			break;
		}
	}

	public RoleEntity() {

	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getRole_id() {
		return role_id;
	}
	
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
}