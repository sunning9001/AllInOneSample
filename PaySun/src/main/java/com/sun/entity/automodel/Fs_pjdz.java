package com.sun.entity.automodel;

public class Fs_pjdz {
    private String date;

    private String accconfirmNo;

    private String recAcctype;

    private String recAcct;

    private String count;

    private String paymode;

    private String recSubacct;

    private String tradeNo;

    private String billno;

    private String batchno;

    private String amount;

    private String addword;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccconfirmNo() {
        return accconfirmNo;
    }

    public void setAccconfirmNo(String accconfirmNo) {
        this.accconfirmNo = accconfirmNo;
    }

    public String getRecAcctype() {
        return recAcctype;
    }

    public void setRecAcctype(String recAcctype) {
        this.recAcctype = recAcctype == null ? null : recAcctype.trim();
    }

    public String getRecAcct() {
        return recAcct;
    }

    public void setRecAcct(String recAcct) {
        this.recAcct = recAcct;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getRecSubacct() {
        return recSubacct;
    }

    public void setRecSubacct(String recSubacct) {
        this.recSubacct = recSubacct;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAddword() {
        return addword;
    }

    public void setAddword(String addword) {
        this.addword = addword;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", date=").append(date);
        sb.append(", accconfirmNo=").append(accconfirmNo);
        sb.append(", recAcctype=").append(recAcctype);
        sb.append(", recAcct=").append(recAcct);
        sb.append(", count=").append(count);
        sb.append(", paymode=").append(paymode);
        sb.append(", recSubacct=").append(recSubacct);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", billno=").append(billno);
        sb.append(", batchno=").append(batchno);
        sb.append(", amount=").append(amount);
        sb.append(", addword=").append(addword);
        sb.append("]");
        return sb.toString();
    }
}