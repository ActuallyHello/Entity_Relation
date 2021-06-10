const Router = require('express');
const model_router = new Router();
const ModelController = require('../controller/model.controller');

var bodyParser = require('body-parser');
var urlencodedParser = bodyParser.urlencoded({extended: false});

model_router.post('/', urlencodedParser, ModelController.postModel);

model_router.get('/', ModelController.getSets);
//model_router.get('/', ModelController.getSets);

module.exports = model_router;