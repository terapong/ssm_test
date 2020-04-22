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

@ManagedBean(name = "subformulabean")
@ViewScoped
public class SubFormulaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Customer> customers;
	private Customer selectedCustomer;
	private Long selectedCustomerID;
	private List<Formula> mainformulars;
	private Formula mainformular;
	private Long selectedmainformularID;
	private List<Formula> subFormulars;
	private Formula selectedRow;
	private Calendar cal;
	
	private List<Moist> moists;
	private Long selectedMoistID;
	private List<AdmixSP> admixSP;
	private Long selectedAdmixSPID;
	private List<Silo> silo;
	private Long selectedSiloID;
	private List<CemtMX> cemtMX;
	private Long selectedCemtMXID;
	private List<CemtSP> cemtSP;
	private Long selectedCemtSPID;
	private List<AggSP> aggSP;
	private Long selectedaggSPID;
	private List<Sand> sand;
	private Long selectedSandID;
	private List<Stone> stone;
	private Long selectedStoneID;
	
	@ManagedProperty(value = "#{VaSessionbean}")
	private VaSessionbean vasessionbean;
	
	@EJB private VaSession session;
	
	
	@PostConstruct
	private void init() {
		cal = Calendar.getInstance();
		customers = session.querryAllCustomer();
		selectedCustomer = customers.get(0);
		selectedCustomerID = selectedCustomer.getId();
		mainformulars = session.querryAllMainFormularByCustomerID(selectedCustomerID);
		if(!mainformulars.isEmpty()) {
			mainformular =mainformulars.get(0);
			selectedmainformularID = mainformular.getId();
			subFormulars = session.querryAllSubFormular(selectedmainformularID);
		}
		
		
		moists = session.querryAllMoist();
		admixSP = session.querryAllAdmixSP();
		silo = session.querryAllSilo();
		cemtMX = session.querryAllCemtMX();
		cemtSP = session.querryAllCemtSP();
		aggSP = session.querryAllAggSP();
		sand = session.querryAllSand();
		stone = session.querryAllStone();
		
		if(!moists.isEmpty()) {
			selectedMoistID = moists.get(0).getId();
		} else {
			selectedMoistID = null;
		}
		
		if(!silo.isEmpty()) {
			selectedSiloID = silo.get(0).getId();
		} else {
			selectedSiloID = null;
		}
		
		if(!admixSP.isEmpty()) {
			selectedAdmixSPID = admixSP.get(0).getId();
		} else {
			selectedAdmixSPID = null;
		}
		
		if(!cemtMX.isEmpty()) {
			selectedCemtMXID = cemtMX.get(0).getId();
		} else {
			selectedCemtMXID = null;
		}
		
		if(!cemtSP.isEmpty()) {
			selectedCemtSPID = cemtSP.get(0).getId();
		} else {
			selectedCemtSPID = null;
		}
		
		if(!aggSP.isEmpty()) {
			selectedaggSPID = aggSP.get(0).getId();
		} else {
			selectedaggSPID = null;
		}
		
		if(!sand.isEmpty()) {
			selectedSandID = sand.get(0).getId();
		} else {
			selectedSandID = null;
		}
		
		if(!stone.isEmpty()) {
			selectedStoneID = stone.get(0).getId();
		} else {
			selectedStoneID = null;
		}
	}
	
	@PreDestroy
	private void destroy() {
		
	}
	
	public List<Formula> getSubFormulars() {
		return subFormulars;
	}

	public void setSubFormulars(List<Formula> subFormulars) {
		this.subFormulars = subFormulars;
	}

	public void selMainformularChange() {
		mainformular = session.querryFormulaById(selectedmainformularID);
		subFormulars = session.querryAllFormularByMasterID(selectedmainformularID);
	}
	
	public void btnNewClick() {
		selectedRow = new Formula();
		selectedRow.setCreateDate(cal.getTime());
		selectedRow.setUpdateDate(cal.getTime());
		selectedRow.setIsMain(false);
		selectedRow.setCustomer(selectedCustomer);
		selectedRow.setFormula(mainformular);
		
		selectedRow.setMoist(moists.get(0));
		selectedRow.setAdmixSP(admixSP.get(0));
		selectedRow.setAggSP(aggSP.get(0));
		selectedRow.setCemtMX(cemtMX.get(0));
		selectedRow.setCemtSP(cemtSP.get(0));
		selectedRow.setSand(sand.get(0));
		selectedRow.setStone(stone.get(0));
		selectedRow.setSilo(silo.get(0));
	}
	
	public void btnSaveClick() {
		selectedRow.setUpdateDate(cal.getTime());
		session.updateFormula(selectedRow);
		
		System.out.println("SubFormular btnSaveClick xxxxxxxxxxxxxxxxxxxxx");
		
		init();
	}
	
	public void selMoistChang() {
		Moist m = session.querryMoistById(selectedMoistID);
		selectedRow.setMoist(m);
		System.out.println("selMoistChang");
	}
	
	public void seladmixSPChang() {
		AdmixSP admixSP  = session.querryAdmixSPById(selectedAdmixSPID);
		selectedRow.setAdmixSP(admixSP);
		System.out.println("seladmixSPChang");
	}

	public void selsiloChang() {
		Silo SelectedSiloID = session.querrySiloById(selectedSiloID);
		selectedRow.setSilo(SelectedSiloID);
		System.out.println("selsiloChang");
	}
	
	public void selCemtMXChang() {
		CemtMX cemtMX = session.querryCemtMXById(selectedCemtMXID);
		selectedRow.setCemtMX(cemtMX);
		System.out.println("selCemtMXChang");
	}
	
	public void selCemtSPChang() {
		CemtSP cemtSP = session.querryCemtSPById(selectedCemtSPID);
		selectedRow.setCemtSP(cemtSP);
		System.out.println("selCemtSPChang");
	}
	
	public void selAggSPChang() {
		AggSP aggSP = session.querryAggSPById(selectedaggSPID);
		selectedRow.setAggSP(aggSP);
		System.out.println("selAggSPChang");
	}
	
	public void selSandChang() {
		Sand sand = session.querrySandById(selectedSandID);
		selectedRow.setSand(sand);
		System.out.println("selSandChang");
	}
	
	public void selStoneChang() {
		Stone stone = session.querryStoneById(selectedStoneID);
		selectedRow.setStone(stone);
		System.out.println("selStoneChang");
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
	
	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}

	public void selCustomerChange() {
		selectedCustomer = session.querryCustomerById(selectedCustomerID);
		selectedCustomerID = selectedCustomer.getId();
		mainformulars = session.querryAllMainFormularByCustomerID(selectedCustomerID);
		//subFormulars = null;
		subFormulars = session.querryAllFormularByMasterID(mainformulars.get(0).getId());
		
//		masters = session.querryAllFormularByMasterID(id)
//		for(Employee r : slave) {
//			if(r.getUserName().equals("admin")) {
//				r.setRenderedDelete("false");
//			} else {
//				r.setRenderedDelete("true");
//			}
//		}
	}

//	moists = session.querryAllMoist();
//	silo = session.querryAllSilo();
//	admixSP = session.querryAllAdmixSP();
//	cemtMX = session.querryAllCemtMX();
//	cemtSP = session.querryAllCemtSP();
//	aggSP = session.querryAllAggSP();
//	sand = session.querryAllSand();
//	stone = session.querryAllStone();
//	
//	if(!moists.isEmpty()) {
//		selectedMoistID = moists.get(0);
//	} else {
//		selectedMoistID = null;
//	}
//	
//	if(!silo.isEmpty()) {
//		SelectedSiloID = silo.get(0);
//	} else {
//		SelectedSiloID = null;
//	}
//	
//	if(!admixSP.isEmpty()) {
//		selectedAdmixSPID = admixSP.get(0);
//	} else {
//		selectedAdmixSPID = null;
//	}
//	
//	if(!cemtMX.isEmpty()) {
//		selectedCemtMXID = cemtMX.get(0);
//	} else {
//		selectedCemtMXID = null;
//	}
//	
//	if(!cemtSP.isEmpty()) {
//		selectedCemtSPID = cemtSP.get(0);
//	} else {
//		selectedCemtSPID = null;
//	}
//	
//	if(!aggSP.isEmpty()) {
//		selectedaggSPID = aggSP.get(0);
//	} else {
//		selectedaggSPID = null;
//	}
//	
//	if(!sand.isEmpty()) {
//		selectedSandID = sand.get(0);
//	} else {
//		selectedSandID = null;
//	}
//	
//	if(!stone.isEmpty()) {
//		selectedStoneID = stone.get(0);
//	} else {
//		selectedStoneID = null;
//	}
//	
//	selectedRow = new Formula();
//	selectedRow.setm
//	public void selMoistChang() {
//	selectedRow.setMoist(selectedMoistID);
//	System.out.println("selMoistChang");
//}
//
//public void seladmixSPChang() {
//	selectedRow.setAdmixSP(selectedAdmixSPID);
//	System.out.println("seladmixSPChang");
//}
//
//public void selsiloChang() {
//	selectedRow.setSilo(SelectedSiloID);
//	System.out.println("selsiloChang");
//}
//
//public void selCemtMXChang() {
//	selectedRow.setCemtMX(selectedCemtMXID);
//	System.out.println("selCemtMXChang");
//}
//
//public void selCemtSPChang() {
//	selectedRow.setCemtSP(selectedCemtSPID);
//	System.out.println("selCemtSPChang");
//}
//
//public void selAggSPChang() {
//	selectedRow.setAggSP(selectedaggSPID);
//	System.out.println("selAggSPChang");
//}
//
//public void selSandChang() {
//	selectedRow.setSand(selectedSandID);
//	System.out.println("selSandChang");
//}
//
//public void selStoneChang() {
//	selectedRow.setStone(selectedStoneID);
//	System.out.println("selStoneChang");
//}

	public Formula getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(Formula selectedRow) {
		this.selectedRow = selectedRow;
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

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Formula> getMainformulars() {
		return mainformulars;
	}

	public void setMainformulars(List<Formula> mainformulars) {
		this.mainformulars = mainformulars;
	}

	public Long getSelectedCustomerID() {
		return selectedCustomerID;
	}

	public void setSelectedCustomerID(Long selectedCustomerID) {
		this.selectedCustomerID = selectedCustomerID;
	}

	public Long getSelectedmainformularID() {
		return selectedmainformularID;
	}

	public void setSelectedmainformularID(Long selectedmainformularID) {
		this.selectedmainformularID = selectedmainformularID;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public Formula getMainformular() {
		return mainformular;
	}

	public void setMainformular(Formula mainformular) {
		this.mainformular = mainformular;
	}

	public List<Moist> getMoists() {
		return moists;
	}

	public void setMoists(List<Moist> moists) {
		this.moists = moists;
	}

	public Long getSelectedMoistID() {
		return selectedMoistID;
	}

	public void setSelectedMoistID(Long selectedMoistID) {
		this.selectedMoistID = selectedMoistID;
	}

	public List<AdmixSP> getAdmixSP() {
		return admixSP;
	}

	public void setAdmixSP(List<AdmixSP> admixSP) {
		this.admixSP = admixSP;
	}

	public Long getSelectedAdmixSPID() {
		return selectedAdmixSPID;
	}

	public void setSelectedAdmixSPID(Long selectedAdmixSPID) {
		this.selectedAdmixSPID = selectedAdmixSPID;
	}

	public List<Silo> getSilo() {
		return silo;
	}

	public void setSilo(List<Silo> silo) {
		this.silo = silo;
	}

	public Long getSelectedSiloID() {
		return selectedSiloID;
	}

	public void setSelectedSiloID(Long selectedSiloID) {
		this.selectedSiloID = selectedSiloID;
	}

	public List<CemtMX> getCemtMX() {
		return cemtMX;
	}

	public void setCemtMX(List<CemtMX> cemtMX) {
		this.cemtMX = cemtMX;
	}

	public Long getSelectedCemtMXID() {
		return selectedCemtMXID;
	}

	public void setSelectedCemtMXID(Long selectedCemtMXID) {
		this.selectedCemtMXID = selectedCemtMXID;
	}

	public List<CemtSP> getCemtSP() {
		return cemtSP;
	}

	public void setCemtSP(List<CemtSP> cemtSP) {
		this.cemtSP = cemtSP;
	}

	public Long getSelectedCemtSPID() {
		return selectedCemtSPID;
	}

	public void setSelectedCemtSPID(Long selectedCemtSPID) {
		this.selectedCemtSPID = selectedCemtSPID;
	}

	public List<AggSP> getAggSP() {
		return aggSP;
	}

	public void setAggSP(List<AggSP> aggSP) {
		this.aggSP = aggSP;
	}

	public Long getSelectedaggSPID() {
		return selectedaggSPID;
	}

	public void setSelectedaggSPID(Long selectedaggSPID) {
		this.selectedaggSPID = selectedaggSPID;
	}

	public List<Sand> getSand() {
		return sand;
	}

	public void setSand(List<Sand> sand) {
		this.sand = sand;
	}

	public Long getSelectedSandID() {
		return selectedSandID;
	}

	public void setSelectedSandID(Long selectedSandID) {
		this.selectedSandID = selectedSandID;
	}

	public List<Stone> getStone() {
		return stone;
	}

	public void setStone(List<Stone> stone) {
		this.stone = stone;
	}

	public Long getSelectedStoneID() {
		return selectedStoneID;
	}

	public void setSelectedStoneID(Long selectedStoneID) {
		this.selectedStoneID = selectedStoneID;
	}

//	public List<AdmixSP> getAdmixSP() {
//		return admixSP;
//	}
//
//	public void setAdmixSP(List<AdmixSP> admixSP) {
//		this.admixSP = admixSP;
//	}
//
//
//	public List<Silo> getSilo() {
//		return silo;
//	}
//
//	public void setSilo(List<Silo> silo) {
//		this.silo = silo;
//	}
//
//	public List<CemtMX> getCemtMX() {
//		return cemtMX;
//	}
//
//	public void setCemtMX(List<CemtMX> cemtMX) {
//		this.cemtMX = cemtMX;
//	}
//
//	public List<CemtSP> getCemtSP() {
//		return cemtSP;
//	}
//
//	public void setCemtSP(List<CemtSP> cemtSP) {
//		this.cemtSP = cemtSP;
//	}
//
//	public List<AggSP> getAggSP() {
//		return aggSP;
//	}
//
//	public void setAggSP(List<AggSP> aggSP) {
//		this.aggSP = aggSP;
//	}
//
//	public List<Sand> getSand() {
//		return sand;
//	}
//
//	public void setSand(List<Sand> sand) {
//		this.sand = sand;
//	}
//
//	public List<Stone> getStone() {
//		return stone;
//	}
//
//	public void setStone(List<Stone> stone) {
//		this.stone = stone;
//	}
//
//	public Moist getSelectedMoistID() {
//		return selectedMoistID;
//	}
//
//	public void setSelectedMoistID(Moist selectedMoistID) {
//		this.selectedMoistID = selectedMoistID;
//	}
//
//	public AdmixSP getSelectedAdmixSPID() {
//		return selectedAdmixSPID;
//	}
//
//	public void setSelectedAdmixSPID(AdmixSP selectedAdmixSPID) {
//		this.selectedAdmixSPID = selectedAdmixSPID;
//	}
//
//	public Silo getSelectedSiloID() {
//		return SelectedSiloID;
//	}
//
//	public void setSelectedSiloID(Silo selectedSiloID) {
//		SelectedSiloID = selectedSiloID;
//	}
//
//	public CemtMX getSelectedCemtMXID() {
//		return selectedCemtMXID;
//	}
//
//	public void setSelectedCemtMXID(CemtMX selectedCemtMXID) {
//		this.selectedCemtMXID = selectedCemtMXID;
//	}
//
//	public CemtSP getSelectedCemtSPID() {
//		return selectedCemtSPID;
//	}
//
//	public void setSelectedCemtSPID(CemtSP selectedCemtSPID) {
//		this.selectedCemtSPID = selectedCemtSPID;
//	}
//
//	public AggSP getSelectedaggSPID() {
//		return selectedaggSPID;
//	}
//
//	public void setSelectedaggSPID(AggSP selectedaggSPID) {
//		this.selectedaggSPID = selectedaggSPID;
//	}
//
//	public Sand getSelectedSandID() {
//		return selectedSandID;
//	}
//
//	public void setSelectedSandID(Sand selectedSandID) {
//		this.selectedSandID = selectedSandID;
//	}
//
//	public Stone getSelectedStoneID() {
//		return selectedStoneID;
//	}
//
//	public void setSelectedStoneID(Stone selectedStoneID) {
//		this.selectedStoneID = selectedStoneID;
//	}
}
