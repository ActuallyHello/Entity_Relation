package model;

public class Model {

    private Integer id_M;
    private String name_M;

    private String id_S;

    public Model(Integer id_m, String name_m, String id_s) {
        this.id_M = id_m;
        this.name_M = name_m;
        this.id_S = id_s;
    }

    public String getId_S() {
        return id_S;
    }

    public Integer getId_M() {
        return id_M;
    }

    public String getName_M() {
        return name_M;
    }

    public void setId_S(String id_S) {
        this.id_S = id_S;
    }

    public void setId_M(Integer id_M) {
        this.id_M = id_M;
    }

    public void setName_M(String name_M) {
        this.name_M = name_M;
    }
}
