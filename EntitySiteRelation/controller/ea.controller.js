const FunctioDAO = require('../DAO/function.dao');

const EntityDAO = require('../DAO/tables/entity.dao');
const AttributeDAO = require('../DAO/tables/attribute.dao');

class EAController {
    
    async postEntityAttribute(req, res) {
        
        //if (req.body.act == 'add') await FunctioDAO.addEntityAttribute(req.body.entity, req.body.attribute);
        //res.send(req.body.act + " " + req.body.model + " " + req.body.student + " " + req.body.entity);
        
        let add_e = false; let add_ea = false; let edit_e = false;
        let edit_ea = false; let delete_e = false; let delete_ea = false;
        let e = null; let ea = null; 
        
        if (req.body.act == 'add_entity') {
            add_e = true;
            if (!req.body.entity) console.log('Заполните поля!');
            else console.log('ADDDDDD');
            //else await FunctioDAO.addEntity(req.body.entity);
        }
        if (req.body.act == 'add_attribute') {
            add_ea = true;
            const ent = await EntityDAO.getAll();
            e = ent;
            if (!req.body.attribute) console.log('НЕТ ДАННЫХ!');
            else console.log("NE ADDDD");
            //else await FunctioDAO.addAttribute(req.body.select_e, req.body.attribute);
        }
        if (req.body.act == 'edit_entity') {
            edit_e = true;
            if (!req.body.entity) console.log("Ni4ego net");
            else console.log("EDIT");           
        }
        if (req.body.act == 'edit_attribute'){
            edit_ea = true;
            if (!req.body.attribute) console.log("ni4ego net tyt");
            else console.log("NE EDIT");
        } 
        if (req.body.act == 'delete_entity') {
            delete_e = true;
            console.log("ALOOOOO");
        } 
        if (req.body.act == 'delete_attribute') {
            delete_ea = true;
            console.log("NE ALOOOO");
        }
        res.render("entity_attribute", {jopa: jopa, add_e: add_e, add_ea: add_ea, edit_e: edit_e, edit_ea: edit_ea, delete_e: delete_e, delete_ea: delete_ea});
    }

    async GetSets(req, res) {
        let entities = await EntityDAO.getAll();
        let add_e = false; let add_ea = false; let edit_e = false; let jopa = false;
        let edit_ea = false; let delete_e = false; let delete_ea = false;
        
        res.render('entity_attribute', {jopa: jopa, add_e: add_e, add_ea: add_ea, edit_e: edit_e, edit_ea: edit_ea, delete_e: delete_e, delete_ea: delete_ea, e: null, ea: null});
        //const students = await StudentDAO.getAll();
        //res.send(req.body.act + " " + req.body.model + " " + req.body.students + " " + req.body.entity);
        //const ModelDAO = await ModelDAO.getAll();
        //const EntityDAO = await EntityDAO.getAll();
    }
}

module.exports = new EAController();