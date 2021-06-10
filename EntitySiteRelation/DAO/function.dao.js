const db = require('../database/db');

class FunctionDAO {

    async addEntityAttribute(entity, attribute) {
        await db.query(`CALL add_entity_attribute($1, $2);`, [entity, attribute]);
        const check = await db.query("SELECT name_e FROM entity WHERE id_e=(SELECT MAX(id_e) FROM entity);");
        const {name_e} = check.rows[0];
        if (name_e == entity) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    }

    async addEntity(entity) {
        await db.query(`CALL addentity($1);`, [entity]);
        const check = await db.query("SELECT name_e FROM entity WHERE id_e=(SELECT MAX(id_e) FROM entity);");
        const {name_e} = check.rows[0];
        if (name_e == entity) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    }

    async addAttribute(identity, attribute) {
        await db.query(`CALL addattribute($1, $2);`, [attribute, identity]);
        const check = await db.query("SELECT name_e FROM entity WHERE id_e=(SELECT MAX(id_e) FROM entity);");
        const {name_e} = check.rows[0];
        if (name_e == entity) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    }

    async addNewModel(name_model, id_student) {
        await db.query(`CALL addnewmodel($1, $2);`, [name_model, id_student]);
        const check = await db.query("SELECT name_m FROM model WHERE id_m = (SELECT MAX(id_m) FROM model);");
        const {name_m} = check.rows[0];
        if (name_e == name_model) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    }

    async addNewStudent(id_s, f, l, m, group_name) {
        console.log(id_s+f+l+m+group_name);
        await db.query(`CALL addnewstudent($1, $2, $3, $4, $5);`, [id_s, f, l, m, group_name]);
        const check = await db.query("SELECT lname FROM student WHERE id_s = (SELECT MAX(id_s) FROM student);");
        const {lname} = check.rows[0];
        if (lname == l) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    }

    async addNewRelation(relation, left_id, power_be, right_id, id_m) {
        await db.query(`CALL addnewrelation($1, $2, $3, $4, $5)`, [relation, left_id, power_be, right_id, id_m]);
        const check = await db.query("SELECT id_e_left, id_e_right FROM between_entity WHERE id_be = (SELECT MAX(id_be) FROM between_entity);");
        const {id_e_left, id_e_right} = check.rows[0];
        if ((id_e_left == left_id) && (id_e_right == right_id)) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    }

    async updateEntity(id_entity, new_name_entity) {
        await db.query(`CALL updateentity($1, $2)`, [id_entity, new_name_entity]);
        const check = await db.query(`SELECT name_e FROM entity WHERE id_e = $1;`, [id_entity]);
        const {name_e} = check.rows[0];
        if (name_e == new_name_entity) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    }

    async updateAttribute(id_attribute, new_name_attribute, id_entity) {
        await db.query(`CALL updateattribute($1, $2, $3)`, [id_attribute, new_name_attribute, id_entity]);
        const check = await db.query(`SELECT name_ea FROM entity_attribute WHERE id_ea = $1;`, [id_attribute]);
        const {name_ea} = check.rows[0];
        if (name_ea == new_name_attribute) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    }

    async updateStudent(id_stud, fname, lname, mname, group_name) {
        await db.query(`CALL updatestudent($1, $2, $3, $4, $5)`, [id_stud, fname, lname, mname, group_name]);
        const check = await db.query(`SELECT id_s, name_group FROM student WHERE id_s = $1;`, [id_stud]);
        const {id_s, name_group} = check.rows[0];
        if (id_s == id_stud && name_group == group_name) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    
    }

    async updateModel(id_model, name_model, id_stud) {
        await db.query(`CALL updatemodel($1, $2, $3)`, [id_model, name_model, id_stud]);
        const check = await db.query(`SELECT name_m FROM model WHERE id_m = $1;`, [id_model]);
        const {name_m} = check.rows[0];
        if (name_m == name_model) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    
    }

    async updateRelation(id_relation, name_relation, power_relation, id_left, id_right, id_model) {
        await db.query(`CALL updaterelation($1, $2, $3, $4, $5, $6);`, [id_relation, name_relation, power_relation, id_left, id_right, id_model]);
        const check = await db.query(`SELECT name_be FROM between_entity WHERE id_be = %1;`, [id_realtion]);
        const {name_be} = check.rows[0];
        if (name_relation == name_be) console.log("Добавление прошло успешно");
        else console.log("Ошибка при добавлении");
    }

    async deleteEntity(id_entity) {
        await db.query(`CALL deleteentity($1)`, [id_entity]);
    }

    async deleteAtrribute(id_attribute) {
        await db.query(`CALL deleteattribute($1)`, [id_attribute]);
    }

    
    async deleteStudent(id_student) {
        await db.query(`CALL deletestudent($1)`, [id_student]);
    }

    
    async deleteModel(id_model) {
        await db.query(`CALL deletemodel($1)`, [id_model]);
    }

    
    async deleteRelation(id_relation) {
        await db.query(`CALL deleterelation($1)`, [id_relation]);
    }
};

module.exports = new FunctionDAO();