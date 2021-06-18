//const v_entitiesDAO = require('../DAO/views/view_entity.dao');
const v_relationDAO = require('../DAO/views/view_model.dao');
const entityDAO = require('../DAO/tables/entity.dao');
const modelDAO = require('../DAO/tables/model.dao');
const FunctionDAO = require('../DAO/function.dao');

class RelationController {
    
    async postRelation(req, res) {

        if (req.body.add_relation) {
            if (req.body.add_relation == "") console.log("CANNOT DO THIS BCS MODEL IS NOT FILLED");
            else FunctionDAO.addNewRelation(req.body.add_relation, req.body.add_e_left, req.body.add_power, req.body.add_e_right, req.body.add_m); 
        }
        else if (req.body.edit_be) {
            if (req.body.edit_relation == '') console.log("CANNOT DO THIS BCS ENTITY IS NOT FILLED");
            else FunctionDAO.updateRelation(req.body.edit_be, req.body.edit_relation,  req.body.edit_power, req.body.edit_e_left, req.body.edit_e_right, req.body.edit_m);
        }
        else if (req.body.delete_be) {
            FunctionDAO.deleteRelation(req.body.delete_be);
        }
        
        //const eattributes = await v_entitiesDAO.getAll();
        const relation = await v_relationDAO.getAll();
        const entities = await entityDAO.getAll();
        const models = await modelDAO.getAll(); 
        res.render('relation', {e: entities, m: models, r: relation});   
    }

    async getSets(req, res) {
        //const students = await v_student.getAll();
        //const entity_models
        
        //const eattributes = await v_entitiesDAO.getAll();
        const relation = await v_relationDAO.getAll();
        const entities = await entityDAO.getAll();
        const models = await modelDAO.getAll(); 
        res.render('relation', {e: entities, m: models, r: relation});
    }
}

module.exports = new RelationController();