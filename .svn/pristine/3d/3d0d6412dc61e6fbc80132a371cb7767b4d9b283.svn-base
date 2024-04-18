package in.cdacnoida.dava.springsecurity;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class LoginAttemptService {

	
	//This details are used to block the user on login failure based on username
	//(if login attempts are 4 then in actual it is considering 2 because of some bug so make sure that when you put login attempts it should be double than actual attempt that you want)
	
	 private final int MAX_ATTEMPT = 4;
	 private LoadingCache<String, Integer> attemptsCache;
	 
	 public LoginAttemptService() {
	        super();
	        attemptsCache = CacheBuilder.newBuilder().
	          expireAfterWrite(5, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
	            public Integer load(String key) {
	                return 0;
	            }
	       });
	  }
	 
	 public void loginSucceeded(String key) {
		 attemptsCache.invalidate(key);
	 }
	 
	 public void loginFailed(String key) {
	        int attempts = 0;
	        try {
	            attempts = attemptsCache.get(key);
	        } catch (ExecutionException e) {
	            attempts = 0;
	        }
	        attempts++;
	        attemptsCache.put(key, attempts);
	   }
	 
	   public boolean isBlocked(String key) {
	      try {
	    	  //System.out.println("userName="+key+" having attempt="+attemptsCache.get(key));
	          return attemptsCache.get(key) >= MAX_ATTEMPT;
	      } catch (ExecutionException e) {
	          return false;
	       }
	   }
}
