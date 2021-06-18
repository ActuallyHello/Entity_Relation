const v_entitiesDAO = require('../DAO/views/view_entity.dao');
const entityDAO = require('../DAO/tables/entity.dao');
const FunctionDAO = require('../DAO/function.dao');

class EntityController {
    
    async postEntity(req, res) {

        if (req.body.add_entity) {
            if (req.body.add_entity == "") console.log("CANNOT DO THIS BCS ENTITY IS NOT FILLED");
            else FunctionDAO.addEntity(req.body.add_entity); 
        }
        else if (req.body.edit_entity) {
            if (req.body.edit_entity == '') console.log("CANNOT DO THIS BCS ENTITY IS NOT FILLED");
            else FunctionDAO.updateEntity(req.body.edit_e, req.body.edit_entity);
        }
        else if (req.body.delete_e) {
            FunctionDAO.deleteEntity(req.body.delete_e);
        }
        
        //const eattributes = await v_entitiesDAO.getAll();
        const entities = await entityDAO.getAll();
        res.render('entity', {e: entities});    
    }

    async getSets(req, res) {
        //const students = await v_student.getAll();
        //const entity_models
        
        //const eattributes = await v_entitiesDAO.getAll();
        const entities = await entityDAO.getAll();
        res.render('entity', {e: entities});
    }
}

module.exports = new EntityController();