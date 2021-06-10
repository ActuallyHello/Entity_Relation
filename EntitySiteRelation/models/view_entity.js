class ViewEntity {

    constructor(id_e, entity, id_ea, attribute) {
        this.id_e = id_e;
        this.entity = entity;
        this.id_ea = id_ea;
        this.attribute = attribute;
    }

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