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

import toto.ssm.entity.CemtMX;
import toto.ssm.session.VaSession;

@ManagedBean(name = "cemtmxbean")
@ViewScoped
public class CemtMXBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<CemtMX> cemtMXs;
	private CemtMX selectedRow;
	private Calendar cal;
	
	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		cemtMXs = session.querryAllCemtMX();
	}

	@PreDestroy
	private void destroy() {
		
	}
	
	public void btnNewClick() {
		selectedRow = new CemtMX();
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
	}
	
	public void btnSaveClick() {
		selectedRow.setUpdateDate(cal.getTime());
		session.updateCemtMX(selectedRow);
		init();
	}
	
	public void btnEditClick(CemtMX o) {
		selectedRow = o;
	}
	
	public void btnDeleteClick(CemtMX o) {
		selectedRow = o;
	}
	
	public void confirmDeleteClick() {
		try {
			session.deleteCemtMX(selectedRow);
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

	public List<CemtMX> getCemtMXs() {
		return cemtMXs;
	}

	public void setCemtMXs(List<CemtMX> cemtMXs) {
		this.cemtMXs = cemtMXs;
	}

	public CemtMX getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(CemtMX selectedRow) {
		this.selectedRow = selectedRow;
	}
}
