package in.cdacnoida.dava.springsecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import in.cdacnoida.dava.daoimpl.DaoHelper;

@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter{

	private static Logger LOGGER = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Autowired
	private DaoHelper daoHelper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
			if(!shouldExclude(request)) {
				LoggedUser loggedInUser=(LoggedUser) request.getSession().getAttribute("user");
				if(loggedInUser!=null) {
					if(daoHelper!=null) {
						int result=daoHelper.getListJSONUrl("validurl", request.getRequestURI(),loggedInUser.getUserId());
						LOGGER.info("function result {}",result);
					}
				}	
				
			
		}
		return super.preHandle(request, response, handler);
	}
	
	private boolean shouldExclude(HttpServletRequest hreq) {
		if(hreq.getRequestURI().endsWith(".css") ||
                hreq.getRequestURI().endsWith(".js")|| hreq.getRequestURI().endsWith(".png")|| hreq.getRequestURI().endsWith(".json") ||hreq.getRequestURI().endsWith(".jpg")
                || hreq.getRequestURI().endsWith(".jpeg") || hreq.getRequestURI().equals("/IVEDA/getcntstat") || hreq.getRequestURI().equals("/IVEDA/DummyCharts")
                || hreq.getRequestURI().endsWith(".woff2") || hreq.getRequestURI().equals("/IVEDA/error") || hreq.getRequestURI().endsWith(".ttf") || hreq.getRequestURI().equals("/IVEDA/css/")
                || hreq.getRequestURI().equals("/IVEDA/login") || hreq.getRequestURI().equals("/IVEDA/Dashboard") || hreq.getRequestURI().equals("/IVEDA/"))
			return true;
        return false;
   }

	
	
	
}
