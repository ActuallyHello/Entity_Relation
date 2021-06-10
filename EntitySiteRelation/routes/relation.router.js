const Router = require('express');
const relation_router = new Router();
const RelationController = require('../controller/main.controller');

var bodyParser = require('body-parser');
var urlencodedParser = bodyParser.urlencoded({extended: false});

//relation_router.post('/', urlencodedParser, MainController.postEntityAttribute);

relation_router.get('/', function(req, res) {
    res.render('main');
});

module.exports = relation_router;