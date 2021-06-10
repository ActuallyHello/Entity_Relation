const db = require('../../database/db');
const ViewStudent = require('../../models/view_student');

class ViewStudentDAO {

    async getAll() {
        const viewStudents = await db.query("SELECT id_s, fname, lname, mname, name_group, id_m, name_m FROM view_student_model;");

        let arr_viewStudents = [];
        for (let i = 0; i < viewStudents.rows.length; i++) {
            const {id_s, fname, lname, mname, name_group, id_m, name_m} = viewStudents.rows[i];
            let viewStudent = new ViewStudent(id_s, fname, lname, mname, name_group, id_m, name_m);
            arr_viewStudents[i] = viewStudent;          
        }
        return arr_viewStudents;
    }
};

module.exports = new ViewStudentDAO();