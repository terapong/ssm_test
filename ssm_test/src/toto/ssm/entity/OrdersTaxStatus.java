package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders_tax_status database table.
 * 
 */
@Entity
@Table(name="orders_tax_status")
public class OrdersTaxStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="ORDERSTAXSTATUS_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;
	
	@Column(name="create_user")
	private String createUser;

	@Column(name="tax_status_name")
	private String taxStatusName;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="ordersTaxStatus", fetch=FetchType.EAGER)
	private List<Order> orders;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public OrdersTaxStatus() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getTaxStatusName() {
		return this.taxStatusName;
	}

	public void setTaxStatusName(String taxStatusName) {
		this.taxStatusName = taxStatusName;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
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

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setOrdersTaxStatus(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setOrdersTaxStatus(null);

		return order;
	}

}