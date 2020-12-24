package laba2;

public class DataObject {
    private String lname;
    private String fname;
    private String mname;
    private String bdate;

    public DataObject() {
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return this.mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getBdate() {
        return this.bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String toString() {
        return "Person{lname='" + this.lname + '\'' + ", fname='" + this.fname + '\'' + ", mname='" + this.mname + '\'' + ", bdate='" + this.bdate + '}';
    }
}
