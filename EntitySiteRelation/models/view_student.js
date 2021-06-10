class ViewStundet {

    constructor(id_s, fname, lname, mname, group_name, id_m, name_m) {
        this.id_s = id_s;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.group_name = group_name;
        this.id_m = id_m;
        this.name_m = name_m;
    }

    set IdS(id_s) {
        this.id_s = id_s;
    }
    get IdS() {
        return this.id_s;
    }
    set fName(fname) {
        this.fname = fname;
    }
    get fName() {
        return this.fname;
    }
    set lName(lname) {
        this.lname = lname;
    }
    get lName() {
        return this.lname;
    }
    set mName(mname) {
        this.mname = mname;
    }
    get mName() {
        return this.mname;
    }
    set GroupName(group_name) {
        this.group_name = group_name;
    }
    get GroupName() {
        return this.group_name;
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

module.exports = ViewStundet;