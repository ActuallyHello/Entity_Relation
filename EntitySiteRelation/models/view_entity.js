class ViewEntity {

    constructor(id_e, entity, id_ea, attribute, id_m, model) {
        this.id_e = id_e;
        this.entity = entity;
        this.id_ea = id_ea;
        this.attribute = attribute;
        //this.id_m = id_m;
        //this.model = model;
    }

    // set IdM(id_m) {
    //     this.id_m = id_m;
    // }
    // get IdM() {
    //     return this.id_m;
    // }
    // set vModel(model) {
    //     this.model = model;
    // }
    // set vModel(model) {
    //     return this.model;
    // }
    set vEntity(entity) {
        this.entity = entity;
    }
    get vEntity() {
        return this.entity;
    }
    set vAttribute(attribute) {
        this.attribute = attribute;
    }
    get vAttribute() {
        return this.attribute;
    }
    set vIdE(id_e) {
        this.id_e = id_e;
    }
    get vIdE() {
        return this.id_e;
    }
    set vIdEa(id_e) {
        this.id_ea = id_ea;
    }
    get vIdEa() {
        return this.id_ea;
    }
};

module.exports = ViewEntity;