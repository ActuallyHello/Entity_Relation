const studentDAO = require('../DAO/tables/student.dao');
const FunctionDAO = require('../DAO/function.dao');

class StudentController {
    
    async postStudent(req, res) {

        if (req.body.add_s) {
            if (req.body.add_s == "" || req.body.add_l == "" || req.body.add_f == "" || req.body.add_m == "" || req.body.add_g == "") console.log("CANNOT DO THIS BCS MODEL IS NOT FILLED");
            else FunctionDAO.addNewStudent(req.body.add_s, req.body.add_f, req.body.add_l, req.body.add_m, req.body.add_g); 
        }
        else if (req.body.edit_l) {
            if (req.body.add_s == "" || req.body.add_l == "" || req.body.add_f == "" || req.body.add_m == "" || req.body.add_g == "") console.log("CANNOT DO THIS BCS ENTITY IS NOT FILLED");
            else FunctionDAO.updateStudent(req.body.edit_old_s, req.body.edit_f, req.body.edit_l, req.body.edit_m, req.body.edit_g); 
        }
        else if (req.body.delete_s) {
            FunctionDAO.deleteStudent(req.body.delete_s);
        }
        
        //const eattributes = await v_entitiesDAO.getAll();
        const students = await studentDAO.getAll(); 
        res.render('student', {s: students});   
    }

    async getSets(req, res) {
        //const students = await v_student.getAll();
        //const entity_models
        
        //const eattributes = await v_entitiesDAO.getAll();
        const students = await studentDAO.getAll(); 
        res.render('student', {s: students});
    }
}

module.exports = new StudentController();