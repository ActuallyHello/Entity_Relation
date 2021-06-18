const db = require('../../database/db');
const ViewModelEntity = require('../../models/view_model_entity');

class ViewModelEntityDAO {

    // async getAll() {
    //     const viewModels = await db.query("SELECT id_model, model, id_relation, relation, left_entity, power_relation, right_entity FROM view_model_relation;");

    //     let arr_viewModels = [];
    //     for (let i = 0; i < viewModels.rows.length; i++) {
    //         const {id_model, model, id_relation, relation, left_entity, power_relation, right_entity} = viewModels.rows[i];
    //         let viewModel = new ViewModel(id_model, model, id_relation, relation, left_entity, power_relation, right_entity);
    //         arr_viewModels[i] = viewModel;          
    //     }
    //     return arr_viewModels;
    // }

    async getByModelEntities(id_m) {
        const viewModelEntities = await db.query(`SELECT id_m, name_e FROM view_model_entities WHERE id_m = $1;`, [id_m]);

        let arr_viewModelEntities = [];
        for (let i = 0; i < viewModelEntities.rows.length; i++) {
            const {id_m, name_e} = viewModelEntities.rows[i];
            let viewModelEntity = new ViewModelEntity(id_m, name_e);
            arr_viewModelEntities[i] = viewModelEntity;          
        }
        return arr_viewModelEntities;
    }
};

module.exports = new ViewModelEntityDAO();