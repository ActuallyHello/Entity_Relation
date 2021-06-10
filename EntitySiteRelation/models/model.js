class Model {

    constructor(id_m, name_m, id_s) {
        this.id_m = id_m;
        this.name_m = name_m;
        this.id_s = id_s;
    }

    set IdM(id_m) {
        this.id_m = id_m;
    }
    get IdM() {
        return this.id_m;
    }
    set NameM(name_m) {
        this.name_m = name_m;
    }
    get NameM() {
        return this.name_m;
    }
    set IdS(id_s) {
        this.id_s = id_s;
    }
    get IdS() {
        return this.id_s;
    }
};

module.exports = Model;