package model;

public class Entity {

    private Long id_E;
    private String name_E;

    public Entity(Long id_e, String name_e) {
        id_E = id_e;
        name_E = name_e;
    }

    public void setId_E(Long id_E) {
        this.id_E = id_E;
    }

    public void setName_E(String name_E) {
        this.name_E = name_E;
    }

    public Long getId_E() {
        return id_E;
    }

    public String getName_E() {
        return name_E;
    }
}
