package in.cdacnoida.dava.transactions;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdacnoida.dava.daoimpl.DaoHelper;
import in.cdacnoida.dava.entities.LoginHistoryDomain;

@Repository
public class LoginHistoryDao {
	
	@Autowired
	DaoHelper daoHelper;

	public LoginHistoryDomain saveLoginHistoryDomain(LoginHistoryDomain loginHistoryDomain){
		return daoHelper.merge(LoginHistoryDomain.class,loginHistoryDomain);
	}
	
	public LoginHistoryDomain getLoginHistoryDomain(String sessionId){
		String query = "from LoginHistoryDomain where logoutDate is null and numIsValid=1 and sessionId='"+sessionId+"'";
		List<LoginHistoryDomain> dataList = daoHelper.findByQuery(query);
		if(dataList.size()>0){
			return dataList.get(0);
		}else
			return null;		
	}
	
	public LoginHistoryDomain getLastLoginDetails(long  userId){
		String query = "from LoginHistoryDomain where  numIsValid=1 and userId="+userId +" order by loginDate desc";
		List<LoginHistoryDomain> dataList = daoHelper.findByQuery(query);
		if(dataList.size()>0){
			return dataList.get(0);
		}else
			return null;		
	}
	
}
