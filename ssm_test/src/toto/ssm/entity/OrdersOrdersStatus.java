package toto.ssm.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="orders_orders_status")
public class OrdersOrdersStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long ordersStatuss_id;
	//private List<OrdersStatus> OrdersStatuss;
	//private long id;
	
	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="ORDER_ODER_STATUS_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;
	
	@Column(name="order_id")
	private long orderId;
	
	@Column(name="order_status_id")
	private long odersStatussId;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getOdersStatussId() {
		return odersStatussId;
	}
	public void setOdersStatussId(long odersStatussId) {
		this.odersStatussId = odersStatussId;
	}
//	public Long getOrdersStatuss_id() {
//		return ordersStatuss_id;
//	}
//	public void setOrdersStatuss_id(Long ordersStatuss_id) {
//		this.ordersStatuss_id = ordersStatuss_id;
//	}
	public Long getOrdersStatuss_id() {
		return ordersStatuss_id;
	}
	public void setOrdersStatuss_id(Long ordersStatuss_id) {
		this.ordersStatuss_id = ordersStatuss_id;
	}
}