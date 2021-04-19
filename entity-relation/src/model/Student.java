package model;

public class Student {

    private String id_S;
    private String fname;
    private String lname;
    private String mname;
    private String name_group;

    public Student(String id_S, String fname, String lname,
                            String mname, String name_group) {
        this.id_S = id_S;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.name_group = name_group;
    }

    public String getId_S() {
        return id_S;
    }

    public void setId_S(String id_S) {
        this.id_S = id_S;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getName_group() {
        return name_group;
    }

    public void setName_group(String name_group) {
        this.name_group = name_group;
    }

}
