package model;

public class Between_relation {

    private Integer id_BE;
    private String name_BE;
    private String power_BE;

    private Integer id_E_left;
    private Integer id_E_right;
    private Integer id_M;

    public Between_relation(Integer id_BE, String name_BE, String power_BE, Integer id_E_left, Integer id_E_right, Integer id_m) {
        this.id_BE = id_BE;
        this.name_BE = name_BE;
        this.power_BE = power_BE;
        this.id_E_left = id_E_left;
        this.id_E_right = id_E_right;
        this.id_M = id_m;
    }

    public Integer getId_BE() {
        return id_BE;
    }

    public void setId_BE(Integer id_BE) {
        this.id_BE = id_BE;
    }

    public String getName_BE() {
        return name_BE;
    }

    public Integer getId_M() {
        return id_M;
    }

    public void setId_M(Integer id_M) {
        this.id_M = id_M;
    }

    public void setName_BE(String name_BE) {
        this.name_BE = name_BE;
    }

    public String getPower_BE() {
        return power_BE;
    }

    public void setPower_BE(String power_BE) {
        this.power_BE = power_BE;
    }

    public Integer getId_E_left() {
        return id_E_left;
    }

    public void setId_E_left(Integer id_E_left) {
        this.id_E_left = id_E_left;
    }

    public Integer getId_E_right() {
        return id_E_right;
    }

    public void setId_E_right(Integer id_E_right) {
        this.id_E_right = id_E_right;
    }
}
