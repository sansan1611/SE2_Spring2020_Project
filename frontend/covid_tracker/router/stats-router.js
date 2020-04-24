const fetch = require('node-fetch')
const router = require('express').Router();


router.get('/getDataForMap', function (request, response) {
    fetch('http://localhost:8080/stats?groupby=country&latest=true')
        .then(res => res.json())
        .then(result => response.json(result));
})

module.exports = router;