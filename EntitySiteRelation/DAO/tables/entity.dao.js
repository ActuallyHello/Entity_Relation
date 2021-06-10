const db = require('../../database/db');
const Entity = require('../../models/entity');

class EntityDAO {

    async getAll() {
        const entities = await db.query("SELECT id_e, name_e FROM entity;");

        let arr_entities = [];
        for (let i = 0; i < entities.rows.length; i++) {

            const {id_e, name_e} = entities.rows[i];
            let entity = new Entity(id_e, name_e);
            arr_entities[i] = entity;
        }
        return arr_entities;
    }

    async add(name_entity) {
        await db.query(`INSERT INTO entity (name_e) VALUES ($1))`, [name_entity]);
    } 
};

module.exports = new EntityDAO();
