package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the suppliers database table.
 * 
 */
@Entity
@Table(name="suppliers")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="SUPPLIER_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;
	
	@Column(name="create_user")
	private String createUser;

	private String address;

	private String attachments;

	@Column(name="business_phone")
	private String businessPhone;

	private String city;

	private String company;

	@Column(name="country_region")
	private String countryRegion;

	@Column(name="email_address")
	private String emailAddress;

	@Column(name="fax_number")
	private String faxNumber;

	@Column(name="first_name")
	private String firstName;

	@Column(name="home_phone")
	private String homePhone;

	@Column(name="job_title")
	private String jobTitle;

	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_phone")
	private String mobilePhone;

	private String notes;

	@Column(name="state_province")
	private String stateProvince;

	@Column(name="web_page")
	private String webPage;

	@Column(name="zip_postal_code")
	private String zipPostalCode;
	
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;

	//bi-directional many-to-one association to PurchaseOrder
	@OneToMany(mappedBy="supplier", fetch=FetchType.EAGER)
	private List<PurchaseOrder> purchaseOrders;

	public Supplier() {
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAttachments() {
		return this.attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getBusinessPhone() {
		return this.businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCountryRegion() {
		return this.countryRegion;
	}

	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getWebPage() {
		return this.webPage;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public String getZipPostalCode() {
		return this.zipPostalCode;
	}

	public void setZipPostalCode(String zipPostalCode) {
		this.zipPostalCode = zipPostalCode;
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
		purchaseOrder.setSupplier(this);

		return purchaseOrder;
	}

	public PurchaseOrder removePurchaseOrder(PurchaseOrder purchaseOrder) {
		getPurchaseOrders().remove(purchaseOrder);
		purchaseOrder.setSupplier(null);

		return purchaseOrder;
	}

}