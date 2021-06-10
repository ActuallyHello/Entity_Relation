const db = require('../../database/db');
const ViewEntity = require('../../models/view_entity');

class ViewEntityDAO {

    async getAll() {
        const viewEntities = await db.query("SELECT id_e, name_e, id_ea, name_ea FROM view_entity_attribute;");
        let arr_viewEntites = [];
        if (!viewEntities[0]) return arr_viewEntites;

        for (let i = 0; i < viewEntities.rows.length; i++) {
            const {id_e, name_e, id_ea, name_ea} = viewEntities.rows[i];
            let viewEntity = ViewEntity(id_e, name_e, id_ea, name_ea);
            arr_viewEntites[i] = viewEntity;          
        }
        return arr_viewEntites;
    }
};

module.exports = new ViewEntityDAO();