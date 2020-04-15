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
import toto.ssm.session.VaSession;

@ManagedBean(name = "dialyproductionreportbean")
@ViewScoped
public class DialyProductionReportBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Customer> master;
	private Customer selectedMaster;
	private long selectedMasterId;
	private List<Customer> subCustomer;
	private Customer selectedRow;
	
	private String addDisabled;
	private Calendar cal;
	
	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		master = session.querryAllHeaderOffice();
		if(master.isEmpty()) {
			addDisabled = "true";
		} else {
			addDisabled = "false";
			if(selectedMaster == null) {
				selectedMaster = master.get(0);
			}
			selectedMasterId = selectedMaster.getId();
			subCustomer = session.querryAllCustomerByMasterID(selectedMasterId);
		}
	}
	
	@PreDestroy
	private void destroy() {
		
	}
	
	public void selSubmanterChange() {
		
	}
	
	public void selMasterChange() {
		selectedMaster = session.querryCustomerById(selectedMasterId);
		selectedMasterId = selectedMaster.getId();
		subCustomer = session.querryAllCustomerByMasterID(selectedMasterId);
		
		System.out.println("subCustomer");
//		slave = selectedMaster.getEmployees();
//		for(Employee r : slave) {
//			if(r.getUserName().equals("admin")) {
//				r.setRenderedDelete("false");
//			} else {
//				r.setRenderedDelete("true");
//			}
//		}
	}
	
	public void btnNewClick() {
		System.out.println("btnNewClick");
	}
	
	public void btnSaveClick() {
		System.out.println("btnSaveClick");
	}

	public void btnEditClick(Customer o) {
		selectedRow = o;
	}
	
	public void confirmDeleteClick() {
		try {
			session.deleteCustomer(selectedRow);
			init();
		} catch(Exception ex) {
			FacesMessage msg = new FacesMessage();
			msg.setSummary("ไม่สามารถ ลบ ได้");
			msg.setDetail("ไม่สามารถ ลบ ได้ เพราะมี ข้อมูลที่เกี่ยวข้อง");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public void btnDeleteClick(Customer o) {
		selectedRow = o;
	}
	
	public List<Customer> getMaster() {
		return master;
	}

	public void setMaster(List<Customer> master) {
		this.master = master;
	}

	public Customer getSelectedMaster() {
		return selectedMaster;
	}

	public void setSelectedMaster(Customer selectedMaster) {
		this.selectedMaster = selectedMaster;
	}

	public long getSelectedMasterId() {
		return selectedMasterId;
	}

	public void setSelectedMasterId(long selectedMasterId) {
		this.selectedMasterId = selectedMasterId;
	}

	public List<Customer> getSubCustomer() {
		return subCustomer;
	}

	public void setSubCustomer(List<Customer> subCustomer) {
		this.subCustomer = subCustomer;
	}

	public Customer getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(Customer selectedRow) {
		this.selectedRow = selectedRow;
	}

	public String getAddDisabled() {
		return addDisabled;
	}

	public void setAddDisabled(String addDisabled) {
		this.addDisabled = addDisabled;
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
}
