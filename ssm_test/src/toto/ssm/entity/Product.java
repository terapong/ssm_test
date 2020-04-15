package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="PRODUCT_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;
	
	@Column(name="create_user")
	private String createUser;

	private String attachments;

	private String category;

	private String description;

	private String discontinued;

	@Column(name="list_price")
	private BigDecimal listPrice;

	@Column(name="minimum_reorder_quantity")
	private int minimumReorderQuantity;

	@Column(name="product_code")
	private String productCode;

	@Column(name="product_name")
	private String productName;

	@Column(name="quantity_per_unit")
	private String quantityPerUnit;

	@Column(name="reorder_level")
	private int reorderLevel;

	@Column(name="standard_cost")
	private BigDecimal standardCost;

	@Column(name="supplier_ids")
	private String supplierIds;

	@Column(name="target_level")
	private int targetLevel;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;

	//bi-directional many-to-one association to InventoryTransaction
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<InventoryTransaction> inventoryTransactions;

	//bi-directional many-to-one association to OrderDetail
//	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
//	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to PurchaseOrderDetail
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<PurchaseOrderDetail> purchaseOrderDetails;

	public Product() {
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

	public String getAttachments() {
		return this.attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiscontinued() {
		return this.discontinued;
	}

	public void setDiscontinued(String discontinued) {
		this.discontinued = discontinued;
	}

	public BigDecimal getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public int getMinimumReorderQuantity() {
		return this.minimumReorderQuantity;
	}

	public void setMinimumReorderQuantity(int minimumReorderQuantity) {
		this.minimumReorderQuantity = minimumReorderQuantity;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityPerUnit() {
		return this.quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public int getReorderLevel() {
		return this.reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public BigDecimal getStandardCost() {
		return this.standardCost;
	}

	public void setStandardCost(BigDecimal standardCost) {
		this.standardCost = standardCost;
	}

	public String getSupplierIds() {
		return this.supplierIds;
	}

	public void setSupplierIds(String supplierIds) {
		this.supplierIds = supplierIds;
	}

	public int getTargetLevel() {
		return this.targetLevel;
	}

	public void setTargetLevel(int targetLevel) {
		this.targetLevel = targetLevel;
	}

	public List<InventoryTransaction> getInventoryTransactions() {
		return this.inventoryTransactions;
	}

	public void setInventoryTransactions(List<InventoryTransaction> inventoryTransactions) {
		this.inventoryTransactions = inventoryTransactions;
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

	public InventoryTransaction addInventoryTransaction(InventoryTransaction inventoryTransaction) {
		getInventoryTransactions().add(inventoryTransaction);
		inventoryTransaction.setProduct(this);

		return inventoryTransaction;
	}

	public InventoryTransaction removeInventoryTransaction(InventoryTransaction inventoryTransaction) {
		getInventoryTransactions().remove(inventoryTransaction);
		inventoryTransaction.setProduct(null);

		return inventoryTransaction;
	}

//	public List<OrderDetail> getOrderDetails() {
//		return this.orderDetails;
//	}
//
//	public void setOrderDetails(List<OrderDetail> orderDetails) {
//		this.orderDetails = orderDetails;
//	}
//
//	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
//		getOrderDetails().add(orderDetail);
//		orderDetail.setProduct(this);
//
//		return orderDetail;
//	}
//
//	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
//		getOrderDetails().remove(orderDetail);
//		orderDetail.setProduct(null);
//
//		return orderDetail;
//	}

	public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
		return this.purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	public PurchaseOrderDetail addPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		getPurchaseOrderDetails().add(purchaseOrderDetail);
		purchaseOrderDetail.setProduct(this);

		return purchaseOrderDetail;
	}

	public PurchaseOrderDetail removePurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		getPurchaseOrderDetails().remove(purchaseOrderDetail);
		purchaseOrderDetail.setProduct(null);

		return purchaseOrderDetail;
	}

}