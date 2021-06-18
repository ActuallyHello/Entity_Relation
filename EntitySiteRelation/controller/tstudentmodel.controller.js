const v_student = require('../DAO/views/view_student.dao');

class TStudentModelController {
    
    async getSets(req, res) {
        const students = await v_student.getAll();
        res.render('t_student_model', {s: students});
    }
}

module.exports = new TStudentModelController();