package in.cdacnoida.dava.misc;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;	
import org.apache.http.client.methods.HttpPost;	
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;



public class SMSHttpPostClient {

	/*
	 * static String username = "ecdsco"; static String password = "cdsco@123";
	 * static String senderid = "eCDSCO"; static String SMS_URL
	 * ="https://msdgweb.mgov.gov.in/esms/sendsmsrequest"; static String
	 * SMS_SECURE_KEY="939e0a58-4f55-47cb-8087-eb597a9537cf";
	 */

	
	  static String username = "ADIPDEPwD"; static String password =
	  "AdipsectionDD1!"; static String senderid = "ADIPDA"; static String SMS_URL
	  ="https://msdgweb.mgov.gov.in/esms/sendsmsrequestDLT"; static String
	  SMS_SECURE_KEY="27daef86-51a4-4c87-8e1b-b899a670bb6c";
	 
	
		/*
		 * static String username = "dgdesk@pharmexcil.com"; static String password =
		 * "iVEDAsms@23!"; static String senderid = "IVEDAS"; static String SMS_URL
		 * ="https://msdgweb.mgov.gov.in/esms/sendsmsrequestDLT"; static String
		 * SMS_SECURE_KEY="27daef86-51a4-4c87-8e1b-b899a670bb6c";
		 */
	
	  
	static String message = "Test";
	static HttpURLConnection connection = null;
	public static void sendSingleSMS(String mobileNo, String message) {
		sendSingleSMSInner(username, password , message , senderid, mobileNo,SMS_SECURE_KEY);
	}
	 public static String sendSingleSMSInner(String username, String password , String message , String senderId, String mobileNumber,String secureKey){
	      
	      
	      String responseString = "";
	      SSLSocketFactory sf=null;
	      SSLContext context=null;
	      String encryptedPassword;
	      try {
	        context=SSLContext.getInstance("TLSv1.2");
	        context.init(null, null, null);
	        sf=new SSLSocketFactory(context, SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
	        Scheme scheme=new Scheme("https",443,sf);
	        HttpClient client=new DefaultHttpClient();
	        client.getConnectionManager().getSchemeRegistry().register(scheme);
	        HttpPost post=new HttpPost(SMS_URL);
	        encryptedPassword  = MD5(password);
	        message = message.trim();
	        String genratedhashKey = hashGenerator(username, senderId, message, secureKey);
	        List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(1);
	        nameValuePairs.add(new BasicNameValuePair("mobileno", mobileNumber));
	        nameValuePairs.add(new BasicNameValuePair("senderid", senderId));
	        nameValuePairs.add(new BasicNameValuePair("content", message));
	        nameValuePairs.add(new BasicNameValuePair("smsservicetype", "singlemsg"));
	        nameValuePairs.add(new BasicNameValuePair("username", username));
	        nameValuePairs.add(new BasicNameValuePair("password", encryptedPassword));
	        nameValuePairs.add(new BasicNameValuePair("key", genratedhashKey));
	        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	        HttpResponse response=client.execute(post);
	        BufferedReader bf=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	        String line="";
	        while((line=bf.readLine())!=null){
	          responseString = responseString+line;
	          
	        }
	        System.out.println(responseString);
	      } catch (NoSuchAlgorithmException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      } catch (KeyManagementException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      } catch (UnsupportedEncodingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      } catch (ClientProtocolException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	      return responseString;
	    }
	 /****
	     * Method  to convert Normal Plain Text Password to MD5 encrypted password
	     ***/
	    
	    private static String MD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  
	    { 
	      MessageDigest md;
	      md = MessageDigest.getInstance("SHA-1");
	      byte[] md5 = new byte[64];
	      md.update(text.getBytes("iso-8859-1"), 0, text.length());
	      md5 = md.digest();
	      return convertedToHex(md5);
	    }
	    
	    private static String convertedToHex(byte[] data) 
	    { 
	      StringBuffer buf = new StringBuffer();

	      for (int i = 0; i < data.length; i++) 
	      { 
	        int halfOfByte = (data[i] >>> 4) & 0x0F;
	        int twoHalfBytes = 0;

	        do 
	        { 
	          if ((0 <= halfOfByte) && (halfOfByte <= 9)) 
	          {
	            buf.append( (char) ('0' + halfOfByte) );
	          }

	          else 
	          {
	            buf.append( (char) ('a' + (halfOfByte - 10)) );
	          }

	          halfOfByte = data[i] & 0x0F;

	        } while(twoHalfBytes++ < 1);
	      } 
	      return buf.toString();
	    }
	    
	    protected static String hashGenerator(String userName, String senderId, String content, String secureKey) {
	        // TODO Auto-generated method stub
	        StringBuffer finalString=new StringBuffer();
	        finalString.append(userName.trim()).append(senderId.trim()).append(content.trim()).append(secureKey.trim());
	        //    logger.info("Parameters for SHA-512 : "+finalString);
	        String hashGen=finalString.toString();
	        StringBuffer sb = null;
	        MessageDigest md;
	        try {
	          md = MessageDigest.getInstance("SHA-512");
	          md.update(hashGen.getBytes());
	          byte byteData[] = md.digest();
	          //convert the byte to hex format method 1
	          sb = new StringBuffer();
	          for (int i = 0; i < byteData.length; i++) {
	            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	          }

	        } catch (NoSuchAlgorithmException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }
	        return sb.toString();
	      }

	    /*Unit Test*/
	    
	/*public static void main(String args[])
	{
		sendSingleSMS("8755888899","Hello from Track and trace");
	}*/

	    
	    
	    
	    
	    //FOR TEMPLATE ID 
	    
	    
	    public static void sendSingleSMS(String mobileNo, String message,String templateid) {
	    	sendSingletSMSInner(username, password , message , senderid, mobileNo,SMS_SECURE_KEY,templateid);
		}
		
	    
	    public static String sendSingletSMSInner(String username, String password , String message , String senderId, String mobileNumber,String secureKey,String templateid){
		      
			 String responseString = "";
		      SSLSocketFactory sf=null;
		      SSLContext context=null;
		      String encryptedPassword;
		      try {
		        context=SSLContext.getInstance("TLSv1.2");
		        context.init(null, null, null);
		        sf=new SSLSocketFactory(context, SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
		        Scheme scheme=new Scheme("https",443,sf);
		        HttpClient client=new DefaultHttpClient();
		        client.getConnectionManager().getSchemeRegistry().register(scheme);
		        HttpPost post=new HttpPost(SMS_URL);
		        encryptedPassword  = MD5(password);
		        // message="Dear XYZ you are successfully registered on DRDO ePPMS portal. Kindly activate your account by using verification link sent to testemailid. For queries, write to helpdeskemail.- DRDO";
		        //message = message.trim();
		        //System.out.println("oooo "+message);
		        String genratedhashKey = hashGenerator(username, senderId, message, secureKey);
		        List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(1);
		        nameValuePairs.add(new BasicNameValuePair("mobileno", mobileNumber));
		        nameValuePairs.add(new BasicNameValuePair("senderid", senderId));
		        nameValuePairs.add(new BasicNameValuePair("content", message));
		        nameValuePairs.add(new BasicNameValuePair("smsservicetype", "singlemsg"));
		        nameValuePairs.add(new BasicNameValuePair("username", username));
		        nameValuePairs.add(new BasicNameValuePair("password", encryptedPassword));
		        nameValuePairs.add(new BasicNameValuePair("key", genratedhashKey));
		        nameValuePairs.add(new BasicNameValuePair("templateid", templateid));
		        
		        System.out.println(mobileNumber+","+senderId+","+message+","+username+","+templateid);
		        
		        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        HttpResponse response=client.execute(post);
		        BufferedReader bf=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		        String line="";
		        while((line=bf.readLine())!=null){
		          responseString = responseString+line;
		          
		        }
		        System.out.println(responseString);
		      } catch (NoSuchAlgorithmException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      } catch (KeyManagementException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      } catch (UnsupportedEncodingException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      } catch (ClientProtocolException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      }
		      System.out.println("responseString "+responseString);
		      return responseString;
		    }
	    
	    
	    
	    
	    
}

