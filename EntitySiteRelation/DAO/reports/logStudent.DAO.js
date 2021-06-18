const db = require('../../database/db');
const LogStudent = require('../../models/logStudent');

class LogStudentDAO {

    async getAll() {
        const logStudents = await db.query("SELECT  operation, stamp, userid, id_s, fname, lname, mname, group_name FROM log_student;");

        let arr_logStudents = [];
        for (let i = 0; i < logStudents.rows.length; i++) {
            const {operation, stamp, userid, id_s, fname, lname, mname, group_name} = logStudents.rows[i];
            let logStudent = new LogStudent(operation, stamp, userid, id_s, fname, lname, mname, group_name);
            arr_logStudents[i] = logStudent;          
        }
        return arr_logStudents;
    }
};

module.exports = new LogStudentDAO();