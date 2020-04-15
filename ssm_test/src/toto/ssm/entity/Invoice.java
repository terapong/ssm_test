package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the invoices database table.
 * 
 */
@Entity
@Table(name="invoices")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="INVOICE_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;

	@Column(name="create_user")
	private String createUser;
	
	@Column(name="amount_due")
	private BigDecimal amountDue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="due_date")
	private Date dueDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="invoice_date")
	private Date invoiceDate;

	private BigDecimal shipping;

	private BigDecimal tax;

	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;
	
	//bi-directional many-to-one association to Order
	@ManyToOne
	private Order order;

	public Invoice() {
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

	public BigDecimal getAmountDue() {
		return this.amountDue;
	}

	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public BigDecimal getShipping() {
		return this.shipping;
	}

	public void setShipping(BigDecimal shipping) {
		this.shipping = shipping;
	}

	public BigDecimal getTax() {
		return this.tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
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