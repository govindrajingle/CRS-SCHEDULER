package in.cdacnoida.dava.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bis_payment_details")
public class BOOTBisPaymentDetails {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "pid")
    private String pid;

    @Column(name = "vid")
    private String vid;

    @Column(name = "tsno")
    private String tsno;

    @Column(name = "msg_before")
    private String msgBefore;

    @Column(name = "isvalid")
    private Integer isvalid;

    @Column(name = "entry_date")
    private Timestamp entryDate;

    @Column(name = "trans_date")
    private Timestamp transDate;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "status_code")
    private String statusCode;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "process_type")
    private String processType;

    @Column(name = "msg_after")
    private String msgAfter;

    @Column(name = "msg_wc")
    private String msgWc;

    @Column(name = "billdesk_trans_no")
    private String billdeskTransNo;

    @Column(name = "process_id")
    private String processId;

    @Column(name = "receipt_no")
    private String receiptNo;

    @Column(name = "str_payment_user_type")
    private String strPaymentUserType;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "other_remarks")
    private String otherRemarks;

    @Column(name = "query_api_date")
    private Timestamp queryApiDate;

    @Column(name = "gst_no")
    private String gstNo;

    @Column(name = "log_date")
    private Timestamp logDate;

    @Column(name = "refund_log_date")
    private Timestamp refundLogDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getTsno() {
		return tsno;
	}

	public void setTsno(String tsno) {
		this.tsno = tsno;
	}

	public String getMsgBefore() {
		return msgBefore;
	}

	public void setMsgBefore(String msgBefore) {
		this.msgBefore = msgBefore;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public Timestamp getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Timestamp entryDate) {
		this.entryDate = entryDate;
	}

	public Timestamp getTransDate() {
		return transDate;
	}

	public void setTransDate(Timestamp transDate) {
		this.transDate = transDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public String getMsgAfter() {
		return msgAfter;
	}

	public void setMsgAfter(String msgAfter) {
		this.msgAfter = msgAfter;
	}

	public String getMsgWc() {
		return msgWc;
	}

	public void setMsgWc(String msgWc) {
		this.msgWc = msgWc;
	}

	public String getBilldeskTransNo() {
		return billdeskTransNo;
	}

	public void setBilldeskTransNo(String billdeskTransNo) {
		this.billdeskTransNo = billdeskTransNo;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getStrPaymentUserType() {
		return strPaymentUserType;
	}

	public void setStrPaymentUserType(String strPaymentUserType) {
		this.strPaymentUserType = strPaymentUserType;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOtherRemarks() {
		return otherRemarks;
	}

	public void setOtherRemarks(String otherRemarks) {
		this.otherRemarks = otherRemarks;
	}

	public Timestamp getQueryApiDate() {
		return queryApiDate;
	}

	public void setQueryApiDate(Timestamp queryApiDate) {
		this.queryApiDate = queryApiDate;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public Timestamp getLogDate() {
		return logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

	public Timestamp getRefundLogDate() {
		return refundLogDate;
	}

	public void setRefundLogDate(Timestamp refundLogDate) {
		this.refundLogDate = refundLogDate;
	}

    
}