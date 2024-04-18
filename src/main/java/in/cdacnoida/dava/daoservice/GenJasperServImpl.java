package in.cdacnoida.dava.daoservice;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GenJasperServImpl implements GenJasperService{
	
	@Value("${JRXML_PATH}")
	String JRXML_PATH;
	
	@Value("${PDF_PATH}")
	String PDF_PATH;
	
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public String  generatePdf(String strJasperPath,Map<String, Object> parameters,String strOutputFilePath ) throws Exception
	  {
		Connection conn = getConnection();
	      
	    String strStatus="";
	      try{  
	    	  JRFileVirtualizer fileVirtualizer =new JRFileVirtualizer(50,PDF_PATH);
	             parameters.put(JRParameter.REPORT_VIRTUALIZER, fileVirtualizer);
	             JasperPrint printFileName = JasperFillManager.fillReport(strJasperPath,parameters, conn);
	             JasperExportManager.exportReportToPdfFile(printFileName,strOutputFilePath);
                 strStatus= "File Created Successfully";
	          }
	      catch(Exception e) 
	      {
	          System.out.println("Inside Exception");
	        e.printStackTrace();
	        strStatus= "Error in creating ";
	      }
	      finally 
	      {
	        
	        if(!conn.isClosed())
	        	conn.close();

	      }
		return strStatus;
	  }
	
	public Connection getConnection(){	   
    	Session session = (Session) entityManager.getDelegate();
    	SessionFactory sessionFactory= session.getSessionFactory();
    	Connection connection=null;
    	try {
    		connection = sessionFactory.getSessionFactoryOptions().getServiceRegistry().
			getService(ConnectionProvider.class).getConnection();
		} catch (SQLException e1) {				
			e1.printStackTrace();
		}
   
    	//System.out.println("Connection Obj "+connection);
    	return connection;
    }
	
	public void generateCorporatePdf(HttpServletRequest request,HttpServletResponse response,ArrayList<String> list)
	{
	
        Map<String,Object> parameters = new HashMap<String,Object>();
        InputStream imgInputStream =null;
       String statusId=list.get(0);
      
       //String formno=list.get(1);
      
       String inputFileName=list.get(1);
     
       String strOutputFileName=list.get(2);
      
       String realContextPath="";
     
        String strJasperPath=JRXML_PATH; 
     
        parameters.put("status",Integer.parseInt(statusId));
 
       System.out.println(statusId);
        strJasperPath=strJasperPath+inputFileName+".jasper";
        System.out.println("Final Jasper Path = "+strJasperPath);

        System.out.println("Final Output File Path = "+PDF_PATH);
        System.out.println("Final Output File Name = "+strOutputFileName);
        try{
        
                  String filpath=generatePdf(strJasperPath,parameters,PDF_PATH+strOutputFileName);  
                 // response.setContentType("application/"+strOutputFileName.substring(strOutputFileName.lastIndexOf(".")+1,strOutputFileName.length()));
                 System.out.println(filpath);
                //  response.setHeader("Content-disposition", "attachment;filename=\""+strOutputFileName);
                  request.setAttribute("pdfFilePath", filpath);
            
        }
        catch(Exception e) {
          e.printStackTrace();
        }
        File fileFound = new File(PDF_PATH+strOutputFileName);
        FileInputStream fileinputstream = null;
        ByteArrayOutputStream bytearrayoutputstream=null;
        ServletOutputStream out=null;
       try
       {
        out = response.getOutputStream();
       fileinputstream = new FileInputStream(fileFound);
       bytearrayoutputstream = new ByteArrayOutputStream();
       byte abyte0[] = new byte[0x500000];
    do {
          int i = fileinputstream.read(abyte0);
           if (i != -1){
             bytearrayoutputstream.write(abyte0, 0, i);
          bytearrayoutputstream.close();
           }
          else {
            byte abyte1[] = bytearrayoutputstream.toByteArray();
             response.setContentLength(abyte1.length);
             response.setContentType("application/pdf");
             out.write(abyte1, 0, abyte1.length);
             out.flush();
             out.close();
               bytearrayoutputstream.close();
             return;
             }
        } while (true);     
      
       }
       catch(Exception e) {
           System.out.println("inside Exception of writing file in response");
         e.printStackTrace();
       }
       finally
       {
              if(fileFound.exists()) 
              fileFound.delete();
              try{
              fileinputstream.close();
              out.close();
              }
              catch(Exception ex){
                ex.printStackTrace();
              }
       }
	}
	
	
	public void generateUploadedXMLPdf(HttpServletRequest request,HttpServletResponse response,ArrayList<String> list)
	{
	
		Map<String,Object> parameters = new HashMap<String,Object>();
        InputStream imgInputStream =null;
       String numUserId=list.get(0);
      
       //String formno=list.get(1);
      
       String inputFileName=list.get(1);
     
       String strOutputFileName=list.get(2);
      
       String realContextPath="";
     
        String strJasperPath=JRXML_PATH; 
     
        parameters.put("userid",Integer.parseInt(numUserId));
 
       
        strJasperPath=strJasperPath+inputFileName+".jasper";
        System.out.println("Final Jasper Path = "+strJasperPath);

        System.out.println("Final Output File Path = "+PDF_PATH);
        System.out.println("Final Output File Name = "+strOutputFileName);
        try{
        
                  String filpath=generatePdf(strJasperPath,parameters,PDF_PATH+strOutputFileName);  
                 // response.setContentType("application/"+strOutputFileName.substring(strOutputFileName.lastIndexOf(".")+1,strOutputFileName.length()));
                 System.out.println(filpath);
                //  response.setHeader("Content-disposition", "attachment;filename=\""+strOutputFileName);
                  request.setAttribute("pdfFilePath", filpath);
            
        }
        catch(Exception e) {
          e.printStackTrace();
        }
        File fileFound = new File(PDF_PATH+strOutputFileName);
        FileInputStream fileinputstream = null;
        ByteArrayOutputStream bytearrayoutputstream=null;
        ServletOutputStream out=null;
       try
       {
        out = response.getOutputStream();
       fileinputstream = new FileInputStream(fileFound);
       bytearrayoutputstream = new ByteArrayOutputStream();
       byte abyte0[] = new byte[0x500000];
    do {
          int i = fileinputstream.read(abyte0);
           if (i != -1){
             bytearrayoutputstream.write(abyte0, 0, i);
          bytearrayoutputstream.close();
           }
          else {
            byte abyte1[] = bytearrayoutputstream.toByteArray();
             response.setContentLength(abyte1.length);
             response.setContentType("application/pdf");
             out.write(abyte1, 0, abyte1.length);
             out.flush();
             out.close();
               bytearrayoutputstream.close();
             return;
             }
        } while (true);     
      
       }
       catch(Exception e) {
           System.out.println("inside Exception of writing file in response");
         e.printStackTrace();
       }
       finally
       {
              if(fileFound.exists()) 
              fileFound.delete();
              try{
              fileinputstream.close();
              out.close();
              }
              catch(Exception ex){
                ex.printStackTrace();
              }
       }
	}
	
	public void generateProductDetailsPdf(HttpServletRequest request,HttpServletResponse response,ArrayList<String> list)
	{
	
		Map<String,Object> parameters = new HashMap<String,Object>();
        InputStream imgInputStream =null;
       String prodType=list.get(0);
      
       String hsCode=list.get(1);
      
       String inputFileName=list.get(2);
     
       String strOutputFileName=list.get(3);
      
       String realContextPath="";
     
        String strJasperPath=JRXML_PATH; 
     
        parameters.put("prodtype",Integer.parseInt(prodType));
        
        parameters.put("hscode",Integer.parseInt(hsCode));
 
       
        strJasperPath=strJasperPath+inputFileName+".jasper";
        System.out.println("Final Jasper Path = "+strJasperPath);

        System.out.println("Final Output File Path = "+PDF_PATH);
        System.out.println("Final Output File Name = "+strOutputFileName);
        try{
        
                  String filpath=generatePdf(strJasperPath,parameters,PDF_PATH+strOutputFileName);  
                 // response.setContentType("application/"+strOutputFileName.substring(strOutputFileName.lastIndexOf(".")+1,strOutputFileName.length()));
                 
                //  response.setHeader("Content-disposition", "attachment;filename=\""+strOutputFileName);
                  request.setAttribute("pdfFilePath", filpath);
            
        }
        catch(Exception e) {
          e.printStackTrace();
        }
        File fileFound = new File(PDF_PATH+strOutputFileName);
        FileInputStream fileinputstream = null;
        ByteArrayOutputStream bytearrayoutputstream=null;
        ServletOutputStream out=null;
       try
       {
        out = response.getOutputStream();
       fileinputstream = new FileInputStream(fileFound);
       bytearrayoutputstream = new ByteArrayOutputStream();
       byte abyte0[] = new byte[0x500000];
    do {
          int i = fileinputstream.read(abyte0);
           if (i != -1){
             bytearrayoutputstream.write(abyte0, 0, i);
          bytearrayoutputstream.close();
           }
          else {
            byte abyte1[] = bytearrayoutputstream.toByteArray();
             response.setContentLength(abyte1.length);
             response.setContentType("application/pdf");
             out.write(abyte1, 0, abyte1.length);
             out.flush();
             out.close();
               bytearrayoutputstream.close();
             return;
             }
        } while (true);     
      
       }
       catch(Exception e) {
           System.out.println("inside Exception of writing file in response");
         e.printStackTrace();
       }
       finally
       {
              if(fileFound.exists()) 
              fileFound.delete();
              try{
              fileinputstream.close();
              out.close();
              }
              catch(Exception ex){
                ex.printStackTrace();
              }
       }
	}
	
	
}
