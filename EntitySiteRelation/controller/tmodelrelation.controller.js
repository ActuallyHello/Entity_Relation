const v_model = require('../DAO/views/view_model.dao');

class TModelRelationController {
    
    async getSets(req, res) {
        const models = await v_model.getAll();
        res.render('t_model_relation', {vm: models});
    }
}

module.exports = new TModelRelationController();