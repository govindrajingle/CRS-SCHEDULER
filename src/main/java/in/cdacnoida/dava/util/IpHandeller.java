package in.cdacnoida.dava.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class IpHandeller {

	public IpHandeller() {}
	
	private Map<String,Integer> ipCheck=new HashMap<String,Integer>();

	public Map<String, Integer> getIpCheck() {
		return ipCheck;
	}

	public void setIpCheck(String ip,Integer counter) {
		this.ipCheck.put(ip, counter);
	}
}
