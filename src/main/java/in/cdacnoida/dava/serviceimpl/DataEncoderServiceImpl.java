package in.cdacnoida.dava.serviceimpl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Base64;

//import org.apache.commons.net.util.Base64;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.service.DataEncoderService;
@Service
public class DataEncoderServiceImpl implements DataEncoderService
{
  public DataEncoderServiceImpl()
  {
  
  }
  public  String encode(String strString_p)
	{
	  String stringValueBase64Encoded=null;
		if(strString_p==null)
			strString_p="";
		else
		{
			try
			{
				
				stringValueBase64Encoded = Base64.getEncoder().encodeToString(strString_p.getBytes());
				System.out.println(strString_p  + " when Base64 encoded is: " + stringValueBase64Encoded);
				//strString_p = (new sun.misc.BASE64Encoder()).encode(strString_p.getBytes());
				//strString_p = (new Base64().encodeToString(strString_p.getBytes()));
			}

			catch(Exception e){}

		}
		return stringValueBase64Encoded;
	}

  public  String decode(String strString_p)
  {
	  String stringValueBase64Decoded =null;
	if(strString_p==null)
		strString_p="";
	else
	{
	   try
      {
		   byte[]  byteValueBase64Decoded = Base64.getDecoder().decode(strString_p.getBytes());
		    stringValueBase64Decoded = new String(byteValueBase64Decoded);
		   System.out.println(strString_p  + " when Base64 decoded is: " + stringValueBase64Decoded);
		   
				/*
				 * byte bytes[] = Base64.getDecoder().decode(base64); strString_p = new
				 * String((new sun.misc.BASE64Decoder()).decodeBuffer(strString_p));
				 */
      }
			catch(Exception e){}
		}
		return stringValueBase64Decoded;
	}
  
   public static  String decodeNew(String strString_p)
   {
	if(strString_p==null)
		strString_p="";
	else
	{
	   try
       {
		 //strString_p = new String((new sun.misc.BASE64Decoder()).decodeBuffer(strString_p));
		   //strString_p = (new Base64().encodeToString(strString_p.getBytes()));
       }
			catch(Exception e){}
		}
		return strString_p;
	}
}