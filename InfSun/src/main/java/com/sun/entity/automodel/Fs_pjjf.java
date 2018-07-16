package com.sun.entity.automodel;

import java.util.Date;

public class Fs_pjjf {
    private String billno;

    private Date payDatetime;

    private String payAmount;

    private String bkOutlet;

    private String operator;

    private String paymode;

    private String tradeNo;

    private String payerName;

    private String recAcctype;

    private String payerAcct;

    private String payerOpbk;

    private String payerOpbkno;

    private String recAcct;

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public Date getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(Date payDatetime) {
        this.payDatetime = payDatetime;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getBkOutlet() {
        return bkOutlet;
    }

    public void setBkOutlet(String bkOutlet) {
        this.bkOutlet = bkOutlet;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getRecAcctype() {
        return recAcctype;
    }

    public void setRecAcctype(String recAcctype) {
        this.recAcctype = recAcctype;
    }

    public String getPayerAcct() {
        return payerAcct;
    }

    public void setPayerAcct(String payerAcct) {
        this.payerAcct = payerAcct;
    }

    public String getPayerOpbk() {
        return payerOpbk;
    }

    public void setPayerOpbk(String payerOpbk) {
        this.payerOpbk = payerOpbk;
    }

    public String getPayerOpbkno() {
        return payerOpbkno;
    }

    public void setPayerOpbkno(String payerOpbkno) {
        this.payerOpbkno = payerOpbkno;
    }

    public String getRecAcct() {
        return recAcct;
    }

    public void setRecAcct(String recAcct) {
        this.recAcct = recAcct;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", billno=").append(billno);
        sb.append(", payDatetime=").append(payDatetime);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", bkOutlet=").append(bkOutlet);
        sb.append(", operator=").append(operator);
        sb.append(", paymode=").append(paymode);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", payerName=").append(payerName);
        sb.append(", recAcctype=").append(recAcctype);
        sb.append(", payerAcct=").append(payerAcct);
        sb.append(", payerOpbk=").append(payerOpbk);
        sb.append(", payerOpbkno=").append(payerOpbkno);
        sb.append(", recAcct=").append(recAcct);
        sb.append("]");
        return sb.toString();
    }
}