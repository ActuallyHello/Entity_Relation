const db = require('../../database/db');
const ViewModel = require('../../models/view_model');

class ViewModelDAO {

    async getAll() {
        const viewModels = await db.query("SELECT id_model, model, id_relation, relation, left_entity, power_relation, right_entity FROM view_model_relation;");

        let arr_viewModels = [];
        for (let i = 0; i < viewModels.rows.length; i++) {
            const {id_model, model, id_relation, relation, left_entity, power_relation, right_entity} = viewModels.rows[i];
            let viewModel = ViewModel(id_model, model, id_relation, relation, left_entity, power_relation, right_entity);
            arr_viewModels[i] = viewModel;          
        }
        return arr_viewModels;
    }
};

module.exports = new ViewModelDAO();