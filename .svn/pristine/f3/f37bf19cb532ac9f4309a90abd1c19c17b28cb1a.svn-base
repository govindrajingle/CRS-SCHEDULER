package in.cdacnoida.dava.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class PDFUtility {

	private static Logger logger2 = LogManager.getLogger(PDFUtility.class);

	private PDFUtility() {
		// Utility classes should not have public constructors (java:S1118)
		throw new IllegalStateException("Custom. Utility class should not be allowed instantiation (@0909 220408)");
	}

	public static boolean validateRequestForFileHPP(String[] paramValues, String hppCodeInRequest) {
		logger2.info("inside validateRequestForFileHPP");
		long inputCode = 0;
		String consttoken = "";
		System.out.println("Value Of TOken: "+hppCodeInRequest);
		  if(hppCodeInRequest.contains("123")) {
			  consttoken = "file123#$";
		  }
		  
		  else if(hppCodeInRequest.contains("456"))
		  {
			  consttoken = "Abcd456#$";
		  }
		  
		  else if(hppCodeInRequest.contains("789"))
		  {
			  consttoken = "Xyz789#$";
		  }
		  
		  else if(hppCodeInRequest.contains("012"))
		  {
			  consttoken = "Pqr012#$";
		  }
		  
		  
		for (String paramValue : paramValues) {
			inputCode += getLongInputCode(paramValue);
		}

		// LOG.info("inputcode"+inputCode)
		String hppCode = getHPPCode(consttoken, (int) (inputCode % 1000));

		
		return hppCode.equals(hppCodeInRequest);

	}

	public static String getHPPCode(String hppCode, int inputCode) {

		int n = inputCode;

		for (int i = 0; i < n; i++) {
			hppCode = encode(hppCode, 3);
		}
		return hppCode;
	}

	public static long getLongInputCode(String input) {
		long output = 0;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			int ascii = c + i;
			output += ascii;
		}
		return output;
	}

	public static String encode(String input, int key) {

		StringBuilder output = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			int ascii = c;
			if (ascii >= 65 && ascii <= 90) {
				output.append((char) ((c - 65 + key) % 26 + 65)); // Uppercase
			} else if (ascii >= 97 && ascii <= 122) {
				output.append((char) ((c - 97 + key) % 26 + 97)); // Lowercase
			} else {
				output.append(c);
			}
		}
		return output.toString();
	}
	
	
	
	
//	public static boolean validateRequestForFileHPP2(String[] paramValues, String hppCodeInRequest) {
//	
//		String inputCode = "";
//		String consttoken = "";
//	
//		  
//		  
//		for (String paramValue : paramValues) {
//			
//			inputCode += getLongInputCode2(paramValue);
//			
//			System.err.println("inputCode : " + inputCode);
//		}
//		
//		System.err.println("Input code value new: "+inputCode);
//        System.err.println("Hpp Code in Request Value: "+hppCodeInRequest);
//		if(inputCode.equals(hppCodeInRequest)) {
//			return true;
//		}
//		return false;
//}
//	 public static int getLongInputCode2(String fileContent) {
//		
//		 int uniqueCode = 0;
//
//		    for (int i = 0; i < fileContent.length(); i++) {
//		    	 
//		    	char c = fileContent.charAt(i);
//		        int ascii = c + i;
//		        uniqueCode += ascii;
//		    }
//		    System.err.println("Unique Code Value: "+uniqueCode);
//		    return uniqueCode;
//	 }


}


