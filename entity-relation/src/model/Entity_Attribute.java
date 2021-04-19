package model;

public class Entity_Attribute {

    private Integer id_EA;
    private String name_EA;

    private Integer id_E;

    public Entity_Attribute(Integer id_EA, String name_ea, Integer id_E) {
        this.id_E = id_E;
        this.id_EA = id_EA;
        this.name_EA = name_ea;
    }

    public Integer getId_E() {
        return id_E;
    }

    public Integer getId_EA() {
        return id_EA;
    }

    public String getName_EA() {
        return name_EA;
    }

    public void setId_E(Integer id_E) {
        this.id_E = id_E;
    }

    public void setId_EA(Integer id_EA) {
        this.id_EA = id_EA;
    }

    public void setName_EA(String name_ea) {
        this.name_EA = name_ea;
    }

}
