const Router = require('express');
const main_router = new Router();
const MainController = require('../controller/main.controller');

const ea_router = require('../routes/ea.router');
const student_router = require('../routes/student.router');
const model_router = require('../routes/model.router');

var bodyParser = require('body-parser');
var urlencodedParser = bodyParser.urlencoded({extended: false});

//main_router.post('/', urlencodedParser, MainController.postEntityAttribute);

main_router.get('/', MainController.getSets);
main_router.get('/table', function(req, res) {
    res.render('table');
});

main_router.use('/entity_attribute', ea_router);
main_router.use('/student', student_router);
main_router.use('/model', model_router);
//main_router.use('/relation', realtion_router);

module.exports = main_router;