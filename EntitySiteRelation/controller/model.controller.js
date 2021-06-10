const ModelDAO = require('../DAO/tables/model.dao');
const StudentDAO = require('../DAO/tables/student.dao');
const db = require('../database/db');
const Student = require('../models/student');

class ModelController {

    async postModel(req, res) {
        if (req.body.act == "add") {
            //console.log(req.body.id_s + req.body.fname + req.body.lname + req.body.mname + req.body.group_name);
            
            if (!req.body.model_name) {
                console.log("Ошибка в заполнении данных! Проверьте поля.");
                return;
            } 
            await functionDao.addNewModel(req.body.model_name, req.body.student);
        }
        else if (req.body.act == "delete") {
            console.log("DELETE");
        }
        else if (req.body.act == "edit") {
            console.log("EDIT");
            console.log(req.body.student);
            //if (!req.body.id_s || !req.body.fname || !req.body.lname || !req.body.mname || !req.body.group_name) {
            //    console.log("Ошибка в заполнении данных! Проверьте поля.");
            //    return;
            //} 
        }
        const models = await ModelDAO.getAll();
        const students = await StudentDAO.getAll();
        res.render('model', {m: models, s: students});
    }

    async getSets(req, res) {
        const students = await StudentDAO.getAll();
        const models = ModelDAO.getAll();
        res.render('model', {m: models, s: students});
    }
};

module.exports = new ModelController();