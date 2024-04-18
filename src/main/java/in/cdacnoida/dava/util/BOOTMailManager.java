package in.cdacnoida.dava.util;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
public class BOOTMailManager {

	@Value("${MAIL_URL}")
	private String mailUrl;

	@Value("${MAIL_CONTENT_LIST}")
	private String mailContentListFilePath;

	ArrayList<String> list_mailContents=new ArrayList<String>(); 
	
	public ArrayList<String> getMailContent(String p_strMailContent) {
		System.out.println(LocalDateTime.now() + " BOOTMailManager class called " + p_strMailContent);
		// strXMLPath = strXMLPath +"/app_srv/tdc/gl/xml/mailContentList.xml";
		System.out.println("Path of the xml file " + mailContentListFilePath);
		Node Node_Listing = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d1 = db.parse(mailContentListFilePath);
			NodeList nodeList = d1.getElementsByTagName("MAILCONTENT");
			for (int ii = 0; ii < nodeList.getLength(); ii++) {
				String strList = (nodeList.item(ii)).getAttributes().getNamedItem("NAME").getNodeValue();
				if (strList.equals(p_strMailContent)) {
					Node_Listing = nodeList.item(ii);
					break;
				}
			}
	        NodeList List_nodes=null;
	        List_nodes=Node_Listing.getChildNodes();
	        for(int ii=0;ii<List_nodes.getLength();ii++)
	         {
	            if(List_nodes.item(ii).getNodeName().equalsIgnoreCase("SUBJECT"))
	                list_mailContents.add(0,List_nodes.item(ii).getFirstChild().getNodeValue());
	            else if(List_nodes.item(ii).getNodeName().equalsIgnoreCase("BODY"))   
	                list_mailContents.add(1,List_nodes.item(ii).getFirstChild().getNodeValue());
	             else if(List_nodes.item(ii).getNodeName().equalsIgnoreCase("SIGNATURE"))   
	                list_mailContents.add(2,List_nodes.item(ii).getFirstChild().getNodeValue());
	         }			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(list_mailContents.toString());
		return list_mailContents;
	}
}