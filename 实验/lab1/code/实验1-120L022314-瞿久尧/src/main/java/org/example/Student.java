package org.example;

public class Student {
    private String Snum;
    private String Sname;
    private String Ssex;
    private int Sage;
    private String SClass;

    public String getSnum() {
        return Snum;
    }

    public void setSnum(String snum) {
        Snum = snum;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    public String getSClass() {
        return SClass;
    }

    public void setSClass(String SClass) {
        this.SClass = SClass;
    }
}
