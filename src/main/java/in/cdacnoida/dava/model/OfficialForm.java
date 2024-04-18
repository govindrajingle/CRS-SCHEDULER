package in.cdacnoida.dava.model;
import java.io.Serializable;
import java.util.Arrays;

public class OfficialForm implements Serializable {

	private int numProcessId;
	private String groupName;
	private int numGroupId;
	private String processName;
	private String processURL;
	private String arrProcessName[];
	private String arrProcessURL[];
	private int numformno;
	
	
	
	
	public int getNumformno() {
		return numformno;
	}
	public void setNumformno(int numformno) {
		this.numformno = numformno;
	}
	public int getNumProcessId() {
		return numProcessId;
	}
	public void setNumProcessId(int numProcessId) {
		this.numProcessId = numProcessId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getNumGroupId() {
		return numGroupId;
	}
	public void setNumGroupId(int numGroupId) {
		this.numGroupId = numGroupId;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getProcessURL() {
		return processURL;
	}
	public void setProcessURL(String processURL) {
		this.processURL = processURL;
	}
	public String[] getArrProcessName() {
		return arrProcessName;
	}
	public void setArrProcessName(String[] arrProcessName) {
		this.arrProcessName = arrProcessName;
	}
	public String[] getArrProcessURL() {
		return arrProcessURL;
	}
	public void setArrProcessURL(String[] arrProcessURL) {
		this.arrProcessURL = arrProcessURL;
	}
	@Override
	public String toString() {
		return "OfficialForm [numProcessId=" + numProcessId + ", groupName=" + groupName + ", numGroupId=" + numGroupId
				+ ", processName=" + processName + ", processURL=" + processURL + ", arrProcessName="
				+ Arrays.toString(arrProcessName) + ", arrProcessURL=" + Arrays.toString(arrProcessURL) + ", numformno="
				+ numformno + "]";
	}

}
