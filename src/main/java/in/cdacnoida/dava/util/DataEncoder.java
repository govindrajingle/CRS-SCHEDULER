package in.cdacnoida.dava.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class DataEncoder 
{
  public DataEncoder()
  {
  
  }
  
  
  // To Encode a p;articular String
  public static String encode(String strString_p)
	{
		if(strString_p==null)
			strString_p="";
		else
		{
			try
			{
				strString_p = (new sun.misc.BASE64Encoder()).encode(strString_p.getBytes());
			}

			catch(Exception e){}

		}
		return strString_p;
	}




//TO decode a particular String


public static String decode(String strString_p)
	{
		if(strString_p==null)
			strString_p="";
		else
		{
			try
       {
			strString_p = new String((new sun.misc.BASE64Decoder()).decodeBuffer(strString_p));
       }
			catch(Exception e){}
		}
		return strString_p;
	}


public static String encodeDataUsingBcrypt(String password) {
	
	
	
	String encryptedPassword=BCrypt.hashpw(password, BCrypt.gensalt());
	return encryptedPassword;
}
  
}
