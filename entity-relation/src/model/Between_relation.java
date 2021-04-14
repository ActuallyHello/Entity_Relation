package model;

public class Between_relation {

    private Long id_BE;
    private String name_BE;
    private String power_BE;

    private Long id_E_left;
    private Long id_E_right;

    public Between_relation(Long id_BE, String name_BE, String power_BE, Long id_E_left, Long id_E_right) {
        this.id_BE = id_BE;
        this.name_BE = name_BE;
        this.power_BE = power_BE;
        this.id_E_left = id_E_left;
        this.id_E_right = id_E_right;
    }

    public Long getId_BE() {
        return id_BE;
    }

    public void setId_BE(Long id_BE) {
        this.id_BE = id_BE;
    }

    public String getName_BE() {
        return name_BE;
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

    public Long getId_E_left() {
        return id_E_left;
    }

    public void setId_E_left(Long id_E_left) {
        this.id_E_left = id_E_left;
    }

    public Long getId_E_right() {
        return id_E_right;
    }

    public void setId_E_right(Long id_E_right) {
        this.id_E_right = id_E_right;
    }
}
