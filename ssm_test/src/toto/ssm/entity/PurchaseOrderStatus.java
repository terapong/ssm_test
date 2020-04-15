package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the purchase_order_status database table.
 * 
 */
@Entity
@Table(name="purchase_order_status")
public class PurchaseOrderStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="PURCHASEORDERSTATUS_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private int id;
	
	@Column(name="create_user")
	private String createUser;

	private String status;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;

	//bi-directional many-to-one association to PurchaseOrder
	@OneToMany(mappedBy="purchaseOrderStatus", fetch=FetchType.EAGER)
	private List<PurchaseOrder> purchaseOrders;

	public PurchaseOrderStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PurchaseOrder> getPurchaseOrders() {
		return this.purchaseOrders;
	}

	public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
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

	public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder) {
		getPurchaseOrders().add(purchaseOrder);
		purchaseOrder.setPurchaseOrderStatus(this);

		return purchaseOrder;
	}

	public PurchaseOrder removePurchaseOrder(PurchaseOrder purchaseOrder) {
		getPurchaseOrders().remove(purchaseOrder);
		purchaseOrder.setPurchaseOrderStatus(null);

		return purchaseOrder;
	}

}