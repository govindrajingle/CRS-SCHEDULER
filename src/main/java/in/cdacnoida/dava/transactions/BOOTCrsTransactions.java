package in.cdacnoida.dava.transactions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdacnoida.dava.util.BOOTSqlQueries;

@Repository
@Transactional
public class BOOTCrsTransactions {

	@Autowired
	private EntityManager em;
	
	private BOOTSqlQueries queries = new BOOTSqlQueries();
	
	//For select query no parameters return type List
	@SuppressWarnings("unchecked")
	public List<?> SelectDataFromQuerySingleList(String selectQuery) {
		Query q = em.createNativeQuery(selectQuery);
		return q.getResultList();		
	}
	
	//For select query no parameters return type Object
	@SuppressWarnings("unchecked")
	public List<Object[]> SelectDataFromQuery(String selectQuery){
		Query q = em.createNativeQuery(selectQuery);
		return q.getResultList();
	}
	
	//For select query no parameters return type List of String
	@SuppressWarnings("unchecked")
	public List<String> SelectDataFromQueryAsList(String selectQuery){
		Query q = em.createNativeQuery(selectQuery);
		return q.getResultList();
	}	
	
	//For update query no parameter
	public void UpdateDataFromQuery(String selectQuery){
		Query q = em.createNativeQuery(selectQuery);
		q.executeUpdate();
	}	
	
	//For two parameters (select)
	@SuppressWarnings("unchecked")
	public List<Object[]> SelectParameterisedDataFromQuery(String selectQuery, String fieldOne, String fieldTwo, String fieldThree, String fieldFour, String fieldFive){
		Query q = em.createNativeQuery(selectQuery);
		q.setParameter(1, fieldOne);
		q.setParameter(2, fieldTwo);
		return q.getResultList();
	}	
	
	//For four parameters (update)
	public void UpdateFourRecordsParameterisedDataFromQuery(String selectQuery, String fieldOne, String fieldTwo, String fieldThree, String fieldFour, String fieldFive){
		Query q = em.createNativeQuery(selectQuery);
		q.setParameter(1, fieldOne);
		q.setParameter(2, fieldTwo);
		q.setParameter(3, fieldThree);
		q.setParameter(4, fieldFour);
		q.executeUpdate();
	}	

	@SuppressWarnings("unchecked")
	public List<Object[]> DefermentQueryData() {
		String query = queries.getDefermentQuery();
		Query q = em.createNativeQuery(query);
		q.setParameter("currentDate", new java.sql.Timestamp(System.currentTimeMillis() - 24 * 60 * 60 * 1000));
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getQueryData() {
		Query q = em.createNativeQuery(queries.getUpdateLapsingQuery());
		return q.getResultList();
	}

	public void updateQueryData(String applicationId, String regNumber, String strStatus) {
		String query = queries.getInsertLapsingQuery(applicationId, regNumber, strStatus);
		Query q = em.createNativeQuery(query);
		q.setParameter(1, applicationId);
		q.setParameter(2, regNumber);
		q.setParameter(3, strStatus);
		q.executeUpdate();
	}

	public void updateQueryNewStatus(String app_id, String reg_number, String new_status, String str_status) {
		String query = queries.getUpdateQuery(app_id, reg_number, new_status, str_status);
		Query q = em.createNativeQuery(query);
		q.setParameter(1, new_status);
		q.setParameter(2, app_id);
		q.setParameter(3, reg_number);
		q.setParameter(4, str_status);
		q.executeUpdate();
	}

	public void LogSchedularInsertQueryInsert(String app_id, String reg_number, String new_status, String str_status) {
		String query = queries.getLogSchedularInsertQuery(app_id, reg_number, new_status, str_status);
		Query q = em.createNativeQuery(query);
		q.setParameter(1, new_status);
		q.setParameter(2, str_status);
		q.setParameter(3, reg_number);
		q.setParameter(4, app_id);
		q.executeUpdate();
	}

}
