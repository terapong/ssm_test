package toto.ssm.jsf;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import toto.ssm.entity.Customer;
import toto.ssm.entity.Formula;
import toto.ssm.session.VaSession;

@ManagedBean(name = "formulabean")
@ViewScoped
public class FormulaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Formula> master;
	private List<Formula> slave;
	private List<Customer> customers;
	private Customer selectedCustomer;
	private Long selectedCustomerID;
	private Formula selectedRow;
	private Calendar cal;
	
	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		customers = session.querryAllCustomer();
		selectedCustomer = customers.get(0);
		selectedCustomerID = selectedCustomer.getId();
		master = session.querryAllMainFormularByCustomerID(selectedCustomerID);
		
//		for(Formula m : master) {
//			slave = session.querryAllFormularByMasterID(m.getId());
//			if(slave.isEmpty()) {
//				m.setRenderedDelete("true");
//			} else {
//				m.setRenderedDelete("false");
//			}
//		}
	}

	@PreDestroy
	private void destroy() {
		
	}
	
	public void btnNewClick() {
		selectedRow = new Formula();
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
		selectedRow.setIsMain(true);
		selectedRow.setCustomer(selectedCustomer);
	}
	
	public void btnSaveClick() {
		selectedRow.setUpdateDate(cal.getTime());
		session.updateFormula(selectedRow);
		master = session.querryAllMainFormularByCustomerID(selectedCustomerID);
		//init();
	}
	
	public void btnEditClick(Formula o) {
		selectedRow = o;
	}
	
	public void btnDeleteClick(Formula o) {
		selectedRow = o;
	}
	
	public void confirmDeleteClick() {
		try {
			session.deleteFormula(selectedRow);
			init();
		} catch(Exception ex) {
			FacesMessage msg = new FacesMessage();
			msg.setSummary("ไม่สามารถ ลบ ได้");
			msg.setDetail("ไม่สามารถ ลบ ได้ เพราะมี ข้อมูลที่เกี่ยวข้อง");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public void selCustomerChange() {
		selectedCustomer = session.querryCustomerById(selectedCustomerID);
		selectedCustomerID = selectedCustomer.getId();
		master = session.querryAllMainFormularByCustomerID(selectedCustomerID);
		
//		masters = session.querryAllFormularByMasterID(id)
//		for(Employee r : slave) {
//			if(r.getUserName().equals("admin")) {
//				r.setRenderedDelete("false");
//			} else {
//				r.setRenderedDelete("true");
//			}
//		}
	}

	public VaSessionbean getVasessionbean() {
		return vasessionbean;
	}

	public void setVasessionbean(VaSessionbean vasessionbean) {
		this.vasessionbean = vasessionbean;
	}

	public VaSession getSession() {
		return session;
	}

	public void setSession(VaSession session) {
		this.session = session;
	}

	public Formula getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(Formula selectedRow) {
		this.selectedRow = selectedRow;
	}

	public List<Formula> getMaster() {
		return master;
	}

	public void setMaster(List<Formula> master) {
		this.master = master;
	}

	public List<Formula> getSlave() {
		return slave;
	}

	public void setSlave(List<Formula> slave) {
		this.slave = slave;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}

	public Long getSelectedCustomerID() {
		return selectedCustomerID;
	}

	public void setSelectedCustomerID(Long selectedCustomerID) {
		this.selectedCustomerID = selectedCustomerID;
	}
}
