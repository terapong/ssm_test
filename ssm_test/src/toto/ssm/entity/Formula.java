package toto.ssm.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="formula")
public class Formula implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(
            name="SSMGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="FORMULA_ID", 
            allocationSize=1)

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SSMGen")
	private long id;

	@Column(name="formula_name")
	private String formulaName;
	
	@Column(name = "formula_code")
	private String formulaCode;
	
	@Column(name="slump_test")
	private String slumnCode;
	
	@Column(name="streng")
	private String streng;
	
	@Column(name="duration")
	private Integer Duration;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="detail")
	private String detail;
	
	@Column(name="is_main")
	private Boolean isMain;
	
	@Column(name="value")
	private Integer value;
	@Column(name="create_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@Column(name="create_user")
	private String createUser;
	
	@Column(name="unit")
	private Integer unit;
	
	@ManyToOne
    @JoinColumn(name="main_formular_id")
    private Formula formula;

    @OneToMany(mappedBy="formula", cascade = CascadeType.ALL)
    private Set<Formula> formulas = new HashSet<Formula>();
    
    @ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
    
    @OneToOne
	@JoinColumn(name = "moist_id")
    private Moist moist;
	
    @OneToOne
    @JoinColumn(name = "admixsp_id")
	private AdmixSP admixSP;
    
    @OneToOne
    @JoinColumn(name = "silo_id")
	private Silo silo;
    
    @OneToOne
    @JoinColumn(name = "cemtmx_id")
	private CemtMX cemtMX;
    
    @OneToOne
    @JoinColumn(name = "cemtsp_id")
	private CemtSP cemtSP;
    
    @OneToOne
    @JoinColumn(name = "aggsp_id")
	private AggSP aggSP;
    
    @OneToOne
    @JoinColumn(name = "sand_id")
	private Sand sand;
    
    @OneToOne
    @JoinColumn(name = "stone_id")
	private Stone stone;
	
	public Moist getMoist() {
		return moist;
	}

	public void setMoist(Moist moist) {
		this.moist = moist;
	}

	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}

	public Set<Formula> getFormulas() {
		return formulas;
	}

	public void setFormulas(Set<Formula> formulas) {
		this.formulas = formulas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getFormulaName() {
		return formulaName;
	}

	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}

	public String getFormulaCode() {
		return formulaCode;
	}

	public void setFormulaCode(String formulaCode) {
		this.formulaCode = formulaCode;
	}

	public String getSlumnCode() {
		return slumnCode;
	}

	public void setSlumnCode(String slumnCode) {
		this.slumnCode = slumnCode;
	}

	public String getStreng() {
		return streng;
	}

	public void setStreng(String streng) {
		this.streng = streng;
	}

	public Integer getDuration() {
		return Duration;
	}

	public void setDuration(Integer duration) {
		Duration = duration;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Boolean getIsMain() {
		return isMain;
	}

	public void setIsMain(Boolean isMain) {
		this.isMain = isMain;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AdmixSP getAdmixSP() {
		return admixSP;
	}

	public void setAdmixSP(AdmixSP admixSP) {
		this.admixSP = admixSP;
	}

	public Silo getSilo() {
		return silo;
	}

	public void setSilo(Silo silo) {
		this.silo = silo;
	}

	public CemtMX getCemtMX() {
		return cemtMX;
	}

	public void setCemtMX(CemtMX cemtMX) {
		this.cemtMX = cemtMX;
	}

	public CemtSP getCemtSP() {
		return cemtSP;
	}

	public void setCemtSP(CemtSP cemtSP) {
		this.cemtSP = cemtSP;
	}

	public AggSP getAggSP() {
		return aggSP;
	}

	public void setAggSP(AggSP aggSP) {
		this.aggSP = aggSP;
	}

	public Sand getSand() {
		return sand;
	}

	public void setSand(Sand sand) {
		this.sand = sand;
	}

	public Stone getStone() {
		return stone;
	}

	public void setStone(Stone stone) {
		this.stone = stone;
	}
	
	

//	public List<Moist> getMoists() {
//		return moists;
//	}
//
//	public void setMoists(List<Moist> moists) {
//		this.moists = moists;
//	}

//	public List<AdmixSP> getAdmixSP() {
//		return admixSP;
//	}
//
//	public void setAdmixSP(List<AdmixSP> admixSP) {
//		this.admixSP = admixSP;
//	}
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
}
