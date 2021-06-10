class ViewModel {

    constructor(id_m, name_m, id_be, name_be, e_left, power_be, e_right) {
        this.id_m = id_m;
        this.name_m = name_m;
        this.id_be = id_be;
        this.name_be = name_be;
        this.power_be = power_be;
        this.e_left = e_left;
        this.e_right = e_right;
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
    set IdBe(id_be) {
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
    set ELeft(e_left) {
        this.e_left = e_left;
    }
    get ELeft() {
        return this.e_left;
    }
    set ERight(e_right) {
        this.e_right = e_right;
    }
    get ERight() {
        return this.e_right;
    }
    set IdM(id_m) {
        this.id_m = id_m;
    }
    get IdM() {
        return this.id_m;
    }
};

module.exports = ViewModel;