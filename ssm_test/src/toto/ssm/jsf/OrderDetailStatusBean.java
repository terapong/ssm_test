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

import toto.ssm.entity.*;
import toto.ssm.session.VaSession;

@ManagedBean(name = "orderdetailstatusbean")
@ViewScoped
public class OrderDetailStatusBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<OrderDetailsStatus> slave;
	private OrderDetailsStatus selectedRow;
	private Calendar cal;
	
	private String renderedDelete;
	
	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		slave = session.queryAllOrderDetailsStatus();
//		for(OrderDetailsStatus r : slave) {
//			if(r.getEmployees().isEmpty()) {
//				r.setRenderedDelete("true");
//			} else {
//				r.setRenderedDelete("false");
//			}
//		}
	}

	@PreDestroy
	private void destroy() {
		
	}
	
	public void btnDeleteClick(OrderDetailsStatus o) {
		selectedRow = o;
	}
	
	public void btnNewClick() {
		selectedRow = new OrderDetailsStatus();
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
	}
	
	public void btnSaveClick() {
		selectedRow.setUpdateDate(cal.getTime());
		session.updateOrderDetailStatus(selectedRow);
		init();
	}
	
	public void confirmDeleteClick() {
		try {
			session.deleteOrderDetailStatus(selectedRow);
			init();
		} catch(Exception ex) {
			FacesMessage msg = new FacesMessage();
			msg.setSummary("ไม่สามารถ ลบ ได้");
			msg.setDetail("ไม่สามารถ ลบ ได้ เพราะมี ข้อมูลที่เกี่ยวข้อง");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public void btnEditClick(OrderDetailsStatus o) {
		selectedRow = o;
	}

	public String getRenderedDelete() {
		return renderedDelete;
	}

	public void setRenderedDelete(String renderedDelete) {
		this.renderedDelete = renderedDelete;
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

	public List<OrderDetailsStatus> getSlave() {
		return slave;
	}

	public void setSlave(List<OrderDetailsStatus> slave) {
		this.slave = slave;
	}

	public OrderDetailsStatus getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(OrderDetailsStatus selectedRow) {
		this.selectedRow = selectedRow;
	}
}
