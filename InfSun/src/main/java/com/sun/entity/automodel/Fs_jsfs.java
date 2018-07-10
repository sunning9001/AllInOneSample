package com.sun.entity.automodel;

public class Fs_jsfs {
    private int dm;

    private String mc;

    public int getDm() {
        return dm;
    }

    public void setDm(int dm) {
        this.dm = dm;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dm=").append(dm);
        sb.append(", mc=").append(mc);
        sb.append("]");
        return sb.toString();
    }
}