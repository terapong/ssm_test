package toto.ssm.jsf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.RowEditEvent;

import toto.ssm.entity.OrderDetail;

@ManagedBean(name = "addorderdetailbean")
@ViewScoped
public class AddOrderDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<OrderDetail> orderDetails;
	private OrderDetail orderDetail;
	
	public void onRowEdit(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Car Edited", event.getObject().getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onAddNew() {
        // Add one new car to the table:
//        Car car2Add = service.createCars(1).get(0);
//        cars1.add(car2Add);
//        FacesMessage msg = new FacesMessage("New Car added", car2Add.getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
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
}
