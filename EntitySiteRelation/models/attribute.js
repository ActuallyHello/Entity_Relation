class Attribute {

    constructor(id_ea, name_ea, id_e) {
        this.id_ea = id_ea;
        this.name_ea = name_ea;
        this.id_e = id_e;
    }

    set IdEa(id_ea) {
        this.id_ea = id_ea;
    }
    get IdEa() {
        return this.id_ea;
    }
    set NameEa(name_ea) {
        this.name_ea = name_ea;
    }
    get NameEa() {
        return this.name_ea = name_ea;
    }
    set IdE(id_e) {
        this.id_e = id_e
    }
    get IdE() {
        return this.id_e;
    }
};

module.exports = Attribute;