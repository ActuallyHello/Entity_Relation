const Router = require('express');
const tstudentmodel_router = new Router();

const EntityController = require('../controller/entity.controller');
const AttributeController = require('../controller/attribute.controller');
const ModelController = require('../controller/model.controller');
const RelationController = require('../controller/relation.controller');
const StudentController = require('../controller/student.controller');
const matrixController = require('../controller/matrix.controller');
const ReportController = require('../controller/report.controller');

const TableStudentController = require('../controller/tstudentmodel.controller');
const TableModelController = require('../controller/tmodelrelation.controller');
var bodyParser = require('body-parser');
var urlencodedParser = bodyParser.urlencoded({extended: false});

tstudentmodel_router.get('/entity', EntityController.getSets);

tstudentmodel_router.post('/entity', urlencodedParser, EntityController.postEntity);

tstudentmodel_router.get('/attribute', AttributeController.getSets);

tstudentmodel_router.post('/attribute', urlencodedParser, AttributeController.postAttribute);

tstudentmodel_router.get('/model', ModelController.getSets);

tstudentmodel_router.post('/model', urlencodedParser, ModelController.postModel);

tstudentmodel_router.get('/relation', RelationController.getSets);

tstudentmodel_router.post('/relation', urlencodedParser, RelationController.postRelation);

tstudentmodel_router.get('/student', StudentController.getSets);

tstudentmodel_router.post('/student', urlencodedParser, StudentController.postStudent);

tstudentmodel_router.get('/matrix', matrixController.getSets);

tstudentmodel_router.post('/matrix', urlencodedParser, matrixController.postMatrix);

tstudentmodel_router.get('/table_student', TableStudentController.getSets);

tstudentmodel_router.get('/table_model', TableModelController.getSets);

tstudentmodel_router.get('/report', ReportController.getSets);

module.exports = tstudentmodel_router;
