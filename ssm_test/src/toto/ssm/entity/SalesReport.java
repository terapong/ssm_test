package toto.ssm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the sales_reports database table.
 * 
 */
@Entity
@Table(name="sales_reports")
public class SalesReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="SALESREPORT_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;
	
	@Column(name="create_user")
	private String createUser;
	
	@Column(name="group_by")
	private String groupBy;

	@Column(name="defaultvalue")
	private String defaultValue;

	private String display;

	@Column(name="filter_row_source")
	private String filterRowSource;

	private String title;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;

	public SalesReport() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getGroupBy() {
		return this.groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	public String getDisplay() {
		return this.display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getFilterRowSource() {
		return this.filterRowSource;
	}

	public void setFilterRowSource(String filterRowSource) {
		this.filterRowSource = filterRowSource;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}