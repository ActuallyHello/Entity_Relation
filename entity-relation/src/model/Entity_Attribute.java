package model;

public class Entity_Attribute {
    private Long id_EA;
    private String name_EA;

    private Long id_E;

    public Entity_Attribute(Long id_EA, String name_ea, Long id_E) {
        this.id_E = id_E;
        this.id_EA = id_EA;
        this.name_EA = name_ea;
    }

    public Long getId_E() {
        return id_E;
    }

    public Long getId_EA() {
        return id_EA;
    }

    public String getName_EA() {
        return name_EA;
    }

    public void setId_E(Long id_E) {
        this.id_E = id_E;
    }

    public void setId_EA(Long id_EA) {
        this.id_EA = id_EA;
    }

    public void setName_EA(String name_ea) {
        this.name_EA = name_ea;
    }

}
