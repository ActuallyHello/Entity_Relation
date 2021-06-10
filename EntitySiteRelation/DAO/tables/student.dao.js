const db = require('../../database/db');
const Student = require('../../models/student');

class StudentDAO {

    async getAll() {
        const students = await db.query("SELECT id_s, fname, lname, mname, name_group FROM student;");

        let arr_students = [];
        for (let i = 0; i < students.rows.length; i++) {

            const {id_s, fname, lname, mname, name_group} = students.rows[i];
            let student = new Student(id_s, fname, lname, mname, name_group);
            arr_students[i] = student;
        }
        return arr_students;
    }

    async add(id_s, fname, lname, mname, group_name) {
        await db.query(`CALL addNewStudent($1, $2, $3, $4, $5);`, [id_s, fname, lname, mname, group_name]);
        //await db.query(`INSERT INTO student (id_s, fname, lname, mname, name_group) VALUES ($1, $2, $3, $4, $5);`, [id_s, fname, lname, mname, group_name]);
    }
};

module.exports = new StudentDAO();
