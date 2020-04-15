<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="0" cellpadding="3" cellspacing="1" width="90%">
		<tbody>
			<tr>
				<td>
					<%@ page contentType="application/vnd.ms-excel;charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
		
					<%@ page import="java.io.IOException"%>
					<%@ page import="java.io.InputStream"%>
					<%@ page import="java.io.PrintWriter"%>
					<%@ page import="java.io.StringWriter"%>
					<%@ page import="java.util.HashMap"%>
					<%@ page import="java.util.Map"%>
					<%@ page import="javax.servlet.ServletException"%>
					<%@ page import="javax.servlet.ServletOutputStream"%>
					<%@ page import="javax.servlet.http.HttpServlet"%>
					<%@ page import="javax.servlet.http.HttpServletRequest"%>
					<%@ page import="javax.servlet.http.HttpServletResponse"%>
					<%@ page import="net.sf.jasperreports.engine.JRExporterParameter"%>
					<%@ page import="net.sf.jasperreports.engine.JasperFillManager"%>
					<%@ page import="net.sf.jasperreports.engine.JasperPrint"%>
					<%@ page import="net.sf.jasperreports.engine.export.JRXlsExporter"%>
					<%@ page import="net.sf.jasperreports.engine.export.JRXlsExporterParameter"%>
					
					<%
					    try {
					        response.setContentType("application/vnd.ms-excel");
					        response.setHeader("Content-Disposition", "inline; filename=xyz.xls");
					
					        ServletOutputStream servletOutputStream = response.getOutputStream();
					
					        InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("/resouces/sasitron.jasper");
					        Map parameters = new HashMap();
					        JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, parameters);
					
					        JRXlsExporter exporter = new JRXlsExporter();
					
					        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					        exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, servletOutputStream); 
					
					        exporter.exportReport();
					
					        servletOutputStream.flush();
					        servletOutputStream.close();
					    } catch (Exception e) {
					        // display stack trace in the browser
					        StringWriter stringWriter = new StringWriter();
					        PrintWriter printWriter = new PrintWriter(stringWriter);
					        e.printStackTrace(printWriter);
					        response.setContentType("text/plain");
					        response.getOutputStream().print(stringWriter.toString());
					    }
					%>
		
		
		
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>