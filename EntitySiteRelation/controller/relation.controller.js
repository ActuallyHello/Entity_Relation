const RelationDAO = require('../DAO/views/view_model.dao'); 

class RelationController {

    async getSets(req, res) {
        const relations = await db.query();
        const models = await db.query();
        let add = false; let edit = false; let delete_r = false;
        res.render('relation', {be: relations, m: models, add: add, edit: edit, delete: delete_s});
    }

    async postRelation(req, res) {
        if (req.body.act == 'add') {
            add = true;
        }
        else if (req.body.act == 'edit') {
            edit = true;
        }
        else if (req.body.act == 'delete') {
            delete_s = true;
        }
        
        res.render('relation', {be: relations, m: models, add: add, edit: edit, delete: delete_s});
    }
};

module.exports = new RelationController();