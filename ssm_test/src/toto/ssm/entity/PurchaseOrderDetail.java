package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the purchase_order_details database table.
 * 
 */
@Entity
@Table(name="purchase_order_details")
public class PurchaseOrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="PURCHASEORDERDETAIL_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;
	
	@Column(name="create_user")
	private String createUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_received")
	private Date dateReceived;

	@Column(name="posted_to_inventory")
	private String postedToInventory;

	private BigDecimal quantity;

	@Column(name="unit_cost")
	private BigDecimal unitCost;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;

	//bi-directional many-to-one association to InventoryTransaction
	@ManyToOne
	@JoinColumn(name="inventory_id")
	private InventoryTransaction inventoryTransaction;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to PurchaseOrder
	@ManyToOne
	@JoinColumn(name="purchase_order_id")
	private PurchaseOrder purchaseOrder;

	public PurchaseOrderDetail() {
	}

	public long getId() {
		return this.id;
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

	public Date getDateReceived() {
		return this.dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getPostedToInventory() {
		return this.postedToInventory;
	}

	public void setPostedToInventory(String postedToInventory) {
		this.postedToInventory = postedToInventory;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitCost() {
		return this.unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	public InventoryTransaction getInventoryTransaction() {
		return this.inventoryTransaction;
	}

	public void setInventoryTransaction(InventoryTransaction inventoryTransaction) {
		this.inventoryTransaction = inventoryTransaction;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PurchaseOrder getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
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