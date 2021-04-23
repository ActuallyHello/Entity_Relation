package model;

public class TableOutput {

    private String record_book;
    private String FIO;
    private String model_name;
    private String left_entity;
    private String right_entity;
    private String power_left_right;
    private String name_group;
    private String relation_name;
    private String attribute;
    private String entity;

    public TableOutput() {
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getRecord_book() {
        return record_book;
    }

    public void setRecord_book(String record_book) {
        this.record_book = record_book;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getLeft_entity() {
        return left_entity;
    }

    public void setLeft_entity(String left_entity) {
        this.left_entity = left_entity;
    }

    public String getRight_entity() {
        return right_entity;
    }

    public void setRight_entity(String right_entity) {
        this.right_entity = right_entity;
    }

    public String getPower_left_right() {
        return power_left_right;
    }

    public void setPower_left_right(String power_left_right) {
        this.power_left_right = power_left_right;
    }

    public String getName_group() {
        return name_group;
    }

    public void setName_group(String name_group) {
        this.name_group = name_group;
    }

    public String getRelation_name() {
        return relation_name;
    }

    public void setRelation_name(String relation_name) {
        this.relation_name = relation_name;
    }
}
