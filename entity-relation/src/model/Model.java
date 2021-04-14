package model;

public class Model {

    private Long id_M;
    private String name_M;

    private Long id_BE;

    public Model(Long id_m, String name_m, Long id_be) {
        id_M = id_m;
        name_M = name_m;
        id_BE = id_be;
    }

    public Long getId_BE() {
        return id_BE;
    }

    public Long getId_M() {
        return id_M;
    }

    public String getName_M() {
        return name_M;
    }

    public void setId_BE(Long id_BE) {
        this.id_BE = id_BE;
    }

    public void setId_M(Long id_M) {
        this.id_M = id_M;
    }

    public void setName_M(String name_M) {
        this.name_M = name_M;
    }
}
