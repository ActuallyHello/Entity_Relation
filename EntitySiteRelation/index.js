const express = require('express');
const mainRouter = require('./routes/main.router');

const PORT = process.env.PORT || 8080;

const app = express();

app.set('view engine', 'hbs');
app.use(express.static(__dirname + '/views'));

app.use('/', mainRouter);

app.listen(PORT, () => console.log(`server started on port ${PORT}`));