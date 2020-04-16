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

@ManagedBean(name = "orderdetailbean")
@ViewScoped
public class OrderDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Order> master;
	private Order selectedMaster;
	private long selectedMasterId;
	private List<OrderDetail> slave;
	private OrderDetail selectedRow;
	private Calendar cal;

	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		master = session.querryAllOrder();
		if(selectedMaster != null) {
			selectedMaster = master.get(0);
			//selectedRow = selectedMaster.getEmployees().get(0);
		}
		slave = session.querryAllOrderDetailByOrderID(selectedMaster.getId());
		selectedMasterId = selectedMaster.getId();
	}
	
	@PreDestroy
	private void destroy() {
		
	}
	
	public void btnNewClick() {
		selectedRow = new OrderDetail();
		selectedRow.setOrder(selectedMaster);
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
	}
	
	public void btnEditClick(OrderDetail r) {
		selectedRow = r;
	}
	
	public void btnDeleteClick(OrderDetail r) {
		selectedRow = r;
	}
	
	public void confirmDeleteClick() {
		try {
			session.deleteOrderDetail(selectedRow);
			init();
		} catch(Exception ex) {
			FacesMessage msg = new FacesMessage();
			msg.setSummary("ไม่สามารถ ลบ ได้");
			msg.setDetail("ไม่สามารถ ลบ ได้ เพราะมี ข้อมูลที่เกี่ยวข้อง");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public void btnSaveClick() {
		selectedRow.setUpdateDate(cal.getTime());
		session.updateOrderDetail(selectedRow);
		init();
	}
	
	public void selMasterChange() {
		selectedMaster = session.querryOrderById(selectedMasterId);
		slave = selectedMaster.getOrderDetails();
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

	public OrderDetail getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(OrderDetail selectedRow) {
		this.selectedRow = selectedRow;
	}

	public List<Order> getMaster() {
		return master;
	}

	public void setMaster(List<Order> master) {
		this.master = master;
	}

	public Order getSelectedMaster() {
		return selectedMaster;
	}

	public void setSelectedMaster(Order selectedMaster) {
		this.selectedMaster = selectedMaster;
	}

	public long getSelectedMasterId() {
		return selectedMasterId;
	}

	public void setSelectedMasterId(long selectedMasterId) {
		this.selectedMasterId = selectedMasterId;
	}

	public List<OrderDetail> getSlave() {
		return slave;
	}

	public void setSlave(List<OrderDetail> slave) {
		this.slave = slave;
	}
}
