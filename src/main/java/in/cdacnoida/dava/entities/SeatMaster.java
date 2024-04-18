
package in.cdacnoida.dava.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.hibernate.annotations.Formula;




//@Entity
//@Table(name="seat_mst")
public class SeatMaster extends TransactionInfoDomain implements Serializable 
{
	private static final long serialVersionUID = -5022206048130491120L;

	@Id
	@Column(name="num_seat_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="seatMaster")
	@TableGenerator(name="seatMaster", initialValue=1, allocationSize=1)
	Integer numSeatId;
	
		@Column(name="str_seat_name")
		String strSeatName;
		
		@Column(name="str_seat_description")
		String strSeatDescription;
		
		@Column(name="num_inst_id")
		Integer numInstId;
		
		@Column(name="num_user_type_id")
		Integer numUserTypeId;
		
		@Column(name="num_user_id")
		Integer numUserId;
		
		@Column(name="num_role_id")
		Integer numRoleId;
		
		@Column(name="num_division_id")
		Integer numDivisionId;
		
		//@Temporal(TemporalType.DATE)
		@Column(name="dt_effect_date")
		Date dtEffectDate;
		
		@Column(name="dt_entry_date")
		Date dtEntryDate;
		
		@Column(name="num_ipaddress")
		String numIpAddress;
		
		@Column(name="num_document_id")
		Integer numDocumentId; 

		@Column(name="num_licdoc_id")
		Integer numLicdocId;
		
		@Column(name="num_idproof")
		Integer numIdproof;
		
		@Column(name="str_idproof_no")
		String strIdproofNo; 
		
		@Column(name="num_assigned_to")
		Integer numAssignedTo;

		public Integer getNumSeatId() {
			return numSeatId;
		}

		public void setNumSeatId(Integer numSeatId) {
			this.numSeatId = numSeatId;
		}

		public String getStrSeatName() {
			return strSeatName;
		}

		public void setStrSeatName(String strSeatName) {
			this.strSeatName = strSeatName;
		}

		public String getStrSeatDescription() {
			return strSeatDescription;
		}

		public void setStrSeatDescription(String strSeatDescription) {
			this.strSeatDescription = strSeatDescription;
		}

		public Integer getNumInstId() {
			return numInstId;
		}

		public void setNumInstId(Integer numInstId) {
			this.numInstId = numInstId;
		}

		public Integer getNumUserTypeId() {
			return numUserTypeId;
		}

		public void setNumUserTypeId(Integer numUserTypeId) {
			this.numUserTypeId = numUserTypeId;
		}

		public Integer getNumUserId() {
			return numUserId;
		}

		public void setNumUserId(Integer numUserId) {
			this.numUserId = numUserId;
		}

		public Integer getNumRoleId() {
			return numRoleId;
		}

		public void setNumRoleId(Integer numRoleId) {
			this.numRoleId = numRoleId;
		}

		public Integer getNumDivisionId() {
			return numDivisionId;
		}

		public void setNumDivisionId(Integer numDivisionId) {
			this.numDivisionId = numDivisionId;
		}

		public Date getDtEffectDate() {
			return dtEffectDate;
		}

		public void setDtEffectDate(Date dtEffectDate) {
			this.dtEffectDate = dtEffectDate;
		}

		public Date getDtEntryDate() {
			return dtEntryDate;
		}

		public void setDtEntryDate(Date dtEntryDate) {
			this.dtEntryDate = dtEntryDate;
		}

		public String getNumIpAddress() {
			return numIpAddress;
		}

		public void setNumIpAddress(String numIpAddress) {
			this.numIpAddress = numIpAddress;
		}

		public Integer getNumDocumentId() {
			return numDocumentId;
		}

		public void setNumDocumentId(Integer numDocumentId) {
			this.numDocumentId = numDocumentId;
		}

		public Integer getNumLicdocId() {
			return numLicdocId;
		}

		public void setNumLicdocId(Integer numLicdocId) {
			this.numLicdocId = numLicdocId;
		}

		

		public Integer getNumIdproof() {
			return numIdproof;
		}

		public void setNumIdproof(Integer numIdproof) {
			this.numIdproof = numIdproof;
		}

		public String getStrIdproofNo() {
			return strIdproofNo;
		}

		public void setStrIdproofNo(String strIdproofNo) {
			this.strIdproofNo = strIdproofNo;
		}

		public Integer getNumAssignedTo() {
			return numAssignedTo;
		}

		public void setNumAssignedTo(Integer numAssignedTo) {
			this.numAssignedTo = numAssignedTo;
		}
	
		//====Added by Manushi Mam 30-05-2019	
		@Formula("(select s.str_role_name from role_mst s where s.num_role_id= num_role_id)")
		private String roleName;

		public String getRoleName() {
			return roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
		
		

}
