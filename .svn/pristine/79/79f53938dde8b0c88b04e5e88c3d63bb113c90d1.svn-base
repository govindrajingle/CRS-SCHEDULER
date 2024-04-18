package in.cdacnoida.dava.daoservice;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface GenJasperService {
	@Transactional(propagation=Propagation.REQUIRED)
	public void generateCorporatePdf(HttpServletRequest request,HttpServletResponse response, ArrayList<String> list);

	@Transactional(propagation=Propagation.REQUIRED)
	public void generateUploadedXMLPdf(HttpServletRequest request, HttpServletResponse response,
			ArrayList<String> list);

	@Transactional(propagation=Propagation.REQUIRED)
	public void generateProductDetailsPdf(HttpServletRequest request, HttpServletResponse response,
			ArrayList<String> list);

}
