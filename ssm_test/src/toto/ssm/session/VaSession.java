package toto.ssm.session;

import java.io.Serializable;
import java.util.List;
import java.util.logging.*;
import javax.ejb.*;
import toto.ssm.entity.*;
import javax.persistence.*;

@Stateless
@LocalBean
public class VaSession implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final transient Logger log = Logger.getLogger("VaSession");
	
	@PersistenceContext(unitName="ssm_testPU")
	EntityManager em;
	
//	public XtblDocket querryXtblDocketByOrderID(Long id) {
//		return (XtblDocket) em.createNativeQuery("select * from xtbl_docket where order_id = " + id, XtblDocket.class).getSingleResult();
//	}
	
	public List<Stone> querryAllStone() {
		return em.createNativeQuery("select * from stone", Stone.class).getResultList();
	}
	
	public Stone querryStoneById(long id) {
		return em.find(Stone.class, id);
	}
	
	public void updateStone(Stone r) {
		em.merge(r);
	}
	
	public void deleteStone(Stone r) throws Exception {
		r = querryStoneById(r.getId());
		em.remove(r);
	}
	
	public List<Sand> querryAllSand() {
		return em.createNativeQuery("select * from sand", Sand.class).getResultList();
	}
	
	public Sand querrySandById(long id) {
		return em.find(Sand.class, id);
	}
	
	public void updateSand(Sand r) {
		em.merge(r);
	}
	
	public void deleteSand(Sand r) throws Exception {
		r = querrySandById(r.getId());
		em.remove(r);
	}
	
	public List<CemtSP> querryAllCemtSP() {
		return em.createNativeQuery("select * from cemtsp", CemtSP.class).getResultList();
	}
	
	public CemtSP querryCemtSPById(long id) {
		return em.find(CemtSP.class, id);
	}
	
	public void updateCemtSP(CemtSP r) {
		em.merge(r);
	}
	
	public void deleteCemtSP(CemtSP r) throws Exception {
		r = querryCemtSPById(r.getId());
		em.remove(r);
	}
	
	public List<AggSP> querryAllAggSP() {
		return em.createNativeQuery("select * from aggsp", AggSP.class).getResultList();
	}
	
	public AggSP querryAggSPById(long id) {
		return em.find(AggSP.class, id);
	}
	
	public void updateAggSP(AggSP r) {
		em.merge(r);
	}
	
	public void deleteAggSP(AggSP r) throws Exception {
		r = querryAggSPById(r.getId());
		em.remove(r);
	}
	
	public List<CemtMX> querryAllCemtMX() {
		return em.createNativeQuery("select * from cemtmx", CemtMX.class).getResultList();
	}
	
	public CemtMX querryCemtMXById(long id) {
		return em.find(CemtMX.class, id);
	}
	
	public void updateCemtMX(CemtMX r) {
		em.merge(r);
	}
	
	public void deleteCemtMX(CemtMX r) throws Exception {
		r = querryCemtMXById(r.getId());
		em.remove(r);
	}
	
	public List<Moist> querryAllMoist() {
		return em.createNativeQuery("select * from moist", Moist.class).getResultList();
	}
	
	public Moist querryMoistById(long id) {
		return em.find(Moist.class, id);
	}
	
	public void updateMoist(Moist r) {
		em.merge(r);
	}
	
	public void deleteMoist(Moist r) throws Exception {
		r = querryMoistById(r.getId());
		em.remove(r);
	}
	
	public List<Formula> querryAllFormularByMasterID(Long id) {
		return em.createNativeQuery("select * from formular where main_formular_id = " + id, Formula.class).getResultList();
	}
	
	public List<Formula> querryAllFormular() {
		return em.createNativeQuery("select * from formula", Formula.class).getResultList();
	}
	
	public Formula querryFormulaById(long id) {
		return em.find(Formula.class, id);
	}
	
	public void updateFormula(Formula r) {
		em.merge(r);
	}
	
	public void deleteFormula(Formula r) throws Exception {
		r = querryFormulaById(r.getId());
		em.remove(r);
	}
	
	public List<Silo> querryAllSilo() {
		return em.createNativeQuery("select * from silo", Silo.class).getResultList();
	}
	
	public Silo querrySiloById(long id) {
		return em.find(Silo.class, id);
	}
	
	public void updateSilo(Silo r) {
		em.merge(r);
	}
	
	public void deleteSilo(Silo r) throws Exception {
		r = querrySiloById(r.getId());
		em.remove(r);
	}
	
	public List<Unit> querryAllUnit() {
		return em.createNativeQuery("select * from unit", Unit.class).getResultList();
	}
	
	public Unit querryUnitById(long id) {
		return em.find(Unit.class, id);
	}
	
	public void updateUnit(Unit r) {
		em.merge(r);
	}
	
	public void deleteUnit(Unit r) throws Exception {
		r = querryUnitById(r.getId());
		em.remove(r);
	}

	public List<Privilege> querryAllPrivilege() {
		return em.createNativeQuery("select * from privileges", Privilege.class).getResultList();
	}
	
	public Privilege querryPrivilegeById(long id) {
		return em.find(Privilege.class, id);
	}
	
	public void updatePrivilege(Privilege r) {
		em.merge(r);
	}
	
	public void deletePrivilege(Privilege r) throws Exception {
		r = querryPrivilegeById(r.getId());
		em.remove(r);
	}
	
	public List<Employee> querryAllEmployee() {
		return em.createNativeQuery("select * from employees", Employee.class).getResultList(); 
		
	}
	
	public List<Employee> querryEmployeeByPrivilegeID(long id) {
		return em.createNativeQuery("select * from employees where privilege_id = " + id, Employee.class).getResultList();
	}
	
	public Employee querryEmployeeById(long id) {
		return em.find(Employee.class, id );
	}
	
	public void updateEmployee(Employee u) {
		em.merge(u);
	}
	
	public void deleteEmployee(Employee u) throws Exception {
		u = querryEmployeeById(u.getId());
		em.remove(u);
	}
	
	public List<Customer> querryAllCustomer() {
		return em.createNativeQuery("select * from customer", Customer.class).getResultList();
	}
	
//	public List<Customer> querryAllHearderOffice() {
//		return em.createNativeQuery("select * from customer left outer join customer main on main.id = slave.main_customer_id where slave.main_customer_id = 2", Customer.class).getResultList();
//	}
	
	public List<Customer> querryAllHeaderOffice() {
		return em.createNativeQuery("select * from customer where head_office = 1 ", Customer.class).getResultList();
	}
	
	public List<Customer> querryAllCustomerByMasterID(Long id) {
		return em.createNativeQuery("select * from customer where main_customer_id = " + id, Customer.class).getResultList();
	}
	
	public Customer querryCustomerById(long id) {
		return em.find(Customer.class, id );
	}
	
	public void updateCustomer(Customer c) {
		em.merge(c);
	}
	
	public void deleteCustomer(Customer c) {
		c = querryCustomerById(c.getId());
		em.remove(c);
	}
	
	public List<OrdersTaxStatus> querryAllOrdersTaxStatus() {
		return em.createNativeQuery("select * from orders_tax_status", OrdersTaxStatus.class).getResultList();
	}
	
	public OrdersTaxStatus querryOrdersTaxStatusById(long id) {
		return em.find(OrdersTaxStatus.class, id );
	}
	
	public void updateOrderTaxStatus(OrdersTaxStatus c) {
		em.merge(c);
	}
	
	public void deleteOrderTaxStatus(OrdersTaxStatus c) {
		c = querryOrdersTaxStatusById(c.getId());
		em.remove(c);
	}
	
	public List<OrdersStatus> querryAllOrderStatusID() {
		return em.createNativeQuery("select * from orders_status", OrdersStatus.class).getResultList();
	}
	
	public List<OrdersStatus> querryAllOrdersStatus() {
		return em.createNativeQuery("select * from orders_status", OrdersStatus.class).getResultList();
	}
	
	public List<OrdersStatus> querryAllOrdersStatus(Long id) {
		return em.createNativeQuery("select * from orders_status", OrdersStatus.class).getResultList();
	}
	
	public OrdersStatus querryOrdersStatusById(long id) {
		return em.find(OrdersStatus.class, id );
	}
	
	public void updateOrderStatus(OrdersStatus c) {
		em.merge(c);
	}
	
	private void updateOrdersOrdersStatus(Order oid, OrdersStatus osid) {
		em.createNativeQuery("select * from sales_reports", OrdersStatus.class).getResultList();
	}
	
	public void deleteOrderStatus(OrdersStatus c) {
		c = querryOrdersStatusById(c.getId());
		em.remove(c);
	}
	
	public List<SalesReport> querryAllSalesReport() {
		return em.createNativeQuery("select * from sales_reports", OrdersStatus.class).getResultList();
	}
	
	public SalesReport querrySalesReporstById(long id) {
		return em.find(SalesReport.class, id );
	}
	
	public void updateSalesReport(SalesReport c) {
		em.merge(c);
	}
	
	public void deleteSalesReport(SalesReport c) {
		c = querrySalesReporstById(c.getId());
		em.remove(c);
	}
	
	public List<InventoryTransactionType> querryAllInventoryTransactionType() {
		return em.createNativeQuery("select * from inventory_transaction_types", InventoryTransactionType.class).getResultList();
	}
	
	public InventoryTransactionType querryInventoryTransactionTypeById(long id) {
		return em.find(InventoryTransactionType.class, id );
	}
	
	public void updateInventoryTransactionType(InventoryTransactionType c) {
		em.merge(c);
	}
	
	public void deleteInventoryTransactionType(InventoryTransactionType c) {
		c = querryInventoryTransactionTypeById(c.getId());
		em.remove(c);
	}
	
	public List<PurchaseOrderStatus> querryAllPurchaseOrderStatus() {
		return em.createNativeQuery("select * from purchase_order_status", PurchaseOrderStatus.class).getResultList();
	}
	
	public PurchaseOrderStatus querryPurchaseOrderStatusById(long id) {
		return em.find(PurchaseOrderStatus.class, id );
	}
	
	public void updatePurchaseOrderStatus(PurchaseOrderStatus c) {
		em.merge(c);
	}
	
	public void deletePurchaseOrderStatus(PurchaseOrderStatus c) {
		c = querryPurchaseOrderStatusById(c.getId());
		em.remove(c);
	}
	
//	public List<Order> querryAllOrder() {
//		return em.createNativeQuery("select * from order", PurchaseOrderStatus.class).getResultList();
//	}
	
	public List<OrderDetail> querryAllOrderDetailByOrderID(Long id) {
		return em.createNativeQuery("select * from order_details where order_id = " + id, OrderDetail.class).getResultList();
	}
	
	public List<Order> querryAllOrder() {
		return em.createNativeQuery("select * from orders", Order.class).getResultList();
	}
	
	public List<Order> querryAllOrderByCustomerID(Long id) {
		return em.createNativeQuery("select * from orders where customer_id = " + id, Order.class).getResultList();
	}
	
	public Order querryOrderById(long id) {
		return em.find(Order.class, id );
	}
	
	public void updateOrders(Order c) {
		try {
		//	em.persist(c);
//			List<OrdersStatus> ors = c.getOrdersStatuss();
			//0.set
			//em.persist(c);
			em.merge(c);
			System.out.println("Order ID:" + c.getId());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void addOrderToOrderStatusNew(Order o, OrdersStatus os) {
		OrdersOrdersStatus ordersOrdersStatus  = new OrdersOrdersStatus();
		ordersOrdersStatus.setOdersStatussId(os.getId());
		ordersOrdersStatus.setOrderId(o.getId());
		em.persist(ordersOrdersStatus);
	}
	
	public void deleteOrder(Order c) {
		c = querryOrderById(c.getId());
		em.remove(c);
	}
	
	public List<OrderDetailsStatus> queryAllOrderDetailsStatus() {
		return em.createNativeQuery("select * from order_details_status", OrderDetailsStatus.class).getResultList();	
	}
	
	public OrderDetailsStatus queryOrderDetailsStatusByID(Long id) {
		return em.find(OrderDetailsStatus.class, id );
	}
	
	public void updateOrderDetailStatus(OrderDetailsStatus ot) {
		em.merge(ot);
	}
	
	public void deleteOrderDetailStatus(OrderDetailsStatus ot) {
		ot = queryOrderDetailsStatusByID(ot.getId());
		em.remove(ot);
	}
	
	public List<OrderDetail> queryAllOrderDetails() {
		return em.createNativeQuery("select * from order_details", OrderDetail.class).getResultList();	
	}
	
	public OrderDetail queryOrderDetailsByID(Long id) {
		return em.find(OrderDetail.class, id );
	}
	
	public void updateOrderDetail(OrderDetail ot) {
		em.merge(ot);
	}
	
	public void deleteOrderDetail(OrderDetail od) {
		od = queryOrderDetailsByID(od.getId());
		em.remove(od);
	}
}
