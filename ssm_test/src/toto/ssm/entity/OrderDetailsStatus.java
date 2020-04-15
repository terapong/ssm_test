package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="order_details_status")
public class OrderDetailsStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="ORDERSDETAILSTATUS_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;
	
	public long getId() {
		return id;
	}
	
	@Column(name="create_user")
	private String createUser;

	@Column(name="status_name")
	private String statusName;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;


	public void setId(long id) {
		this.id = id;
	}


	public String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
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
