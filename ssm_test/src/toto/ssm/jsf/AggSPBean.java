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

import toto.ssm.entity.AggSP;
import toto.ssm.session.VaSession;

@ManagedBean(name = "aggspbean")
@ViewScoped
public class AggSPBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<AggSP> aggSPs;
	private AggSP selectedRow;
	private Calendar cal;
	
	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		aggSPs = session.querryAllAggSP();
	}

	@PreDestroy
	private void destroy() {
		
	}
	
	public void btnNewClick() {
		selectedRow = new AggSP();
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
	}
	
	public void btnSaveClick() {
		selectedRow.setUpdateDate(cal.getTime());
		session.updateAggSP(selectedRow);
		init();
	}
	
	public void btnEditClick(AggSP o) {
		selectedRow = o;
	}
	
	public void btnDeleteClick(AggSP o) {
		selectedRow = o;
		System.out.println("dddddddddddddddddd");
	}
	
	public void confirmDeleteClick() {
		try {
			session.deleteAggSP(selectedRow);
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

	public List<AggSP> getAggSPs() {
		return aggSPs;
	}

	public void setAggSPs(List<AggSP> aggSPs) {
		this.aggSPs = aggSPs;
	}

	public AggSP getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(AggSP selectedRow) {
		this.selectedRow = selectedRow;
	}
}
