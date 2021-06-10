class Student {

    constructor(id_s, fname, lname, mname, group_name) {
        this.id_s = id_s;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.group_name = group_name;
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
};

module.exports = Student;