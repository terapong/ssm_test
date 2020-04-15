package toto.ssm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the privileges database table.
 * 
 */
@Entity
@Table(name="privileges")
public class Privilege implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="PRIVILEGE_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;

	@Column(name="create_user")
	private String createUser;
	
	@Column(name="privilege_name")
	private String privilegeName;

	@Column(name="renderedDelete")
	private String renderedDelete;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@OneToMany(mappedBy = "privilege", fetch = FetchType.EAGER)
	private List<Employee> employees;
	
	public Privilege() {
	}

	public long getId() {
		return id;
	}

	void setId(long id) {
		this.id = id;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getPrivilegeName() {
		return this.privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getRenderedDelete() {
		return renderedDelete;
	}

	public void setRenderedDelete(String renderedDelete) {
		this.renderedDelete = renderedDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}