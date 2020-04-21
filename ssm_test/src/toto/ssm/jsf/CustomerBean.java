package toto.ssm.jsf;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import toto.ssm.entity.*;
import toto.ssm.session.VaSession;

@ManagedBean(name = "customerbean")
@ViewScoped
public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Customer> master;
	private List<Customer> slave;
	private List<Plants> plants;
	private Plants selectedPlan;
	private Customer selectedRow;
	private Calendar cal;
	
	private String renderedDelete;
	
	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		/*
		slave = session.querryAllPrivilege();
		for(Privilege r : slave) {
			if(r.getEmployees().isEmpty()) {
				r.setRenderedDelete("true");
			} else {
				r.setRenderedDelete("false");
			}
		}
		 */
		
		master = session.querryAllCustomer();
		for(Customer m : master) {
			slave = session.querryAllCustomerByMasterID(m.getId());
			if(slave.isEmpty()) {
				m.setRenderedDelete("true");
			} else {
				m.setRenderedDelete("false");
			}
		}
	}
	
	@PreDestroy
	private void destroy() {
		
	}
	
	String mainCustomer;
	
	public void btnAddPlantClick(Customer o) {
		selectedRow = o;
		Customer tempMainCustomer = o;
		mainCustomer = tempMainCustomer.getCompany();
		plants = o.getPlants();
	}
	
	public void btnNewPlantClick() {
		System.out.println("btnNewPlantClick 5555555555555 : " + mainCustomer);
	}
	
	public void btnAddSubCustomerClick(Customer o) {
		selectedRow = o;
		Customer tempMainCustomer = o;
		mainCustomer = tempMainCustomer.getCompany();
		selectedRow = new Customer();
		selectedRow.setCustomer(tempMainCustomer);
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
		selectedRow.setIsHeadOffice(false);
	}
	
	public void btnNewClick() {
		selectedRow = new Customer();
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
		selectedRow.setIsHeadOffice(true);
	}
	
	public void btnSaveClick() {
		session.updateCustomer(selectedRow);
		init();
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
	
	public String getMainCustomer() {
		return mainCustomer;
	}

	public void setMainCustomer(String mainCustomer) {
		this.mainCustomer = mainCustomer;
	}

	public Customer getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(Customer selectedRow) {
		this.selectedRow = selectedRow;
	}

	public List<Customer> getMaster() {
		return master;
	}

	public void setMaster(List<Customer> master) {
		this.master = master;
	}

	public VaSessionbean getVasessionbean() {
		return vasessionbean;
	}

	public void setVasessionbean(VaSessionbean vasessionbean) {
		this.vasessionbean = vasessionbean;
	}

	public String getRenderedDelete() {
		return renderedDelete;
	}

	public void setRenderedDelete(String renderedDelete) {
		this.renderedDelete = renderedDelete;
	}

	public VaSession getSession() {
		return session;
	}

	public void setSession(VaSession session) {
		this.session = session;
	}

	public List<Customer> getSlave() {
		return slave;
	}

	public void setSlave(List<Customer> slave) {
		this.slave = slave;
	}

	public List<Plants> getPlants() {
		return plants;
	}

	public void setPlants(List<Plants> plants) {
		this.plants = plants;
	}

	public Plants getSelectedPlan() {
		return selectedPlan;
	}

	public void setSelectedPlan(Plants selectedPlan) {
		this.selectedPlan = selectedPlan;
	}
}
