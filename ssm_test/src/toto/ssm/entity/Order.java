package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="ORDER_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;
	
	@Column(name="create_user")
	private String createUser;

	@Column(name="notes")
	private String notes;
	
	@Column(name="recipe")
	private String recipe;
	
	@Column(name="qty")
	private String qty;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_date")
	private Date orderDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="paid_date")
	private Date paidDate;

	@Column(name="payment_type")
	private String paymentType;

	@Column(name="ship_address")
	private String shipAddress;

	@Column(name="ship_city")
	private String shipCity;

	@Column(name="ship_country_region")
	private String shipCountryRegion;

	@Column(name="ship_name")
	private String shipName;

	@Column(name="ship_state_province")
	private String shipStateProvince;

	@Column(name="ship_zip_postal_code")
	private String shipZipPostalCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="shipped_date")
	private Date shippedDate;

	@Column(name="shipping_fee")
	private BigDecimal shippingFee;

	@Column(name="tax_rate")
	private double taxRate;

	private BigDecimal taxes;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@Column(name="current_status")
	private Long currentStatus;
	
	@Column(name="order_no")
	private String orderNo;
	
	//bi-directional many-to-one association to InventoryTransaction
	@OneToMany(mappedBy="order", fetch=FetchType.EAGER)
	private List<InventoryTransaction> inventoryTransactions;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="order", fetch=FetchType.EAGER)
	private List<Invoice> invoices;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	private Customer customer;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="tax_status_id")
	private OrdersTaxStatus ordersTaxStatus;

	//bi-directional many-to-one association to Shipper
//	@ManyToOne
//	private Shipper shipper;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_detail_id")
	private List<OrderDetail> ordersDetail;
	
	public Order() {
	}

	public Long getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Long currentStatus) {
		this.currentStatus = currentStatus;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getPaidDate() {
		return this.paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getShipAddress() {
		return this.shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return this.shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipCountryRegion() {
		return this.shipCountryRegion;
	}

	public void setShipCountryRegion(String shipCountryRegion) {
		this.shipCountryRegion = shipCountryRegion;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getShipName() {
		return this.shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipStateProvince() {
		return this.shipStateProvince;
	}

	public void setShipStateProvince(String shipStateProvince) {
		this.shipStateProvince = shipStateProvince;
	}

	public String getShipZipPostalCode() {
		return this.shipZipPostalCode;
	}

	public void setShipZipPostalCode(String shipZipPostalCode) {
		this.shipZipPostalCode = shipZipPostalCode;
	}

	public Date getShippedDate() {
		return this.shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public BigDecimal getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
	}

	public double getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
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

	public InventoryTransaction addInventoryTransaction(InventoryTransaction inventoryTransaction) {
		getInventoryTransactions().add(inventoryTransaction);
		inventoryTransaction.setOrder(this);

		return inventoryTransaction;
	}

	public InventoryTransaction removeInventoryTransaction(InventoryTransaction inventoryTransaction) {
		getInventoryTransactions().remove(inventoryTransaction);
		inventoryTransaction.setOrder(null);

		return inventoryTransaction;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setOrder(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setOrder(null);

		return invoice;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.getOrderDetails();
	}

//	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
//		getOrderDetails().add(orderDetail);
//		orderDetail.setOrder(this);
//		return orderDetail;
//	}
//
//	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
//		getOrderDetails().remove(orderDetail);
//		orderDetail.setOrder(null);
//
//		return orderDetail;
//	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetail> getOrdersDetail() {
		return ordersDetail;
	}

	public void setOrdersDetail(List<OrderDetail> ordersDetail) {
		this.ordersDetail = ordersDetail;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public OrdersTaxStatus getOrdersTaxStatus() {
		return this.ordersTaxStatus;
	}

	public void setOrdersTaxStatus(OrdersTaxStatus ordersTaxStatus) {
		this.ordersTaxStatus = ordersTaxStatus;
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

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
}