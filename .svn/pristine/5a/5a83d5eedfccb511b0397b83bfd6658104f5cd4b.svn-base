package in.cdacnoida.dava.util;

import java.io.File;
import java.io.InputStream;

import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;

public class PDFUtility2 {
	
	public static boolean validateRequestForFileHPP(String[] paramValues, String hppCodeInRequest) {  		
		System.out.println(" inside validateRequestForFileHPP");
		long inputCode = 0;  	
		String consttoken="file123#$";
		for (String paramValue : paramValues) { 			
		inputCode += getLongInputCode(paramValue); 	
		
		} 
		//System.out.println("inputcode"+inputCode);
		String hppCode = getHPPCode(consttoken, (int) (inputCode % 1000)); 		
		 System.out.println("Calculated HPP Code: " + hppCode); 		
		 System.out.println("HPP Code in Request: " + hppCodeInRequest);  	
		 
		 System.out.println("Token Comparision "+hppCode.equals(hppCodeInRequest));
		 
		if (!hppCode.equals(hppCodeInRequest)) { 			
		return false; 		
		} else { 			
		return true; 		
		} 	
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
			int ascii = (int) c + i;
			output += ascii;
		}
		return output;
	}
	
	public static String encode(String input, int key) {

		StringBuffer output = new StringBuffer();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			int ascii = (int) c;

			if (ascii >= 65 && ascii <= 90) {
				output.append((char) ((c - 65 + key) % 26 + 65)); // Uppercase

			} else if (ascii >= 97 && ascii <= 122) {
				output.append((char) ((c - 97 + key) % 26 + 97)); // Lowercase

			} else {
				output.append(c);
			}
		}
		return output.toString();}
	
	
	public static boolean isSafe(InputStream f) {
        boolean safeState = false;
        try {
            if ((f != null)) {
                // Load stream in PDF parser
                // If the stream is not a PDF then exception will be throwed
                // here and safe state will be set to FALSE
                PdfReader reader = new PdfReader(f);
                // Check 1:
                // Detect if the document contains any JavaScript code
                String jsCode = reader.getJavaScript();
                if (jsCode == null) {
                    // OK no JS code then when pass to check 2:
                    // Detect if the document has any embedded files
                    PdfDictionary root = reader.getCatalog();
                    PdfDictionary names = root.getAsDict(PdfName.NAMES);
                    PdfArray namesArray = null;
                   if (names != null) {
                        PdfDictionary embeddedFiles = names.getAsDict(PdfName.EMBEDDEDFILES);
                        //namesArray = embeddedFiles.getAsArray(PdfName.NAMES);
                    }
                    // Get safe state from number of embedded files
                    safeState = ((namesArray == null) || namesArray.isEmpty());
                }
            }
        } catch (Exception e) {
            safeState = false;
         //   LOG.warn("Error during Pdf file analysis !", e);
        }
        return safeState;
    }



}
