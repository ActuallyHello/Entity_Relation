const db = require('../../database/db');
const Attribute = require('../../models/attribute');

class AttributeDAO {

    async getAll() {
        const attributes = await db.query("SELECT id_ea, name_ea, id_e FROM entity_attribute;");

        let arr_attributes = [];
        for (let i = 0; i < attributes.rows.length; i++) {

            const {id_ea, name_ea, id_e} = attributes.rows[i];
            let attribute = new Attribute(id_ea, name_ea, id_e);
            arr_attributes[i] = attribute;
        }
        return arr_attributes;
    }

    async addAttribute(id_entity, name_attribute) {
        await db.query(`INSERT INTO entity_attribute (name_ea, id_e) VALUES ($1, $2)`, [name_attribute, id_entity]);
    }
};

module.exports = new AttributeDAO();
