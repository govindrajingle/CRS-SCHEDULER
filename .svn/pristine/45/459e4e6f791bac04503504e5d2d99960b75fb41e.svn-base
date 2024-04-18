package in.cdacnoida.dava.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.entities.LoginHistoryDomain;
import in.cdacnoida.dava.service.LoginHistoryService;
import in.cdacnoida.dava.transactions.LoginHistoryDao;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {

	@Autowired
	LoginHistoryDao loginHistoryDao;
	
	@Override
	public LoginHistoryDomain saveLoginHistoryDomain(LoginHistoryDomain loginHistoryDomain) {		
		return loginHistoryDao.saveLoginHistoryDomain(loginHistoryDomain);
	}
	
	@Override
	public 	LoginHistoryDomain getLoginHistoryDomain(String sessionId){
		return loginHistoryDao.getLoginHistoryDomain(sessionId);
	}
	
	@Override
	public LoginHistoryDomain getLastLoginDetails(long  userId){
		return loginHistoryDao.getLastLoginDetails(userId);
	}

}
