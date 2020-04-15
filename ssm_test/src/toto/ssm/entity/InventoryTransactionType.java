package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the inventory_transaction_types database table.
 * 
 */
@Entity
@Table(name="inventory_transaction_types")
public class InventoryTransactionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="INVENTORYTRANSACTIONTYPE_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	//private byte id;
	private long id;

	@Column(name="create_user")
	private String createUser;
	
	@Column(name="type_name")
	private String typeName;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;

	//bi-directional many-to-one association to InventoryTransaction
	@OneToMany(mappedBy="inventoryTransactionType", fetch=FetchType.EAGER)
	private List<InventoryTransaction> inventoryTransactions;

	public InventoryTransactionType() {
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

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
		inventoryTransaction.setInventoryTransactionType(this);

		return inventoryTransaction;
	}

	public InventoryTransaction removeInventoryTransaction(InventoryTransaction inventoryTransaction) {
		getInventoryTransactions().remove(inventoryTransaction);
		inventoryTransaction.setInventoryTransactionType(null);

		return inventoryTransaction;
	}

}