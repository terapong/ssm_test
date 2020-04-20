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

import toto.ssm.entity.Silo;
import toto.ssm.session.VaSession;

@ManagedBean(name = "silobean")
@ViewScoped
public class SiloBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Silo> silos;
	private Silo selectedRow;
	private Calendar cal;
	private Integer unit;
	
	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		silos = session.querryAllSilo();
	}

	@PreDestroy
	private void destroy() {
		
	}
	
	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public void btnNewClick() {
		selectedRow = new Silo();
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
	}
	
	public void btnSaveClick() {
		selectedRow.setUpdateDate(cal.getTime());
		session.updateSilo(selectedRow);
		init();
	}
	
	public void btnEditClick(Silo o) {
		selectedRow = o;
	}
	
	public void btnDeleteClick(Silo o) {
		selectedRow = o;
	}
	
	public void confirmDeleteClick() {
		try {
			session.deleteSilo(selectedRow);
			init();
		} catch(Exception ex) {
			FacesMessage msg = new FacesMessage();
			msg.setSummary("ไม่สามารถ ลบ ได้");
			msg.setDetail("ไม่สามารถ ลบ ได้ เพราะมี ข้อมูลที่เกี่ยวข้อง");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
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

	public List<Silo> getSilos() {
		return silos;
	}

	public void setSilos(List<Silo> silos) {
		this.silos = silos;
	}

	public Silo getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(Silo selectedRow) {
		this.selectedRow = selectedRow;
	}
}
