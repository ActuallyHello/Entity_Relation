class Entity {

    constructor(id_entity, name_entity) {
        this.id_entity = id_entity;
        this.name_entity = name_entity;
    }

    set IdEntity(id_entity) {
        this.id_entity = id_entity;
    }
    get IdEntity() {
        return this.id_entity;
    }
    set NameEntity(name_entity) {
        this.name_entity = name_entity;
    }
    get NameEntity() {
        return this.name_entity;
    }
};

module.exports = Entity;