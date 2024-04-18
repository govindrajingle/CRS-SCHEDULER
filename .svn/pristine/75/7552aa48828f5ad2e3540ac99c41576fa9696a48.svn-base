package in.cdacnoida.dava.springsecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.http.Cookie;

@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		if(session!=null) {
			session.removeAttribute("user");
		}
		
		// added below code for sth --start--
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (int i = 0; i < cookies.length; i++) {
						Cookie cookie = cookies[i];
						if (cookie.getName().equals("window_count_save")) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						} else if (cookie.getName().equals("hit_count_save")) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
					}
				}
				// added below code for sth --end--
		
		response.sendRedirect(request.getContextPath()+"/logout-success");
	}

}
