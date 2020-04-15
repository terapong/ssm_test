package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the order_details database table.
 * 
 */
@Entity
@Table(name="order_details")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="ORDERDETAIL_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;

	@Column(name="create_user")
	private String createUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_allocated")
	private Date dateAllocated;

	private double discount;

	@Column(name="inventory_id")
	private int inventoryId;

	@Column(name="purchase_order_id")
	private int purchaseOrderId;

	private BigDecimal quantity;

	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;
	
//	@ManyToOne
//	@JoinColumn(name="shipper_id")
//	private Shipper shipper;

	//bi-directional many-to-one association to OrderDetailsStatus
//	@ManyToOne
//	@JoinColumn(name="status_id")
//	private OrderDetailsStatus orderDetailsStatus;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	//bi-directional many-to-one association to Product
//	@ManyToOne
//	private Product product;

	public OrderDetail() {
	}

	public long getId() {
		return this.id;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateAllocated() {
		return this.dateAllocated;
	}

	public void setDateAllocated(Date dateAllocated) {
		this.dateAllocated = dateAllocated;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getPurchaseOrderId() {
		return this.purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

//	public OrderDetailsStatus getOrderDetailsStatus() {
//		return this.orderDetailsStatus;
//	}
//
//	public void setOrderDetailsStatus(OrderDetailsStatus orderDetailsStatus) {
//		this.orderDetailsStatus = orderDetailsStatus;
//	}
//
//	public Order getOrder() {
//		return this.order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//	public Product getProduct() {
//		return this.product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

//	public Shipper getShipper() {
//		return shipper;
//	}

//	public void setShipper(Shipper shipper) {
//		this.shipper = shipper;
//	}

}