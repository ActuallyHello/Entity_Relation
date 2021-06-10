const functionDao = require('../DAO/function.dao');
const StudentDAO = require('../DAO/tables/student.dao');

class StudentController {

    async postStudent(req, res) {
        let add = false; let edit = false; let delete_s = false;
        if (req.body.act == "add") {
            add = true;
            console.log(req.body.student + add + edit + delete_s);
        }
        else if (req.body.act == "delete") {
            edit = true;
            console.log(req.body.student + add + edit + delete_s);
        }
        else if (req.body.act == "edit") {
            delete_s = true;
            console.log(req.body.student + add + edit + delete_s);
        }
        const students = await StudentDAO.getAll();
        res.render('student', {s: students, add: add, edit: edit, delete: delete_s});
    }

    async getSets(req, res) {
        const students = await StudentDAO.getAll();
        let add = false; let edit = false; let delete_s = false;
        res.render('student', {add: add, edit: edit, delete: delete_s});
    }
};

module.exports = new StudentController();