package toto.ssm.entity;

import java.io.Serializable;
import java.util.Date;

public class XtblDocket implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String DocketNo;
	private String DocketRef;
	private String QtyDocket;
	private String QtyTruck;
	private String QtyNet;
	private String QtyBatch;
	private String QtyPerBatch;
	private String Finished;
	private String CountDoc;
	private String WC;
	private String Driver; 
	private String DateBatch;
	private Date Time_Load;
	private Date Time_Ex;
	private String Remark; 
	private String Price;
	private String Vat;
	private String TotalCost;
	private String Fuel;
	private String Status;
	private String Qf;
	private String Qw;
	private String Qn;
	private String Moist1;
	private String Moist2;
	private String Moist3;
	private String Moist4;
	private String Agg1Mix;
	private String Agg2Mix;
	private String Agg3Mix;
	private String Agg4Mix;
	private String Agg1Sp;
	private String Agg2Sp;
	private String Agg3Sp;
	private String Agg4Sp; 
	private String Cemt1Mix;
	private String Cemt2Mix;
	private String Cemt3Mix;
	private String Cemt4Mix;
	private String Cemt1Sp;
	private String Cemt2Sp;
	private String Cemt3Sp;
	private String Cemt4Sp;
	private String Admix1Sp;
	private String Admix2Sp;
	private String Admix3Sp;
	private String Admix4Sp;
	private String WaterSp;
	private String Uploaded;
	private String DPType;
	private String Temp0;
	private String Temp1;
	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getDocketNo() {
		return DocketNo;
	}

	public void setDocketNo(String docketNo) {
		DocketNo = docketNo;
	}

	public String getDocketRef() {
		return DocketRef;
	}

	public void setDocketRef(String docketRef) {
		DocketRef = docketRef;
	}

	public String getQtyDocket() {
		return QtyDocket;
	}

	public void setQtyDocket(String qtyDocket) {
		QtyDocket = qtyDocket;
	}

	public String getQtyTruck() {
		return QtyTruck;
	}

	public void setQtyTruck(String qtyTruck) {
		QtyTruck = qtyTruck;
	}

	public String getQtyNet() {
		return QtyNet;
	}

	public void setQtyNet(String qtyNet) {
		QtyNet = qtyNet;
	}

	public String getQtyBatch() {
		return QtyBatch;
	}

	public void setQtyBatch(String qtyBatch) {
		QtyBatch = qtyBatch;
	}

	public String getQtyPerBatch() {
		return QtyPerBatch;
	}

	public void setQtyPerBatch(String qtyPerBatch) {
		QtyPerBatch = qtyPerBatch;
	}

	public String getFinished() {
		return Finished;
	}

	public void setFinished(String finished) {
		Finished = finished;
	}

	public String getCountDoc() {
		return CountDoc;
	}

	public void setCountDoc(String countDoc) {
		CountDoc = countDoc;
	}

	public String getWC() {
		return WC;
	}

	public void setWC(String wC) {
		WC = wC;
	}

	public String getDriver() {
		return Driver;
	}

	public void setDriver(String driver) {
		Driver = driver;
	}

	public String getDateBatch() {
		return DateBatch;
	}

	public void setDateBatch(String dateBatch) {
		DateBatch = dateBatch;
	}

	public Date getTime_Load() {
		return Time_Load;
	}

	public void setTime_Load(Date time_Load) {
		Time_Load = time_Load;
	}

	public Date getTime_Ex() {
		return Time_Ex;
	}

	public void setTime_Ex(Date time_Ex) {
		Time_Ex = time_Ex;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getVat() {
		return Vat;
	}

	public void setVat(String vat) {
		Vat = vat;
	}

	public String getTotalCost() {
		return TotalCost;
	}

	public void setTotalCost(String totalCost) {
		TotalCost = totalCost;
	}

	public String getFuel() {
		return Fuel;
	}

	public void setFuel(String fuel) {
		Fuel = fuel;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getQf() {
		return Qf;
	}

	public void setQf(String qf) {
		Qf = qf;
	}

	public String getQw() {
		return Qw;
	}

	public void setQw(String qw) {
		Qw = qw;
	}

	public String getQn() {
		return Qn;
	}

	public void setQn(String qn) {
		Qn = qn;
	}

	public String getMoist1() {
		return Moist1;
	}

	public void setMoist1(String moist1) {
		Moist1 = moist1;
	}

	public String getMoist2() {
		return Moist2;
	}

	public void setMoist2(String moist2) {
		Moist2 = moist2;
	}

	public String getMoist3() {
		return Moist3;
	}

	public void setMoist3(String moist3) {
		Moist3 = moist3;
	}

	public String getMoist4() {
		return Moist4;
	}

	public void setMoist4(String moist4) {
		Moist4 = moist4;
	}

	public String getAgg1Mix() {
		return Agg1Mix;
	}

	public void setAgg1Mix(String agg1Mix) {
		Agg1Mix = agg1Mix;
	}

	public String getAgg2Mix() {
		return Agg2Mix;
	}

	public void setAgg2Mix(String agg2Mix) {
		Agg2Mix = agg2Mix;
	}

	public String getAgg3Mix() {
		return Agg3Mix;
	}

	public void setAgg3Mix(String agg3Mix) {
		Agg3Mix = agg3Mix;
	}

	public String getAgg4Mix() {
		return Agg4Mix;
	}

	public void setAgg4Mix(String agg4Mix) {
		Agg4Mix = agg4Mix;
	}

	public String getAgg1Sp() {
		return Agg1Sp;
	}

	public void setAgg1Sp(String agg1Sp) {
		Agg1Sp = agg1Sp;
	}

	public String getAgg2Sp() {
		return Agg2Sp;
	}

	public void setAgg2Sp(String agg2Sp) {
		Agg2Sp = agg2Sp;
	}

	public String getAgg3Sp() {
		return Agg3Sp;
	}

	public void setAgg3Sp(String agg3Sp) {
		Agg3Sp = agg3Sp;
	}

	public String getAgg4Sp() {
		return Agg4Sp;
	}

	public void setAgg4Sp(String agg4Sp) {
		Agg4Sp = agg4Sp;
	}

	public String getCemt1Mix() {
		return Cemt1Mix;
	}

	public void setCemt1Mix(String cemt1Mix) {
		Cemt1Mix = cemt1Mix;
	}

	public String getCemt2Mix() {
		return Cemt2Mix;
	}

	public void setCemt2Mix(String cemt2Mix) {
		Cemt2Mix = cemt2Mix;
	}

	public String getCemt3Mix() {
		return Cemt3Mix;
	}

	public void setCemt3Mix(String cemt3Mix) {
		Cemt3Mix = cemt3Mix;
	}

	public String getCemt4Mix() {
		return Cemt4Mix;
	}

	public void setCemt4Mix(String cemt4Mix) {
		Cemt4Mix = cemt4Mix;
	}

	public String getCemt1Sp() {
		return Cemt1Sp;
	}

	public void setCemt1Sp(String cemt1Sp) {
		Cemt1Sp = cemt1Sp;
	}

	public String getCemt2Sp() {
		return Cemt2Sp;
	}

	public void setCemt2Sp(String cemt2Sp) {
		Cemt2Sp = cemt2Sp;
	}

	public String getCemt3Sp() {
		return Cemt3Sp;
	}

	public void setCemt3Sp(String cemt3Sp) {
		Cemt3Sp = cemt3Sp;
	}

	public String getCemt4Sp() {
		return Cemt4Sp;
	}

	public void setCemt4Sp(String cemt4Sp) {
		Cemt4Sp = cemt4Sp;
	}

	public String getAdmix1Sp() {
		return Admix1Sp;
	}

	public void setAdmix1Sp(String admix1Sp) {
		Admix1Sp = admix1Sp;
	}

	public String getAdmix2Sp() {
		return Admix2Sp;
	}

	public void setAdmix2Sp(String admix2Sp) {
		Admix2Sp = admix2Sp;
	}

	public String getAdmix3Sp() {
		return Admix3Sp;
	}

	public void setAdmix3Sp(String admix3Sp) {
		Admix3Sp = admix3Sp;
	}

	public String getAdmix4Sp() {
		return Admix4Sp;
	}

	public void setAdmix4Sp(String admix4Sp) {
		Admix4Sp = admix4Sp;
	}

	public String getWaterSp() {
		return WaterSp;
	}

	public void setWaterSp(String waterSp) {
		WaterSp = waterSp;
	}

	public String getUploaded() {
		return Uploaded;
	}

	public void setUploaded(String uploaded) {
		Uploaded = uploaded;
	}

	public String getDPType() {
		return DPType;
	}

	public void setDPType(String dPType) {
		DPType = dPType;
	}

	public String getTemp0() {
		return Temp0;
	}

	public void setTemp0(String temp0) {
		Temp0 = temp0;
	}

	public String getTemp1() {
		return Temp1;
	}

	public void setTemp1(String temp1) {
		Temp1 = temp1;
	}
}
