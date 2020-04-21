package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="customer")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="CUSTOMER_ID", 
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;
	
	@Column(name="renderedDelete")
	private String renderedDelete;
	
	@Column(name="customer_code")
	private String customerCode;
	
	@Column(name="head_office")
	private Boolean isHeadOffice;

	@Column(name="address", length = 500)
	private String address;

	@Column(name="attachments", length = 500)
	private String attachments;

	@Column(name="business_phone", length = 20)
	private String businessPhone;

	@Column(name="city", length = 100)
	private String city;

	@Column(name="company", length = 200)
	private String company;
	
	@Column(name="company_unit", length = 200)
	private String companyUnit;

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

	@Column(name="notes")
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

	@Column(name="create_user")
	private String createUser;
	
	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	private List<Order> orders;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Plants> plants;
	
	@ManyToOne
    @JoinColumn(name="main_customer_id")
    private Customer customer;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private Set<Customer> customers = new HashSet<Customer>();
    
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Formula> Formulas;
    
	public List<Formula> getFormulas() {
		return Formulas;
	}

	public void setFormulas(List<Formula> formulas) {
		Formulas = formulas;
	}

	public String getRenderedDelete() {
		return renderedDelete;
	}

	public void setRenderedDelete(String renderedDelete) {
		this.renderedDelete = renderedDelete;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCompanyUnit() {
		return companyUnit;
	}

	public void setCompanyUnit(String companyUnit) {
		this.companyUnit = companyUnit;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public List<Plants> getPlants() {
		return plants;
	}

	public void setPlants(List<Plants> plants) {
		this.plants = plants;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCountryRegion() {
		return countryRegion;
	}

	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getWebPage() {
		return webPage;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public String getZipPostalCode() {
		return zipPostalCode;
	}

	public void setZipPostalCode(String zipPostalCode) {
		this.zipPostalCode = zipPostalCode;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Boolean getIsHeadOffice() {
		return isHeadOffice;
	}

	public void setIsHeadOffice(Boolean isHeadOffice) {
		this.isHeadOffice = isHeadOffice;
	}
}
