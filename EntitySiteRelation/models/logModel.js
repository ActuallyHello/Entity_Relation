class LogModel {

    constructor(operation, stamp, userid, id_s, id_m, name_m) {
        this.operation = operation;
        this.stamp = stamp;
        this.userid = userid;
        this.id_s = id_s;
        this.id_m = id_m;
        this.name_m = name_m;
    }

    set Operation(operation) {
        this.operation = operation;
    }
    get Operation() {
        return this.operation;
    }
    set Stamp(stamp) {
        this.stamp = stamp;
    }
    get Stamp() {
        return this.stamp;
    }
    set UserId(userid) {
        this.userid = userid;
    }
    get UserId() {
        return this.userid;
    }
    set IdS(id_s) {
        this.id_s = id_s;
    }
    get IdS() {
        return this.id_s;
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
};

module.exports = LogModel;