const v_entitiesDAO = require('../DAO/views/view_entity.dao');
const entityDAO = require('../DAO/tables/entity.dao');
const FunctionDAO = require('../DAO/function.dao');

class AttributeController {
    
    async postAttribute(req, res) {

        if (req.body.add_attribute) {
            if (req.body.add_attribute == "") console.log("CANNOT DO THIS BCS ENTITY IS NOT FILLED");
            else FunctionDAO.addAttribute(req.body.add_ea, req.body.add_attribute); 
        }
        else if (req.body.edit_attribute) {
            if (req.body.edit_attribute == '') console.log("CANNOT DO THIS BCS ENTITY IS NOT FILLED");
            else FunctionDAO.updateAttribute(req.body.edit_ea, req.body.edit_attribute, req.body.edit_e);
        }
        else if (req.body.delete_ea) {
            FunctionDAO.deleteAtrribute(req.body.delete_ea);
        }
        
        //const eattributes = await v_entitiesDAO.getAll();
        const entities = await entityDAO.getAll();
        const eattributes = await v_entitiesDAO.getAll(); 
        res.render('attribute', {e: entities, ea: eattributes});    
    }

    async getSets(req, res) {
        //const students = await v_student.getAll();
        //const entity_models
        
        //const eattributes = await v_entitiesDAO.getAll();
        const entities = await entityDAO.getAll();
        const eattributes = await v_entitiesDAO.getAll(); 
        res.render('attribute', {e: entities, ea: eattributes});
    }
}

module.exports = new AttributeController();