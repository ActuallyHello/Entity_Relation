const Router = require('express');
const ea_router = new Router();
const eaController = require('../controller/ea.controller');

var bodyParser = require('body-parser');
var urlencodedParser = bodyParser.urlencoded({extended: false});

ea_router.post('/', urlencodedParser, eaController.postEntityAttribute);

ea_router.get('/', eaController.GetSets);

module.exports = ea_router;