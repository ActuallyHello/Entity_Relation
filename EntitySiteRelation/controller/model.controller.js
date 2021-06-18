//const v_entitiesDAO = require('../DAO/views/view_entity.dao');
const studentDAO = require('../DAO/tables/student.dao');
const modelDAO = require('../DAO/tables/model.dao');
const FunctionDAO = require('../DAO/function.dao');

class ModelController {
    
    async postModel(req, res) {

        if (req.body.add_model) {
            if (req.body.add_model == "") console.log("CANNOT DO THIS BCS MODEL IS NOT FILLED");
            else FunctionDAO.addNewModel(req.body.add_model, req.body.add_stud); 
        }
        else if (req.body.edit_model) {
            if (req.body.edit_attribute == '') console.log("CANNOT DO THIS BCS ENTITY IS NOT FILLED");
            else FunctionDAO.updateModel(req.body.edit_m, req.body.edit_model, req.body.edit_stud);
        }
        else if (req.body.delete_m) {
            FunctionDAO.deleteModel(req.body.delete_m);
        }
        
        //const eattributes = await v_entitiesDAO.getAll();
        const students = await studentDAO.getAll();
        const models = await modelDAO.getAll(); 
        res.render('model', {s: students, m: models});    
    }

    async getSets(req, res) {
        //const students = await v_student.getAll();
        //const entity_models
        
        //const eattributes = await v_entitiesDAO.getAll();
        const students = await studentDAO.getAll();
        const models = await modelDAO.getAll(); 
        res.render('model', {s: students, m: models});
    }
}

module.exports = new ModelController();