package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the inventory_transactions database table.
 * 
 */
@Entity
@Table(name="inventory_transactions")
public class InventoryTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="INVENTORYTRANSACTION_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")

	private long id;

	private String comments;

	private int quantity;
	
	@Column(name="create_user")
	private String createUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_created_date")
	private Date transactionCreatedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_modified_date")
	private Date transactionModifiedDate;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;

	//bi-directional many-to-one association to InventoryTransactionType
	@ManyToOne
	@JoinColumn(name="transaction_type")
	private InventoryTransactionType inventoryTransactionType;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="customer_order_id")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to PurchaseOrder
	@ManyToOne
	@JoinColumn(name="purchase_order_id")
	private PurchaseOrder purchaseOrder;

	//bi-directional many-to-one association to PurchaseOrderDetail
	@OneToMany(mappedBy="inventoryTransaction", fetch=FetchType.EAGER)
	private List<PurchaseOrderDetail> purchaseOrderDetails;

	public InventoryTransaction() {
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

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getTransactionCreatedDate() {
		return this.transactionCreatedDate;
	}

	public void setTransactionCreatedDate(Date transactionCreatedDate) {
		this.transactionCreatedDate = transactionCreatedDate;
	}

	public Date getTransactionModifiedDate() {
		return this.transactionModifiedDate;
	}

	public void setTransactionModifiedDate(Date transactionModifiedDate) {
		this.transactionModifiedDate = transactionModifiedDate;
	}

	public InventoryTransactionType getInventoryTransactionType() {
		return this.inventoryTransactionType;
	}

	public void setInventoryTransactionType(InventoryTransactionType inventoryTransactionType) {
		this.inventoryTransactionType = inventoryTransactionType;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
		return this.purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
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

	public PurchaseOrderDetail addPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		getPurchaseOrderDetails().add(purchaseOrderDetail);
		purchaseOrderDetail.setInventoryTransaction(this);

		return purchaseOrderDetail;
	}

	public PurchaseOrderDetail removePurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		getPurchaseOrderDetails().remove(purchaseOrderDetail);
		purchaseOrderDetail.setInventoryTransaction(null);

		return purchaseOrderDetail;
	}

}