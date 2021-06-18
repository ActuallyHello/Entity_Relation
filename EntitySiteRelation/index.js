const express = require('express');
const tstudentmodel_router = require('./routes/tstudentmodel.router');

const PORT = process.env.PORT || 8080;

const app = express();

app.set('view engine', 'hbs');
app.set("view options", {layout: "layout"});
app.use(express.static(__dirname + '/views')); //отдельная  папка для css image

app.use('/', tstudentmodel_router);

app.listen(PORT, () => console.log(`server started on port ${PORT}`));