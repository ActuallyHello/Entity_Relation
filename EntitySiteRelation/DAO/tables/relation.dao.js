const db = require('../../database/db');
const Relation = require('../../models/relation');

class RelationDAO {

    async getAll() {
        const relations = await db.query("SELECT id_be, name_be, power_be, id_e_left, id_e_right, id_m FROM between_entity;");

        let arr_relations = [];
        for (let i = 0; i < relations.rows.length; i++) {

            const {id_be, name_be, power_be, id_e_left, id_e_right, id_m} = relations.rows[i];
            let relation = new Relation(id_be, name_be, power_be, id_e_left, id_e_right, id_m);
            arr_relations[i] = relation;
        }
        return arr_relations;
    }

    async add(id_relation, name_relation, id_left, power_relation, id_right, id_model) {
        await db.query(`CALL AddNewRelation($1, $2, $3, $4, $5, $6)`, [id_relation, name_relation, power_relation, id_left, id_right, id_model]);
        console.log("SUCCESES");
    }
};

module.exports = new RelationDAO();
