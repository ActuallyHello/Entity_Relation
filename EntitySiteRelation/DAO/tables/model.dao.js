const db = require('../../database/db');
const Model = require('../../models/model');

class ModelDAO {

    async getAll() {
        const models = await db.query("SELECT id_m, name_m, id_s FROM model;");

        let arr_models = [];
        for (let i = 0; i < models.rows.length; i++) {

            const {id_m, name_m, id_s} = models.rows[i];
            let model = new Model(id_m, name_m, id_s);
            arr_models[i] = model;
        }
        return arr_models;
    }

    async add(name_model, id_stud) {
        await db.query(`CALL addNewModel($1, $2)`, [name_model, id_stud]);
    }
};

module.exports = new ModelDAO();
