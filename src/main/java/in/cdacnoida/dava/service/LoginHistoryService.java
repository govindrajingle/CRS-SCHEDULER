package in.cdacnoida.dava.service;


import org.springframework.transaction.annotation.Transactional;

import in.cdacnoida.dava.entities.LoginHistoryDomain;

public interface LoginHistoryService {
	
	@Transactional
	LoginHistoryDomain saveLoginHistoryDomain(LoginHistoryDomain loginHistoryDomain);
	
	LoginHistoryDomain getLoginHistoryDomain(String sessionId);
	
	public LoginHistoryDomain getLastLoginDetails(long  userId);

}
