Running as independent spring project
-----------------------------------
1. Create Person REST API
HTTP Method: POST 
Request URL: http://localhost:8089/api/v1/person/create

2. Create List<Person> REST API
HTTP Method: POST 
Request URL: http://localhost:8089/api/v1/person/save

3. Get Person by ID REST API
HTTP Method: GET 
Request URL: http://localhost:8089/api/v1/person/1

4. Get all Persons REST API
HTTP Method: GET 
Request URL: http://localhost:8089/api/v1/person/getDetails

5. Update Person REST API
HTTP Method: GET 
Request URL: http://localhost:8089/api/v1/person/update/1

6. Delete Person REST API
HTTP Method: DELETE
Request URL: http://localhost:8089/api/v1/person/delete/1

7. Swagger URL
http://localhost:8089/swagger-ui.html
______________________________________________________________________________
Running via reverseproxy
------------------------------
1. Create Person REST API
HTTP Method: POST 
Request URL: http://localhost:8085/personservice/api/v1/person/create

2. Create List<Person> REST API
HTTP Method: POST 
Request URL: http://localhost:8085/personservice/api/v1/person/save

3. Get Person by ID REST API
HTTP Method: GET 
Request URL: http://localhost:8085/personservice/api/v1/person/1

4. Get all Persons REST API
HTTP Method: GET 
Request URL: http://localhost:8085/personservice/api/v1/person/getDetails

5. Update Person REST API
HTTP Method: GET 
Request URL: http://localhost:8085/personservice/api/v1/person/update/1

6. Delete Person REST API
HTTP Method: DELETE
Request URL: http://localhost:8085/personservice/api/v1/person/delete/1
