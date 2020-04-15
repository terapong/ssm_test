package toto.ssm.report;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@ManagedBean(name = "docket")
@ViewScoped
public class Docket implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	private void init() {
	}
	
	@PreDestroy
	private void destroy() {
		
	}
	  public void exportExcel() throws Exception {
		    //System.out.println(new File(".").getAbsolutePath());
			//FileInputStream file = new FileInputStream(new File("/sasitorn.xlsx"));
		  	//InputStream is = getContext().getResourceAsStream("/WEB-INF/yourFolder/abc.properties");
		  	InputStream file = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/sasitorn.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(file);
		    //XSSFWorkbook workbook = new XSSFWorkbook(file);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    Iterator<Row> rowIterator = sheet.iterator();
		    
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm_test", "root", "xxxxxx");
			String sql = "select * from xtbl_docket";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet resultSet = psmt.executeQuery();
			
			while (resultSet.next()) {
		      String docketNo = resultSet.getString("DocketNo");
		      System.out.println(docketNo);
		      
		      while (rowIterator.hasNext()) {
		        Row row = rowIterator.next();
		        Iterator<Cell> cellIterator = row.cellIterator();
		        while (cellIterator.hasNext()) {	
		            Cell cell = cellIterator.next();
		            int columnNumber = cell.getColumnIndex();
		            int rowNumber = cell.getRow().getRowNum();
			            if(rowNumber == 2 && columnNumber == 20) {
			            	cell.setCellValue(resultSet.getString("DocketNo"));
			            }
			            if(rowNumber == 5 && columnNumber == 3) {
			            	cell.setCellValue(resultSet.getString("OrderID"));
			            }
			            if(rowNumber == 5 && columnNumber == 16) {
			            	cell.setCellValue(resultSet.getString("DateBatch"));
			            }
			            if(rowNumber == 6 && columnNumber == 3) {
			            	cell.setCellValue(resultSet.getString("CustomerID"));
			            }
			            if(rowNumber == 6 && columnNumber == 16) {
			            	cell.setCellValue("ศศิธร");
			            }
			            if(rowNumber == 8 && columnNumber == 1) {
			            	cell.setCellValue(resultSet.getString("OrderID"));
			            }
			            if(rowNumber == 8 && columnNumber == 5) {
			            	cell.setCellValue(resultSet.getString("OrderID"));
			            }
			            if(rowNumber == 8 && columnNumber == 11) {
			            	cell.setCellValue(resultSet.getString("QN"));
			            }
			            if(rowNumber == 8 && columnNumber == 19) {
			            	cell.setCellValue("22/5/2022");
			            }
			            if(rowNumber == 10 && columnNumber == 1) {
			            	cell.setCellValue("ศศิธร");//นายธีระพงษ โพธิสุวรรณ
			            }
			            if(rowNumber == 10 && columnNumber == 5) {
			            	cell.setCellValue(resultSet.getString("TruckID"));//นายธีระพงษ โพธิสุวรรณ
			            }
		  	            
		  	       		}
		  	       }
		      }
				
			    file.close();
			    psmt.close();
			    resultSet.close();
			    conn.close();
			    
			    FacesContext context = FacesContext.getCurrentInstance();
		        ExternalContext externalContext = context.getExternalContext();
		        Calendar cal = Calendar.getInstance();
		        externalContext.setResponseContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + cal.getTime() + "sasitorn.xlsx" + "\"");
		        OutputStream out = externalContext.getResponseOutputStream();
		        workbook.write(out);
		        out.close();
			    
//			    FileOutputStream out = new FileOutputStream(new File("C://Report//Report//sasitorn_new.xlsx"));
//		        workbook.write(out);
//		        workbook.close();
//		        out.close();
//		        System.out.println("C://sasitorn_new.xlsx written successfully on disk.");
			}
}
