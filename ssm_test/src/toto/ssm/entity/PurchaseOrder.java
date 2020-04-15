package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the purchase_orders database table.
 * 
 */
@Entity
@Table(name="purchase_orders")
public class PurchaseOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="PURCHASEORDER_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;
	
	@Column(name="create_user")
	private String createUser;

	@Column(name="approved_by")
	private int approvedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="approved_date")
	private Date approvedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expected_date")
	private Date expectedDate;

	private String notes;

	@Column(name="payment_amount")
	private BigDecimal paymentAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="payment_date")
	private Date paymentDate;

	@Column(name="payment_method")
	private String paymentMethod;

	@Column(name="shipping_fee")
	private BigDecimal shippingFee;

	@Column(name="submitted_by")
	private int submittedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="submitted_date")
	private Date submittedDate;

	private BigDecimal taxes;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;

	//bi-directional many-to-one association to InventoryTransaction
	@OneToMany(mappedBy="purchaseOrder", fetch=FetchType.EAGER)
	private List<InventoryTransaction> inventoryTransactions;

	//bi-directional many-to-one association to PurchaseOrderDetail
	@OneToMany(mappedBy="purchaseOrder", fetch=FetchType.EAGER)
	private List<PurchaseOrderDetail> purchaseOrderDetails;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="created_by")
	private Employee employee;

	//bi-directional many-to-one association to PurchaseOrderStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private PurchaseOrderStatus purchaseOrderStatus;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	private Supplier supplier;

	public PurchaseOrder() {
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

	public int getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpectedDate() {
		return this.expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BigDecimal getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
	}

	public int getSubmittedBy() {
		return this.submittedBy;
	}

	public void setSubmittedBy(int submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public BigDecimal getTaxes() {
		return this.taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
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
		inventoryTransaction.setPurchaseOrder(this);

		return inventoryTransaction;
	}

	public InventoryTransaction removeInventoryTransaction(InventoryTransaction inventoryTransaction) {
		getInventoryTransactions().remove(inventoryTransaction);
		inventoryTransaction.setPurchaseOrder(null);

		return inventoryTransaction;
	}

	public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
		return this.purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	public PurchaseOrderDetail addPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		getPurchaseOrderDetails().add(purchaseOrderDetail);
		purchaseOrderDetail.setPurchaseOrder(this);

		return purchaseOrderDetail;
	}

	public PurchaseOrderDetail removePurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		getPurchaseOrderDetails().remove(purchaseOrderDetail);
		purchaseOrderDetail.setPurchaseOrder(null);

		return purchaseOrderDetail;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PurchaseOrderStatus getPurchaseOrderStatus() {
		return this.purchaseOrderStatus;
	}

	public void setPurchaseOrderStatus(PurchaseOrderStatus purchaseOrderStatus) {
		this.purchaseOrderStatus = purchaseOrderStatus;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}