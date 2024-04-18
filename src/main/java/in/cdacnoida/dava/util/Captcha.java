package in.cdacnoida.dava.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Captcha {

	public String getCaptcha() {
//		int width = 150;
//		int height = 50;
		List<Character> arrayList = new ArrayList<Character>();
		String capcode = "abcdefghijkmnopqurstuvwxyzABCDEFGHJKMONOPQURSTUVWXYZ0123456789@";
		for (int i = 1; i < capcode.length() - 1; i++) {
			arrayList.add(capcode.charAt(i));
		}
		Collections.shuffle(arrayList);
		Iterator itr = arrayList.iterator();
		String s = "";
		String s2 = "";
		Object obj;
		while (itr.hasNext()) {
			obj = itr.next();
			s = obj.toString();
			s2 = s2 + s;
		}
		String s1 = s2.substring(0, 6);
		char[] s3 = s1.toCharArray();
		// Random r = new Random();
		// int index = Math.abs(r.nextInt()) % 5;
		// System.out.println(index);
		String captcha = String.copyValueOf(s3);
		//System.out.println(LocalDateTime.now() + "  Home page reloaded with captcha --- " + captcha);
		return captcha;
	}
}
