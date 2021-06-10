const Router = require('express');
const student_router = new Router();
const StudentController = require('../controller/student.controller');

var bodyParser = require('body-parser');
var urlencodedParser = bodyParser.urlencoded({extended: false});

student_router.post('/', urlencodedParser, StudentController.postStudent);

student_router.get('/', StudentController.getSets);

module.exports = student_router;