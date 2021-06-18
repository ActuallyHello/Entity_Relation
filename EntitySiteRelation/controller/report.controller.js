const v_model = require('../DAO/views/view_model.dao');
const logStudentDAO = require('../DAO/reports/logStudent.DAO');
const logModelDAO = require('../DAO/reports/logModel.DAO');

class ReportController {
    
    async getSets(req, res) {
        const models = await logModelDAO.getAll();
        const students = await logStudentDAO.getAll();
        res.render('report', {s: students, m: models});
    }
}

module.exports = new ReportController();