package in.cdacnoida.dava.springsecurity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.util.UserPrinciple;

@Component
public class SessionRegistryDetails extends SessionRegistryImpl{

	
	// ~ Instance fields
	// ================================================================================================

	protected final Log logger = LogFactory.getLog(SessionRegistryImpl.class);

	/** <principal:Object,SessionIdSet> */
	private final ConcurrentMap<Object, Set<String>> principals;
	/** <sessionId:Object,SessionInformation> */
	private final Map<String, SessionInformation> sessionIds;

	private final ConcurrentMap<String, Set<String>> userPrincipal;
	
	
	public SessionRegistryDetails() {
		this.principals = new ConcurrentHashMap<>();
		this.sessionIds = new ConcurrentHashMap<>();
		this.userPrincipal=new ConcurrentHashMap<>();
	}

	
	public SessionRegistryDetails(ConcurrentMap<Object, Set<String>> principals, Map<String, SessionInformation> sessionIds,
			ConcurrentMap<String, Set<String>> userPrincipal) {
		this.principals=principals;
		this.sessionIds=sessionIds;
		this.userPrincipal=userPrincipal;
	}
	
	
	/**
	 * Obtains all the known principals in the <code>SessionRegistry</code>.
	 *
	 * @return each of the unique principals, which can then be presented to
	 * {@link #getAllSessions(Object, boolean)}.
	 */
	@Override
	public List<Object> getAllPrincipals() {
		return new ArrayList<>(userPrincipal.keySet());
	}

	
	
	public Set<String> sessionsUsedByPrincipal(UserPrinciple up){
		Set<String> sessionsUsedByPrincipal=null;
		if(userPrincipal!=null) {
			sessionsUsedByPrincipal = userPrincipal.get(up.getUsername());
		}
		return sessionsUsedByPrincipal;
	}

	
	/**
	 * Obtains all the known sessions for the specified principal. Sessions that have been
	 * destroyed are not returned. Sessions that have expired may be returned, depending
	 * on the passed argument.
	 *
	 * @param principal to locate sessions for (should never be <code>null</code>)
	 * @param includeExpiredSessions if <code>true</code>, the returned sessions will also
	 * include those that have expired for the principal
	 *
	 * @return the matching sessions for this principal (should not return null).
	 */
	@Override
	public List<SessionInformation> getAllSessions(Object principal, boolean includeExpiredSessions) {
		
		UserPrinciple up=(UserPrinciple) principal;
		final Set<String> sessionsUsedByPrincipal = sessionsUsedByPrincipal(up);

		if (sessionsUsedByPrincipal == null) {
			return Collections.emptyList();
		}

		List<SessionInformation> list = new ArrayList<>(
				sessionsUsedByPrincipal.size());

		for (String sessionId : sessionsUsedByPrincipal) {
			SessionInformation sessionInformation = getSessionInformation(sessionId);

			if (sessionInformation == null) {
				continue;
			}

			if (includeExpiredSessions || !sessionInformation.isExpired()) {
				list.add(sessionInformation);
			}
		}

		return list;
	}

	
	/**
	 * Obtains the session information for the specified <code>sessionId</code>. Even
	 * expired sessions are returned (although destroyed sessions are never returned).
	 *
	 * @param sessionId to lookup (should never be <code>null</code>)
	 *
	 * @return the session information, or <code>null</code> if not found
	 */
	@Override
	public SessionInformation getSessionInformation(String sessionId) {
		Assert.hasText(sessionId, "SessionId required as per interface contract");
		return sessionIds.get(sessionId);
	}

	public void onApplicationEvent(SessionDestroyedEvent event) {
		String sessionId = event.getId();
		removeSessionInformation(sessionId);
	}
	
	/**
	 * Updates the given <code>sessionId</code> so its last request time is equal to the
	 * present date and time. Silently returns if the given <code>sessionId</code> cannot
	 * be found or the session is marked to expire.
	 *
	 * @param sessionId for which to update the date and time of the last request (should
	 * never be <code>null</code>)
	 */
	@Override
	public void refreshLastRequest(String sessionId) {
		Assert.hasText(sessionId, "SessionId required as per interface contract");

		SessionInformation info = getSessionInformation(sessionId);

		if (info != null) {
			info.refreshLastRequest();
		}
	}

	
	/**
	 * Registers a new session for the specified principal. The newly registered session
	 * will not be marked for expiration.
	 *
	 * @param sessionId to associate with the principal (should never be <code>null</code>
	 * )
	 * @param principal to associate with the session (should never be <code>null</code>)
	 */
	@Override
	public void registerNewSession(String sessionId, Object principal) {
		Assert.hasText(sessionId, "SessionId required as per interface contract");
		Assert.notNull(principal, "Principal required as per interface contract");

		UserPrinciple up=(UserPrinciple) principal;
		RegistrationDetails registrationDetails=null;
		if(up!=null) {
			registrationDetails=up.getRegistrationDetails();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Registering session " + sessionId + ", for principal "
					+ principal);
		}

		if (getSessionInformation(sessionId) != null) {
			removeSessionInformation(sessionId);
		}

		sessionIds.put(sessionId,
				new SessionInformation(principal, sessionId, new Date()));

		Set<String> sessionsUsedByPrincipal = sessionsUsedByPrincipal(up);

		if (sessionsUsedByPrincipal == null && registrationDetails.getUserName()!=null) {
			sessionsUsedByPrincipal = new CopyOnWriteArraySet<>();
			Set<String> prevSessionsUsedByPrincipal = userPrincipal.putIfAbsent(registrationDetails.getUserName(),
					sessionsUsedByPrincipal);
			if (prevSessionsUsedByPrincipal != null) {
				sessionsUsedByPrincipal = prevSessionsUsedByPrincipal;
			}
		}

		sessionsUsedByPrincipal.add(sessionId);

		if (logger.isTraceEnabled()) {
			logger.trace("Sessions used by '" + principal + "' : "
					+ sessionsUsedByPrincipal);
		}
	}

	
	/**
	 * Deletes all the session information being maintained for the specified
	 * <code>sessionId</code>. If the <code>sessionId</code> is not found, the method
	 * gracefully returns.
	 *
	 * @param sessionId to delete information for (should never be <code>null</code>)
	 */
	@Override
	public void removeSessionInformation(String sessionId) {
		Assert.hasText(sessionId, "SessionId required as per interface contract");

		SessionInformation info = getSessionInformation(sessionId);
		

		if (info == null) {
			return;
		}

		UserPrinciple up=(UserPrinciple) info.getPrincipal();
		
		if (logger.isTraceEnabled()) {
			logger.debug("Removing session " + sessionId
					+ " from set of registered sessions");
		}

		sessionIds.remove(sessionId);

		Set<String> sessionsUsedByPrincipal = sessionsUsedByPrincipal(up);

		if (sessionsUsedByPrincipal == null) {
			return;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Removing session " + sessionId
					+ " from principal's set of registered sessions");
		}

		sessionsUsedByPrincipal.remove(sessionId);

		if (sessionsUsedByPrincipal.isEmpty()) {
			// No need to keep object in principals Map anymore
			if (logger.isDebugEnabled()) {
				logger.debug("Removing principal " + info.getPrincipal()
						+ " from registry");
			}
			userPrincipal.remove(up.getUsername());
		}

		if (logger.isTraceEnabled()) {
			logger.trace("Sessions used by '" + info.getPrincipal() + "' : "
					+ sessionsUsedByPrincipal);
		}
	}
	
	
	
}
