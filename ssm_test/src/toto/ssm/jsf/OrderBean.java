package toto.ssm.jsf;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import toto.ssm.entity.*;
import toto.ssm.session.VaSession;

@ManagedBean(name = "orderbean")
@ViewScoped
public class OrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Customer> master;
	private List<Customer> subCustomer;
	private Customer selectedMaster;
	private long selectedMasterId;
	private List<Order> slave;
	private Order selectedRow;
	private String addDisabled;
	private Calendar cal;
	private XtblDocket xtblDocket; 
	private List<OrdersStatus> orderStatus;
	private List<OrdersStatus> orderStatuss;
	private OrdersStatus selectOrderStatus;
	private Long orderStatusID;
	private String orderStatusName;
	private Connection conn;
	private List<OrderDetail> orderDetails;
	private OrderDetail orderDetail;
	
	private Integer inventoryID;
	private BigDecimal discount;
	
	private List<XtblDocket> xtbldockets = new ArrayList<XtblDocket>();
	
//	private List<Persona> personas  = new ArrayList<Persona>();
	
	static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/ssm_test?autoReconnect=true&useSSL=false";
	static final String MYSQL_USER = "root";
	static final String MYSQL_PASS = "xxxxxx";
	
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
				//selectedRow = selectedMaster.getEmployees().get(0);
			}
			slave = session.querryAllOrderByCustomerID(selectedMaster.getId());
			selectedMasterId = selectedMaster.getId();
			
//			orderDetails = session.queryAllOrderDetails();
			
			orderStatuss = session.querryAllOrdersStatus();
			if(!orderStatuss.isEmpty()) {
				selectOrderStatus = orderStatuss.get(0);
				orderStatusID = selectOrderStatus.getId();
				orderStatusName = selectOrderStatus.getStatusName();
				System.out.println("int OrderStatusChange: " + orderStatusID);
			} else {
				System.out.println("orderStatuss empty ");
			}
//			
//			try {
//				Class.forName(MYSQL_DRIVER);
//				conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASS);
//			} catch(Exception ex) {
//				ex.printStackTrace();
//			}
			
			
//			for(Order r : slave) {
//				if(r.getUserName().equals("admin")) {
//					r.setRenderedDelete("false");
//				} else {
//					r.setRenderedDelete("true");
//				}
//			}
		}
	}
	
	@PreDestroy
	private void destroy() {
		
	}
	
	public void OrdersStatus(Order r) {
		selectedRow = r;
	}
	
	public void btnOrderDetailClick(Order r) {
		selectedRow = r;
		orderDetails = session.queryAllOrderDetails();
		orderDetail = new OrderDetail();
	}
	
	public void btnEditNewOrderDetailClick() {
		//System.out.println("btnEditOrderDetailClick xxxxxxxxxxxxxxxxxxxxxxx");	
	}
	
	public void btnNewOrderDetailClick() {
		
	}
	
//	public void btnNewOrderDetailClick(OrderDetail od) {
//		
//		for(OrderDetail o : selectedRow.getOrderDetails()) {
//			System.out.println("o.getOrderNo() : " + o.getId());
//		}
//	
//		orderDetail.setCreateDate(cal.getTime());
//		orderDetail.setUpdateDate(cal.getTime());
//		//o.getod setOrder(selectedRow);
//		//o.getsetInventoryId(3);
//		System.out.println("inventoryID:" + inventoryID); 
////		orderDetail.setCreateDate(cal.getTime());
////		orderDetail.setUpdateDate(cal.getTime());
////		orderDetail.setOrder(selectedRow);
////		orderDetail.setInventoryId(3);
////		System.out.println("inventoryID:" + inventoryID);
////		orderDetail.setPurchaseOrderId(selectedRow);
////		orderDetail.setOrderDetailsStatus(null);
////		orderDetail.setShipper(null);
//		
//		session.updateOrderDetail(orderDetail);
//		orderDetails = session.queryAllOrderDetails();
//	}
	
	public void btnEditOrderDetailClick(Order r) {
		System.out.println("btnEditOrderDetailClick xxxxxxxxxxxxxxxxxxxxxxx");
	}
	
//	public void confirmOrderDetailClick(OrderDetail r) {
//		try {
//			session.deleteOrderDetail(r);
//			init();
//		} catch(Exception ex) {
//			FacesMessage msg = new FacesMessage();
//			msg.setSummary("ไม่สามารถ ลบ ได้");
//			msg.setDetail("ไม่สามารถ ลบ ได้ เพราะมี ข้อมูลที่เกี่ยวข้อง");
//			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//			FacesContext.getCurrentInstance().addMessage(null, msg);
//		}
//	}
	
//	public void btnDeleteNewOrderDetailClick(OrderDetail r) {
//		session.deleteOrderDetail(r);
//		System.out.println("btnDeleteNewOrderDetailClick xxxxxxxxxxxxxxxxxxxxxxx");
//	}
	
	public void exportoExcel(Order r) throws JRException, IOException {	
//		try {
//		JRXlsExporter exporter = new JRXlsExporter();
//		JasperPrint jp = new JasperPrint();
//		//SimpleXlsReportConfiguration configuration;
//		String path = "/resources/ISSUESLIP.jasper";
//		
//		File outputFile = new File(path);
//		  File parentFile = outputFile.getParentFile();
//		  if (parentFile != null)
//		    parentFile.mkdirs();
//		  FileOutputStream fos = new FileOutputStream(outputFile);
//		  
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		try {
//			File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/ISSUESLIP.jasper"));
//			//JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), new JRBeanCollectionDataSource(this.getPersonas()));
//			
//			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//			response.addHeader("Content-disposition","attachment; filename=jsfReporte.xls");
//			ServletOutputStream stream = response.getOutputStream();
//			
//			JRXlsxExporter exporter = new JRXlsExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
//			exporter.exportReport();
//			
//			stream.flush();
//			stream.close();
//			FacesContext.getCurrentInstance().responseComplete();
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		
//		try {
//			File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/ISSUESLIP.jasper"));
//			List<XtblDocket> xtbldockets = getXtbldockets();
//			for(XtblDocket d : xtbldockets) {
//				System.out.println(d.getDocketNo());
//			}
//			//JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), xtbldockets, new JRBeanCollectionDataSource(this.getXtbldockets()));
//			//jasperPrint = JasperFillManager.fillReport(jasper.getPath(), xtbldockets, new JRBeanCollectionDataSource(xtbldockets));
//			//jasperPrint = JasperFillManager.fillReport(JasperCompileManager	.compileReport(inputStream), parameters, beanColDataSource);
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//	}
	
//		Map<String,Object> parametros= new HashMap<String,Object>();
//		parametros.put("txtUsuario", "MitoCode");
		
	}
	
	
	public void btnNewClick() {
		selectedRow = new Order();
		selectedRow.setCustomer(selectedMaster);
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
//		selectedRow.setCreateUser(vasessionbean.getUsername());
//		selectedRow.setCurrentStatus(1L);
	}
	
	public void btnAddDocketClick(Order r) {
		//xtblDocket = session.querryXtblDocketByOrderID(r.getId());
		System.out.println("btnDocketDetialClick");
		System.out.println("Order: test");
 	}
	
	public void btnSaveClick() {
		try {
			selectedRow.setCustomer(selectedMaster);
			selectedRow.setUpdateDate(cal.getTime());
			//selectedRow.getOrdersStatuss().add(selectOrderStatus);
			selectedRow.setEmployee(null);
			selectedRow.setTaxes(null);
			selectedRow.setOrderStatus(selectOrderStatus);
			session.updateOrders(selectedRow);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		init(); 
	}
	
	public void btnOrderStatusClick(Order o) {
		selectedRow = o;
		
		orderStatuss = session.querryAllOrdersStatus();
		
		for(OrdersStatus os : orderStatuss) {
			System.out.println(os.getStatusName());
		}
		
		System.out.println("Current status : " + selectedRow.getOrderStatus().getStatusName());
		//slave order = selectedMaster.getOrders;
	}
	
	public void newAddOrderStatusClick() {
		System.out.println("222222");
	}

	public void btnEditClick(Order o) {
		selectedRow = o;
		orderStatusID = selectedRow.getOrderStatus().getId();
	}
	
	public void confirmDeleteClick() {
		try {
			session.deleteOrder(selectedRow);
			init();
		} catch(Exception ex) {
			FacesMessage msg = new FacesMessage();
			msg.setSummary("ไม่สามารถ ลบ ได้");
			msg.setDetail("ไม่สามารถ ลบ ได้ เพราะมี ข้อมูลที่เกี่ยวข้อง");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
//	public void confirmDeleteDetailClick() {
//			try {
//				session.deleteOrderDetail(selectedRow);
//				init();
//			} catch(Exception ex) {
//				FacesMessage msg = new FacesMessage();
//				msg.setSummary("ไม่สามารถ ลบ ได้");
//				msg.setDetail("ไม่สามารถ ลบ ได้ เพราะมี ข้อมูลที่เกี่ยวข้อง");
//				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//				FacesContext.getCurrentInstance().addMessage(null, msg);
//			}
//	}
	
	public void btnDeleteClick(Order o) {
		selectedRow = o;
	}
	
	public void selMasterChange() {
		selectedMaster = session.querryCustomerById(selectedMasterId);
		subCustomer = session.querryAllCustomerByMasterID(selectedMaster.getId());
		slave = selectedMaster.getOrders();
	}
	
//	public void selMasterChange() {
//		selectedMaster = session.querryCustomerById(selectedMasterId);
//		slave = session.querryAllCustomerByMasterID(selectedMaster.getId());
//		System.out.println("test");
//		//slave = selectedMaster.getOrders();
////		for(Order r : slave) {
////			if(r.getUserName().equals("admin")) {
////				r.setRenderedDelete("false");
////			} else {
////				r.setRenderedDelete("true");
////			}
////		}
//	}
	
	public void selOrderStatusChange() {
		selectOrderStatus = session.querryOrdersStatusById(orderStatusID);
		orderStatusID = selectOrderStatus.getId();
		System.out.println("selOrderStatusChange: " + selectOrderStatus.getId());
	}

	public List<Customer> getMaster() {
		return master;
	}	

	public List<OrdersStatus> getOrderStatuss() {
		return orderStatuss;
	}

	public void setOrderStatuss(List<OrdersStatus> orderStatuss) {
		this.orderStatuss = orderStatuss;
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

	public List<Order> getSlave() {
		return slave;
	}

	public void setSlave(List<Order> slave) {
		this.slave = slave;
	}

	public Order getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(Order selectedRow) {
		this.selectedRow = selectedRow;
	}

	public long getSelectedMasterId() {
		return selectedMasterId;
	}

	public void setSelectedMasterId(long selectedMasterId) {
		this.selectedMasterId = selectedMasterId;
	}

	public String getAddDisabled() {
		return addDisabled;
	}

	public void setAddDisabled(String addDisabled) {
		this.addDisabled = addDisabled;
	}

	public XtblDocket getXtblDocket() {
		return xtblDocket;
	}

	public void setXtblDocket(XtblDocket xtblDocket) {
		this.xtblDocket = xtblDocket;
	}

	public VaSessionbean getVasessionbean() {
		return vasessionbean;
	}

	public Long getOrderStatusID() {
		return orderStatusID;
	}

	public void setOrderStatusID(Long orderStatusID) {
		this.orderStatusID = orderStatusID;
	}

	public void setVasessionbean(VaSessionbean vasessionbean) {
		this.vasessionbean = vasessionbean;
	}

	public List<XtblDocket> getXtbldockets() {
		Map<String,Object> docketReports = new HashMap<String,Object>();
		PreparedStatement pstmt;
		ResultSet rs;
		String sql = "select * from xtbl_docket";
		try { 
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString("DocketNo"));
					docketReports.put("DocketNo", rs.getString("DocketNo"));
				}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return xtbldockets;
	}
	
//	public List<Persona> getPersonas() {
//		Persona per = new Persona();
//		per.setNombres("à¸�à¸�à¸�à¸�à¸�à¸�à¸�à¸�à¸�");
//		per.setApellidos("Code");
//		Calendar cal = Calendar.getInstance();
//		cal.set(1991, 1, 21);
//		per.setFechaNacimiento(cal.getTime());
//		personas.add(per);
//		
//		per = new Persona();
//		per.setNombres("Jaime");
//		per.setApellidos("MD");
//		cal = Calendar.getInstance();
//		cal.set(1990, 5, 21);
//		per.setFechaNacimiento(cal.getTime());
//		personas.add(per);
//		
//		return personas;
//	}

//	public void setPersonas(List<Persona> personas) {
//		this.personas = personas;
//	}

	public void setXtbldockets(List<XtblDocket> xtbldockets) {
		this.xtbldockets = xtbldockets;
	}

	public List<Customer> getSubCustomer() {
		return subCustomer;
	}

	public void setSubCustomer(List<Customer> subCustomer) {
		this.subCustomer = subCustomer;
	}

	public List<OrdersStatus> getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(List<OrdersStatus> orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrdersStatus getSelectOrderStatus() {
		return selectOrderStatus;
	}

	public void setSelectOrderStatus(OrdersStatus selectOrderStatus) {
		this.selectOrderStatus = selectOrderStatus;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public VaSession getSession() {
		return session;
	}

	public void setSession(VaSession session) {
		this.session = session;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public Integer getInventoryID() {
		return inventoryID;
		//return 1;
	}

	public void setInventoryID(Integer inventoryID) {
		this.inventoryID = inventoryID;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}
}
