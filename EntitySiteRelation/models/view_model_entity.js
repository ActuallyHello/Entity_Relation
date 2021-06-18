class ViewModelEntity {

    constructor(id_m, name_e) {
        this.id_m = id_m;
        this.name_e = name_e;
    }

    set IdM(id_m) {
        this.id_m = id_m;
    }
    get IdM() {
        return this.id_m;
    }
    set NameE(name_e) {
        this.name_e = name_e;
    }
    get NameE() {
        return this.name_e;
    }
};

module.exports = ViewModelEntity;