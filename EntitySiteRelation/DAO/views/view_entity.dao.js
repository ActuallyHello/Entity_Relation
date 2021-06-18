const db = require('../../database/db');
const ViewEntity = require('../../models/view_entity');

class ViewEntityDAO {

    async getAll() {
        const viewEntities = await db.query("SELECT id_e, name_e, id_ea, name_ea FROM view_entity;");
        let arr_viewEntites = [];
        //console.log(a.entity);
        //if (!viewEntities[0]) return arr_viewEntites;

        for (let i = 0; i < viewEntities.rows.length; i++) {
            //console.log(viewEntities.rows[i]);
            const {id_e, name_e, id_ea, name_ea} = viewEntities.rows[i];
            //console.log(id_e + " " + name_e + " " + id_ea + " " + name_ea);
            let v_entity = new ViewEntity(id_e, name_e, id_ea, name_ea);
            arr_viewEntites[i] = v_entity;          
        }
        return arr_viewEntites;
    }
};

module.exports = new ViewEntityDAO();