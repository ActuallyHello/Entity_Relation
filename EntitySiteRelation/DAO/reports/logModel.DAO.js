const db = require('../../database/db');
const LogModel = require('../../models/logModel');

class LogModelDAO {

    async getAll() {
        const logModels = await db.query("SELECT  operation, stamp, userid, id_m, name_m, id_s FROM log_model;");

        let arr_logModel = [];
        for (let i = 0; i < logModels.rows.length; i++) {
            const {operation, stamp, userid, id_m, name_m, id_s} = logModels.rows[i];
            let logmodel = new LogModel(operation, stamp, userid, id_m, name_m, id_s);
            arr_logModel[i] = logmodel;          
        }
        return arr_logModel;
    }
};

module.exports = new LogModelDAO();