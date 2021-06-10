class Relation {

    constructor(id_be, name_be, power_be, id_e_left, id_e_right, id_m) {
        this.id_be = id_be;
        this.name_be = name_be;
        this.power_be = power_be;
        this.id_e_left = id_e_left;
        this.id_e_right = id_e_right;
        this.id_m = id_m;
    }

    set IdBe() {
        this.id_be = id_be;
    }
    get IdBe() {
        return this.id_be;
    }
    set NameBe(name_be) {
        this.name_be = name_be;
    }
    get NameBe() {
        return this.name_be;
    }
    set PowerBe(power_be) {
        this.power_be = power_be;
    }
    get PowerBe() {
        return this.power_be;
    }
    set IdELeft(id_e_left) {
        this.id_e_left = id_e_left;
    }
    get IdELeft() {
        return this.id_e_left;
    }
    set IdERight(id_e_right) {
        this.id_e_right = id_e_right;
    }
    get IdERight() {
        return this.id_e_right;
    }
    set IdM(id_m) {
        this.id_m = id_m;
    }
    get IdM() {
        return this.id_m;
    }
};

module.exports = Relation;