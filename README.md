# Task Coopeuch

### Reference Documentation

Listado de tasks

    curl -XGET 'http://localhost:8080/api/v1/task/'

Ver un task por ID.

    curl -XGET 'http://localhost:8080/api/v1/task/2'

Crear un nuevo task

    curl -XPOST -H "Content-type: application/json" -d '{
    "description": "Una descripcion",
    "vigency": true
    }' 'http://localhost:8080/api/v1/task/'

Editar 

    curl -XPUT -H "Content-type: application/json" -d '{
    "description": "Nueva descripcion",
    "vigency": false
    }' 'http://localhost:8080/api/v1/task/2'


Borrar un task
     
    curl -XDELETE 'http://localhost:8080/api/v1/task/1'

