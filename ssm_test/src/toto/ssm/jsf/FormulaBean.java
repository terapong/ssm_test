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

import toto.ssm.entity.Formula;
import toto.ssm.session.VaSession;

@ManagedBean(name = "formulabean")
@ViewScoped
public class FormulaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Formula> master;
	private List<Formula> slave;
	//private List<Plants> plants;
	//private Plants selectedPlan;
	private Formula selectedRow;
	private Calendar cal;
	
	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		master = session.querryAllFormular();
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
	}
	
	public void btnSaveClick() {
		selectedRow.setUpdateDate(cal.getTime());
		session.updateFormula(selectedRow);
		init();
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
}
