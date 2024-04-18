package in.cdacnoida.dava.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoHelper {
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public <T> T persist(final Class<T> entityClass, final T entity) {

		if (null == entityClass){
			throw new IllegalArgumentException("entityClass can't be null");
		}
		if (null == entity){
			throw new IllegalArgumentException("entity can't be null");
		}
		Session session = null;
	    Transaction transaction = null;
	    try {
	    	session = getSession();
	    	transaction = session.beginTransaction();
	    	session.persist(entity);
	    	transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	        	transaction.rollback();
	        }
	        e.printStackTrace();
	      } finally {
	    	  if (session != null) {
	    		  session.close();
	    	  }
	      }
//	      entityManager.persist(entity);
		return entity;
	}

	public <T> T persistNew(final Class<T> entityClass, final T entity) {

		if (null == entityClass)
			throw new IllegalArgumentException("entityClass can't be null");
		if (null == entity)
			throw new IllegalArgumentException("entity can't be null");

		Session session = null;
	    Transaction transaction = null;
	    try {
		session = getSession();
	      transaction = session.getTransaction();
	      transaction.begin();
	      session.persist(entity);
//	      entityManager.persist(entity);
	      transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	          transaction.rollback();
	        }
	        e.printStackTrace();
	      } finally {
	        if (session != null) {
	          session.close();
	        }
	      }

		return entity;
	}
	
	
	
	
	
	
	/**
	 * Casts the result to a particular class type
	 * 
	 * @param <T>
	 * @param results
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> List<T> castResultList(List<?> results) {
		return (List<T>) results;
	}

	
	
	/**
	 * Casts the result to a particular integer type
	 * 
	 * @param <T>
	 * @param results
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <Integer> List<Integer> castResultListInt(List<?> results) {
		return (List<Integer>) results;
	}
	
 
   
   
	
	
	
	
	
	
	
	
	public String getListJSON(String fun, int divisionId )
	{
		
		String resulString ="";
		//Session session = (Session) entityManager.getDelegate();
		//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
		conn = getConnection();
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement("select "+fun+"(?)");
		stmt.setInt(1,divisionId);
		ResultSet rs = stmt.executeQuery(); 
	    rs.next(); 
	    if(rs.getObject(1)!=null)
	    resulString=rs.getObject(1).toString();
	    rs.close(); 
	   
		conn.commit();
		} catch (SQLException e) {
			resulString ="";
			e.printStackTrace();
		}finally{
			try {
				
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return resulString;
	}

	public String checklistJSON(String fun, String searchTerm,String Query,int sAmount,int sStart )
	{
		
		String resulString ="";
		//Session session = (Session) entityManager.getDelegate();
		//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
		conn = getConnection();
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement("select "+fun+"(?,?,?,?)");
		stmt.setString(1,searchTerm);
		stmt.setString(2,Query);
		stmt.setInt(3,sAmount);
		stmt.setInt(4,sStart);
		ResultSet rs = stmt.executeQuery(); 
	    rs.next(); 

	    resulString=rs.getObject(1).toString();
	    rs.close(); 
	   
		conn.commit();
		} catch (SQLException e) {
			resulString ="";
			e.printStackTrace();
		}finally{
			try {
				
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return resulString;
	}
	

	/*
	 * public String callProcedure(String fun, long ...intargs) { String resulString
	 * =""; Session session = getSession(); try { ProcedureCall procedureCall =
	 * session.createStoredProcedureCall(fun); int i=0; for (long arg : intargs) {
	 * i++; procedureCall.registerParameter(i, Long.class, ParameterMode.IN);
	 * procedureCall.getParameterRegistration(i).bindValue(arg); } ProcedureOutputs
	 * procedureOutputs = procedureCall.getOutputs(); ResultSetOutput
	 * resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
	 * 
	 * List results = resultSetOutput.getResultList(); resulString
	 * =(String)resultSetOutput.getSingleResult(); if(resulString==null ||
	 * resulString.trim() ==""){ resulString = "NA"; } } catch (Exception e) {
	 * resulString =""; e.printStackTrace(); }finally{ try { session.close(); }
	 * catch (Exception e) { e.getMessage(); } } return resulString; }
	 */
	
	//added by shruti on 24-11-2017
	public int deleteByQuery(final String query,ArrayList<Object> paraList) {
		Query query1=entityManager.createQuery(query);
		if(paraList.size()>0){
			for(int i=0;i<paraList.size();i++){
				query1.setParameter(i+1, paraList.get(i));
			}
			}
		return	query1.executeUpdate();
		
	}
	
	public String Viewxml(String fun,int formno, int formid) {

		String resulString ="";
		Session session = getSession();
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(2, Integer.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(formno);
			procedureCall.getParameterRegistration(2).bindValue(formid);
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

			List results = resultSetOutput.getResultList();
			resulString =(String)resultSetOutput.getSingleResult();
		} catch (Exception e) {
			resulString ="";
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString;		
}


	public List<String>  DashboardCount(String fun,int formno, int formid) {
		List<String> resulString = new ArrayList<String>();
		Session session = getSession();
		
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(2, Integer.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(formno);
			procedureCall.getParameterRegistration(2).bindValue(formid);                
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			resulString = resultSetOutput.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString; 
}

	public void fileSubmission(String fun, int formNo, int formId) {
		Session session = getSession();
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(2, Integer.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(formNo);
			procedureCall.getParameterRegistration(2).bindValue(formId);                
			procedureCall.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
	
	public void insertToQueryMst(String procedureName, String queryText,int seqNo,int numFormId,int numFormNo,int decision,int userId) {
		Session session = getSession();
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(procedureName);
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(2, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(3, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(4, String.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(seqNo);
			procedureCall.getParameterRegistration(2).bindValue(decision);                
			procedureCall.getParameterRegistration(3).bindValue(userId);
			procedureCall.getParameterRegistration(4).bindValue(queryText);                
			procedureCall.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
	
	
	public String checkUrlAuth(String funName,Long userId,String uri) {
		String resulString="";
		Session session = getSession();
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(funName);
			procedureCall.registerParameter(1, Long.class, ParameterMode.IN);
			procedureCall.registerParameter(2, String.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(userId);
			procedureCall.getParameterRegistration(2).bindValue(uri);
			procedureCall.execute();
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			List results = resultSetOutput.getResultList();
			resulString =(String)resultSetOutput.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return resulString;
	}
	

  // ADDED BY DEEPSHIKHA
	public String callProcedurePortData(String funName, String  username) {
		Session session = getSession();
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(funName);
			procedureCall.registerParameter(1, String.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(username);
			procedureCall.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return username;
 	}
	
	public <T> List<T> findByQuery(final String query) {
		Query query1 = entityManager.createQuery(query);
		return castResultList(query1.getResultList());
	}
	
	public <T> List<T> findByQuery(final String query, ArrayList<Object> paraList) {
		Session session = (Session) entityManager.getDelegate();
		SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
		Query queryObj = session.createQuery(query);
		List<T> datalist=new ArrayList<T>();
		int count=1;
		try {
		if(paraList.size()>0){
	 		for(int i=0;i<paraList.size();i++){
	 			queryObj.setParameter(count, paraList.get(i));
	 			count++;
	 		}
	 		}
		datalist=queryObj.getResultList();
		} catch (Exception e) {
			e.getMessage();
		}finally{
			try {
				session.close();
			} catch (Exception e) {
				e.getMessage();
			    }
		  }  	 
  	 
		return datalist;
	}
	
	public int deleteByAttribute(final Class<?> entityClass,
			final String attributeName, final Object attributeValue) {
		if (null == entityClass)
			throw new IllegalArgumentException("entityClass can't be null");
		if (null == attributeName)
			throw new IllegalArgumentException("attributeName can't be null");
		if (null == attributeValue)
			throw new IllegalArgumentException("attributeValue can't be null");

		return entityManager
				.createQuery(
						"delete from " + entityClass.getSimpleName()
								+ " e where e." + attributeName + " = ?1")
				.setParameter(1, attributeValue).executeUpdate();
	}
	
	//added by sonam
	public String GenerateAppNo(String fun,long formNo, long formId,long divisionId,long caseId) {
		Session session = getSession();
		String resulString="";
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, Long.class, ParameterMode.IN);
			procedureCall.registerParameter(2, Long.class, ParameterMode.IN);
			procedureCall.registerParameter(3, Long.class, ParameterMode.IN);
			procedureCall.registerParameter(4, Long.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(formNo);
			procedureCall.getParameterRegistration(2).bindValue(formId);                
			procedureCall.getParameterRegistration(3).bindValue(divisionId);
			procedureCall.getParameterRegistration(4).bindValue(caseId);                
			procedureCall.execute();
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			List results = resultSetOutput.getResultList();
			resulString =(String)resultSetOutput.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString; 
	}
	
/*	//ADDED BY SONAM
	public String Viewxml(String fun,int formno, int formid) {
		String resulString ="";
		Session session = (Session) entityManager.getDelegate();
		SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
		ConnectionProvider cp = sfi.getConnectionProvider();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
		conn = cp.getConnection();
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement("select "+fun+"(?,?)");
		stmt.setInt(1,formno);
		stmt.setInt(2,formid);
		ResultSet rs = stmt.executeQuery(); 
	    rs.next(); 

	    resulString=rs.getString(1);
	    rs.close(); 
	//	resulString = stmt.getInt(1);
        System.out.println("resulString=="+resulString);
		conn.commit();
		} catch (SQLException e) {
			resulString ="NA";
			e.printStackTrace();
		}finally{
			try {
				
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resulString; 
}*/
//added by sonam
	public String findByFun(String fun, int formid,int formno,Timestamp dt) {
		Session session = getSession();
		String resulString="";
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(2, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(3, Timestamp.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(formid);
			procedureCall.getParameterRegistration(2).bindValue(formno);                
			procedureCall.getParameterRegistration(3).bindValue(dt);
			procedureCall.executeUpdate();
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			List results = resultSetOutput.getResultList();
			resulString =(String)resultSetOutput.getSingleResult();
			if(resulString==null || resulString.trim() ==""){
				resulString = "Approval No"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString; 
	}

	public String getName(String fun,int ...args) {
		Session session = getSession();
		String resulString="";
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);

			int i=0;
			for (int arg : args) {
				i++;
				procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
				procedureCall.getParameterRegistration(i).bindValue(arg);
		    }
			
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			List results = resultSetOutput.getResultList();
			resulString =(String)resultSetOutput.getSingleResult();
			if(resulString==null || resulString.trim() ==""){
				resulString = "No Data"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString;
}
/*	
	public int dmlFileTransfer(String fun,int formNo,int formId,int transferSeatId,int numStatus, String remarks ) {
		int resulString =0;
		Session session = (Session) entityManager.getDelegate();
		SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
		ConnectionProvider cp = sfi.getConnectionProvider();
		Connection conn = null; CallableStatement stmt =null;
		
		try {
		conn = cp.getConnection();
		conn.setAutoCommit(false);
	    stmt = conn.prepareCall(fun);
	    // Register the type of the IN/OUT parameter
	  //  stmt.registerOutParameter(1, Types.INTEGER);
	    // Set the value for the IN/OUT parameter
		stmt.setInt(1, formNo); stmt.setInt(2, formId); stmt.setInt(3, transferSeatId); stmt.setInt(4, numStatus); stmt.setString(5, remarks);
		resulString = stmt.executeUpdate();
	  //  rs.next(); 
	 //   resulString=rs.getInt(1);	   
	    System.out.println("resul;t=="+resulString);
		conn.commit();
		return resulString;
		} catch (SQLException e) {
			resulString =2;
			e.printStackTrace();
			return resulString;
		}finally{
			try {
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
}
*/	
	
	public int dmlFileTransfer(String fun,int formNo,int formId,int transferSeatId,int numStatus, String remarks ) 
	{
		Session session = getSession();
		int resulString=0;
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(2, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(3, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(4, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(5, String.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(formNo);
			procedureCall.getParameterRegistration(2).bindValue(formId);                
			procedureCall.getParameterRegistration(3).bindValue(transferSeatId);
			procedureCall.getParameterRegistration(4).bindValue(numStatus);
			procedureCall.getParameterRegistration(5).bindValue(remarks);
			procedureCall.execute();
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			List results = resultSetOutput.getResultList();
			resulString =(Integer)resultSetOutput.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString; 
	}
	
	public String Viewxml(String fun,Integer userid) {
		Session session = getSession();
		String resulString="";
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(userid);
			procedureCall.execute();
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			List results = resultSetOutput.getResultList();
			resulString =(String)resultSetOutput.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString; 
	}
	
	public String Viewxml(String fun, int formid) {
		String resulString ="";
//		Session session = (Session) entityManager.getDelegate();
//		SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
//		ConnectionProvider cp = sfi.getConnectionProvider();

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
		conn = getConnection();
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement("select "+fun+"(?)");
		stmt.setInt(1,formid);
		ResultSet rs = stmt.executeQuery(); 
	    rs.next(); 

	    resulString=rs.getString(1);
	    rs.close(); 
	//	resulString = stmt.getInt(1);
        System.out.println("resulString=="+resulString);
		conn.commit();
		} catch (SQLException e) {
			resulString ="NA";
			e.printStackTrace();
		}finally{
			try {
				
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resulString; 
}
	public String Viewxml1(String fun, int formid) {
		String resulString ="";
//		Session session = (Session) entityManager.getDelegate();
//		SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
//		ConnectionProvider cp = sfi.getConnectionProvider();

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
		conn = getConnection();
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement("select "+fun+"(?)");
		stmt.setInt(1,formid);
		ResultSet rs = stmt.executeQuery(); 
	    rs.next(); 

	    resulString=rs.getString(1);
	    rs.close(); 
	//	resulString = stmt.getInt(1);
        System.out.println("resulString=="+resulString);
		conn.commit();
		} catch (SQLException e) {
			resulString ="NA";
			e.printStackTrace();
		}finally{
			try {
				
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resulString; 
}
	public String ViewxmlForFunction(String fun,Integer userid) {
		Session session = getSession();
		String resulString="";
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(userid);
			procedureCall.execute();
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			List results = resultSetOutput.getResultList();
			
			resulString =resultSetOutput.getSingleResult()+"";
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString; 
	}
	
	
	
	public String findByFun1(String fun, Long attributeValue) {
		Session session = getSession();
		String resulString="";
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, Long.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(attributeValue);
			procedureCall.executeUpdate();
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			List results = resultSetOutput.getResultList();
			resulString =(String)resultSetOutput.getSingleResult();
			if(resulString==null || resulString.trim() ==""){
				resulString = "No Data"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString; 
	}

	public String generateFun(String fun, String format) 
	{
		Session session = getSession();
		String resulString="";
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, String.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(format);
			procedureCall.execute();
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			List results = resultSetOutput.getResultList();
			resulString =(String)resultSetOutput.getSingleResult();
			if(resulString==null || resulString.trim() ==""){
				resulString = "No Data"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString; 
		
	}
	
	// Added By Deepshikha (21-08-2018)
	
	public int ReportStatusFunction(String fun,int specId, int frwdMode) 
	{
		Session session =getSession();
		int resulString=0;
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
			procedureCall.registerParameter(2, Integer.class, ParameterMode.IN);
			procedureCall.getParameterRegistration(1).bindValue(specId);
			procedureCall.getParameterRegistration(2).bindValue(frwdMode);
			procedureCall.execute();
			ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
			ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
			List results = resultSetOutput.getResultList();
			resulString =(int)resultSetOutput.getSingleResult();
			System.out.println("result String == "+resulString);
			/*if(resulString==null || resulString.trim() ==""){
				resulString = "No Data"; 
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			    session.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return resulString; 
		
	}
	public String getListJSONByInstId(String fun, int instId, int divisionId) {
		
		String resulString ="";
		//Session session = (Session) entityManager.getDelegate();
		//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
		conn = getConnection();
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement("select "+fun+"(?,?)");
		stmt.setInt(1,instId);
		stmt.setInt(2,divisionId);
		ResultSet rs = stmt.executeQuery(); 
	    rs.next(); 

	    resulString=rs.getObject(1).toString();
	    rs.close(); 
	   
		conn.commit();
		} catch (SQLException e) {
			resulString ="";
			e.printStackTrace();
		}finally{
			try {
				
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return resulString;
	}
	
	public int getListJSONUrl(String fun, String url, Long divisionId) {
		
		int resulString =0;
		//Session session = (Session) entityManager.getDelegate();
		//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
		conn = getConnection();
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement("select "+fun+"(?,?)");
		stmt.setString(1,url);
		stmt.setLong(2,divisionId);
		ResultSet rs = stmt.executeQuery(); 
	    rs.next(); 

	    resulString=(int) rs.getObject(1);
	    rs.close(); 
	   
		conn.commit();
		} catch (SQLException e) {
			resulString = 0;
			e.printStackTrace();
		}finally{
			try {
				
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return resulString;
	}
	
	//added by harshita
	public String getcount(String fun, String userName) {
		
		String  resulString;
			
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
		conn = getConnection();
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement("select "+fun+"(?)");
		stmt.setString(1,userName);
		ResultSet rs = stmt.executeQuery(); 
	    rs.next(); 

	    System.out.println("iVEDA111:::"  +""+ rs.getObject(1));
	    
	    
	    resulString=(String) rs.getObject(1);
	    System.out.println("iVEDA"  +""+ resulString );
	    rs.close(); 
	   
		conn.commit();
		} catch (SQLException e) {
			resulString = "0";
			e.printStackTrace();
		}finally{
			try {
				
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return resulString;
	}
	
	
	
	
	
	
	
	
	public String updateAmmendReportDatabase(String fun,int sampleId, int newDocId, int userId, String remarks) {
		System.out.println("in dao");
		String resulString ="";
		//Session session = (Session) entityManager.getDelegate();
		//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();		
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
		conn = getConnection();
		conn.setAutoCommit(false);
	
		stmt = conn.prepareStatement("select "+fun+"(?,?,?,?)");
		stmt.setInt(1,sampleId);
		stmt.setInt(2,newDocId);
		stmt.setInt(3,userId);
		stmt.setString(4,remarks);
		ResultSet rs = stmt.executeQuery();
		
	    rs.next(); 
	    resulString=rs.getObject(1).toString();
	    rs.close(); 
	   
		conn.commit();
		} catch (SQLException e) {
			resulString = "";
			e.printStackTrace();
		}finally{
			try {
				
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return resulString;
		
	}
	
	public String getListJSON3Param(String fun,Long userId, String macAdd, String PublicKey) {
		System.out.println("in dao");
		String resulString ="";
		//Session session = (Session) entityManager.getDelegate();
		//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();		
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
		conn = getConnection();
		conn.setAutoCommit(false);
	
		stmt = conn.prepareStatement("select "+fun+"(?,?,?)");
		stmt.setLong(1,userId);
		stmt.setString(2,macAdd);
		stmt.setString(3,PublicKey);
		ResultSet rs = stmt.executeQuery();
		
	    rs.next(); 
	    resulString=rs.getObject(1).toString();
	    rs.close(); 
	   
		conn.commit();
		} catch (SQLException e) {
			resulString = "";
			e.printStackTrace();
		}finally{
			try {
				
				conn.setAutoCommit(true);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return resulString;
		
	}
	
	
	
	  public Connection getConnection(){	   
	    	Session session = (Session) entityManager.getDelegate();
	    	SessionFactory sessionFactory= session.getSessionFactory();
	    	Connection connection=null;
	    	try {
	    		connection = sessionFactory.getSessionFactoryOptions().getServiceRegistry().
				getService(ConnectionProvider.class).getConnection();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
	   
	    	//System.out.println("Connection Obj "+connection);
	    	return connection;
	    }
	  
	  
	  public Session getSession() {
		  Session session = (Session) entityManager.getDelegate();
		  return session;
	  }
	  
	  public Object setRCMCData(String fun, String data) {
		
				Object resulString ="";
				//Session session = (Session) entityManager.getDelegate();
				//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
			
				Connection conn = null;
				PreparedStatement stmt = null;
			try {
				conn = getConnection();
				conn.setAutoCommit(false);
				System.out.println(data);
				/*if(data != null)
		        {
					System.out.println(data);
					String query = "update testing_dtl set num_sugam_status=1";
					stmt = conn.prepareStatement(query);	
					stmt.executeUpdate();
					System.out.println("Data Send");
		        }
				else
				{
					String query = "update testing_dtl set num_sugam_status=2";
					stmt = conn.prepareStatement(query);
					stmt.executeUpdate();
					System.out.println("Data send but not received");
				}*/
				stmt = conn.prepareStatement("select "+fun+"(?::jsonb)");
				stmt.setString(1,data);
				ResultSet rs = stmt.executeQuery();
				
			    rs.next(); 
			    
					    
			    resulString=rs.getObject(1);
			    rs.close(); 
			   
				conn.commit();
				} catch (SQLException e) {
					resulString = "";
					e.printStackTrace();
				}finally{
					try {
						
						conn.setAutoCommit(true);
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				return resulString;
			}

	  // Added by Deepshikha For Fetching Data by SQL query
	   public List<Object[]> getData(String query,ArrayList<Object> paraList) {
			//Session session = (Session) entityManager.getDelegate();
			//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
			
			Connection conn = null;
			PreparedStatement stmt = null;
			List<Object[]> datalist=new ArrayList<Object[]>();

			try {
			conn = getConnection();	
			stmt = conn.prepareStatement(query);
			if(paraList.size()>0){
		 		for(int i=0;i<paraList.size();i++){
		 			stmt.setObject(i+1, paraList.get(i));
		 		}
		 		}
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
			    int cols = rs.getMetaData().getColumnCount();
			    Object[] arr = new Object[cols];
			    for(int i=0; i<cols; i++){
			      arr[i] = rs.getObject(i+1);
			    }
			    datalist.add(arr);
			   
			}
			} catch (SQLException e) {
				e.getMessage();
			}finally{
				try {
					conn.setAutoCommit(true);
					stmt.close();
					conn.close();
				    } catch (SQLException e) {
					e.getMessage();
				    }
			  }
			return datalist;
		}
	   
	   
	
	  public void callProcedure (String fun, long ...intargs) {
	  
	  String resulString ="";
	  //Session session = (Session)entityManager.getDelegate();
	  //SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory(); 
	  Connection conn = null;
	  PreparedStatement stmt = null;
	  
	  try {
		  conn = getConnection();
		  conn.setAutoCommit(false);
		  stmt = conn.prepareStatement(fun); 
		  int i=0; //stmt.setInt(i, userid);
	  
		  for (long arg : intargs) { 
		  i++; 
		  stmt.setLong(i, arg);
	  
		  }
	  
		  stmt.execute();
		  if(resulString==null || resulString.trim() ==""){
			  resulString  = "NA"; 
			  }
		  conn.commit(); 
		  }
	  	catch (SQLException e) { 
	  			resulString  ="NotSubmmited";
	  			e.printStackTrace();
		  }
	  	finally
	  	{ 
		  try {
	  
			  conn.setAutoCommit(true);
			  stmt.close();
			  conn.close();
		  } catch (SQLException  e) {
			  e.printStackTrace(); 
		  	} 
		  }
	  
	// return resulString;
	  }
	  
	  public boolean callProcdureString(String fun, String para1) {
		  
		  String resulString ="";
		  boolean result = false;
		  //Session session = (Session)entityManager.getDelegate();
		  //SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory(); 
		  Connection conn = null;
		  PreparedStatement stmt = null;
		  
		  try {
			  conn = getConnection();
			  conn.setAutoCommit(false);
			  stmt = conn.prepareStatement(fun); 
			  int i=0; //stmt.setInt(i, userid);
			  stmt.setString(1, para1);
			  
			/*
			 * for (long arg : intargs) { i++; stmt.setLong(i, arg);
			 * 
			 * }
			 */
		  
			  stmt.execute();
			  if(resulString==null || resulString.trim() ==""){
				  resulString  = "NA"; 
				  }
			  conn.commit(); 
			  result = true;
			  }
		  	catch (SQLException e) { 
		  			resulString  ="NotSubmmited";
		  			e.printStackTrace();
			  }
		  	finally
		  	{ 
			  try {
		  
				  conn.setAutoCommit(true);
				  stmt.close();
				  conn.close();
			  } catch (SQLException  e) {
				  e.printStackTrace(); 
			  	} 
			  }
		return result;
		  
		// return resulString;
	}
	  
	  public Integer callProcdureInteger(String fun, Integer para) {
		  
		  String resulString ="";
		  Integer result = 0;
		  //Session session = (Session)entityManager.getDelegate();
		  //SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory(); 
		  Connection conn = null;
		  PreparedStatement stmt = null;
		  
		  try {
			  conn = getConnection();
			  conn.setAutoCommit(false);
			  stmt = conn.prepareStatement(fun); 
			  int i=0; //stmt.setInt(i, userid);
			  //stmt.setString(1, para1);
			  stmt.setInt(1, para);
			  
			  
			/*
			 * for (long arg : intargs) { i++; stmt.setLong(i, arg);
			 * 
			 * }
			 */
		  
			  ResultSet rs=stmt.executeQuery();  
		
			    rs.next(); 
			    resulString=rs.getObject(1).toString();
				  System.out.println("Result ==="+resulString);

			    rs.close(); 
			  if(resulString==null || resulString.trim() =="" || resulString.trim().equals("0")){
				  result  = 0; 
				  }else
				result = 1;
  
			  conn.commit(); 
			  }
		  	catch (SQLException e) { 
		  			resulString  ="NotSubmmited";
		  			e.printStackTrace();
			  }
		  	finally
		  	{ 
			  try {
		  
				  conn.setAutoCommit(true);
				  stmt.close();
				  conn.close();
			  } catch (SQLException  e) {
				  e.printStackTrace(); 
			  	} 
			  }
		return result;
		  
		// return resulString;
	}
	  
	  public boolean callProcdureWith2Param(String fun, String para1, Integer docId) {
		  String resulString ="";
		  boolean result = false;
		 // Session session = (Session)entityManager.getDelegate();
		  //SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory(); 
		  Connection conn = null;
		  PreparedStatement stmt = null;
		  
		  try {
			  conn = getConnection();
			  conn.setAutoCommit(false);
			  stmt = conn.prepareStatement(fun); 
			  int i=0; //stmt.setInt(i, userid);
			  stmt.setString(1, para1);
			  stmt.setInt(2, docId);
		  
			  stmt.execute();
			  if(resulString==null || resulString.trim() ==""){
				  resulString  = "NA"; 
				  }
			  conn.commit(); 
			  result = true;
			  }
		  	catch (SQLException e) { 
		  			resulString  ="NotSubmmited";
		  			e.printStackTrace();
			  }
		  	finally
		  	{
			  try {
				  conn.setAutoCommit(true);
				  stmt.close();
				  conn.close();
			  } catch (SQLException  e) {
				  e.printStackTrace(); 
			  	} 
		  	}
		return result;
	}
	 
	  //call function with string parameter
	  public String getListJSON(String fun, String data )
		{
			
			String resulString ="";
			//Session session = (Session) entityManager.getDelegate();
			//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();		
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("select dava."+fun+"(?)");
			stmt.setString(1,data);
			ResultSet rs = stmt.executeQuery(); 
		    rs.next(); 
		    if(rs.getObject(1)!=null)
		    resulString=rs.getObject(1).toString();
		    rs.close(); 
		   
			conn.commit();
			} catch (SQLException e) {
				resulString ="";
				e.printStackTrace();
			}finally{
				try {
					
					conn.setAutoCommit(true);
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
			return resulString;
		}
	  
	  public String procedure3Prams(String fun,Long userid, String macAdd, String PublicKey) {
			Session session = getSession();
			String resulString="";
			try {
				ProcedureCall procedureCall = session.createStoredProcedureCall(fun);
				//procedureCall.registerParameter(1, Integer.class, ParameterMode.IN);
				procedureCall.registerParameter(1, Long.class, ParameterMode.IN);
				procedureCall.registerParameter(2, String.class, ParameterMode.IN);
				procedureCall.registerParameter(3, String.class, ParameterMode.IN);
				procedureCall.getParameterRegistration(1).bindValue(userid);
				procedureCall.getParameterRegistration(1).bindValue(macAdd);
				procedureCall.getParameterRegistration(1).bindValue(PublicKey);
				procedureCall.execute();
				ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
				ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
				List results = resultSetOutput.getResultList();
				
				resulString =resultSetOutput.getSingleResult()+"";
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
				    session.close();
				} catch (Exception e) {
					e.getMessage();
				}
			}
			return resulString; 
		}
	  
		
		
		//added by harshita
		public <RegistrationDetails> RegistrationDetails merge(final Class<RegistrationDetails> entityClass, final RegistrationDetails entity) {
			if (null == entityClass)
				throw new IllegalArgumentException("entityClass can't be null");
			if (null == entity)
				throw new IllegalArgumentException("entity can't be null");

			return entityManager.merge(entity);
		}
		
		
		
		public String getTilesDataJSON(String tilesfuncName, int numInstId, Long userId) {
			
			String resulString ="";
			//Session session = (Session) entityManager.getDelegate();
			//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();		
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("select "+tilesfuncName+"(?,?)");
			stmt.setLong(1,userId);
			stmt.setInt(2,numInstId);
			ResultSet rs = stmt.executeQuery(); 
		    rs.next(); 

		    resulString=rs.getObject(1).toString();
		    rs.close(); 
		   
			conn.commit();
			} catch (SQLException e) {
				resulString ="";
				e.printStackTrace();
			}finally{
				try {
					
					conn.setAutoCommit(true);
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
			return resulString;
		}
		public List<Date> runNative(String query) {
			   Query query1 = entityManager.createNativeQuery(query);
		        return castResultList(query1.getResultList());
		}
		public Date getLastIndexTime(String indexBase) {
			String query = "SELECT dt_import FROM iveda_import_history where str_import_base = '"+indexBase+"'" ;
			List<Date> dataList = runNative(query);
			if(dataList.size()>0){
				return dataList.get(0);
			}
			return null;
		}
		 public int updateBYQuery(String query) {
		      

		     

		        Connection conn = null;
		        Statement stmt = null;
		        int i = 0;

		        try {

		            conn = getConnection();
		            conn.setAutoCommit(false);
		            stmt = conn.createStatement();
		            i = stmt.executeUpdate(query);
		        } catch (Exception e) {
		        	e.printStackTrace();
		            
		        } finally {
		            try {

		                conn.commit();
		                stmt.close();
		                conn.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }

		        return i;
		    }
		
		
		  public void callProcedure1(String func, Integer para1, Integer para2)
		  {
			StoredProcedureQuery query=  entityManager.createStoredProcedureQuery(func);
			
			query.registerStoredProcedureParameter(1, Integer.class,ParameterMode.IN );
			query.registerStoredProcedureParameter(2, Integer.class,ParameterMode.IN );
			query.registerStoredProcedureParameter(3, Integer.class,ParameterMode.OUT );
			
			query.setParameter(1, para1);
			query.setParameter(2, para2);
			query.execute();
			Integer returnedVal=(Integer) query.getOutputParameterValue(3);
			System.out.println("Returend Value:- " +returnedVal);
		  }
		  
		  public String callProcedure2(String func,Integer upId, String para1, Integer para2)
		  {
			StoredProcedureQuery query=  entityManager.createStoredProcedureQuery(func);
			
			query.registerStoredProcedureParameter(1, Integer.class,ParameterMode.IN );
			query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN );
			query.registerStoredProcedureParameter(3, Integer.class,ParameterMode.IN );
			query.registerStoredProcedureParameter(4, Integer.class,ParameterMode.OUT );
			query.registerStoredProcedureParameter(5, String.class,ParameterMode.OUT );
			
			query.setParameter(1, upId);
			query.setParameter(2, para1);
			query.setParameter(3, para2);
			
			query.execute();
			String returnedVal=(String) query.getOutputParameterValue(5);
			System.err.println("Returend Value:- " +returnedVal);
			
			
			return returnedVal;
		  }
		  
		  public String loadFunction(String fun) {
				System.out.println("in dao loadFunction "+fun);
				String resulString ="";
				//Session session = (Session) entityManager.getDelegate();
				//SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();		
				
				Connection conn = null;
				PreparedStatement stmt = null;

				try {
				conn = getConnection();
				conn.setAutoCommit(false);
			
				stmt = conn.prepareStatement("select "+fun);
				ResultSet rs = stmt.executeQuery();
				
			    rs.next(); 
			    resulString=rs.getObject(1).toString();
			    rs.close(); 
			   
				conn.commit();
				} catch (SQLException e) {
					resulString = "";
					e.printStackTrace();
				}finally{
					try {
						
						conn.setAutoCommit(true);
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				System.out.println("loadFun output data "+resulString);
				return resulString;
				
			}
}
