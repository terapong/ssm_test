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

import toto.ssm.entity.AdmixSP;
import toto.ssm.session.VaSession;

@ManagedBean(name = "admixSPbean")
@ViewScoped
public class AdmixSPBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<AdmixSP> admixSPs;
	private AdmixSP selectedRow;
	private Calendar cal;
	
	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		admixSPs = session.querryAllAdmixSP();
	}

	@PreDestroy
	private void destroy() {
		
	}
	
	public void btnNewClick() {
		selectedRow = new AdmixSP();
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
	}
	
	public void btnSaveClick() {
		selectedRow.setUpdateDate(cal.getTime());
		session.updateAdmixSP(selectedRow);
		init();
	}
	
	public void btnEditClick(AdmixSP o) {
		selectedRow = o;
	}
	
	public void btnDeleteClick(AdmixSP o) {
		selectedRow = o;
	}
	
	public void confirmDeleteClick() {
		try {
			session.deleteAdmixSP(selectedRow);
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

	public List<AdmixSP> getAdmixSPs() {
		return admixSPs;
	}

	public void setAdmixSPs(List<AdmixSP> admixSPs) {
		this.admixSPs = admixSPs;
	}

	public AdmixSP getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(AdmixSP selectedRow) {
		this.selectedRow = selectedRow;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}
}
