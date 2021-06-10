const v_student = require('../DAO/views/view_student.dao');
const v_model = require('../DAO/views/view_model.dao');
const v_entity = require('../DAO/views/view_entity.dao');

class MainController {
    
    async getModels(req, res) {
        const models = await v_model.getAll();
        res.render('main', {m: models});

    }

    async getEntities(req, res) {
        const entities = await v_entity.getAll();
        res.render('main', {e: entities});

    }

    async getSets(req, res) {
        const students = await v_student.getAll();
        res.render('main', {s: students});
    }
}

module.exports = new MainController();