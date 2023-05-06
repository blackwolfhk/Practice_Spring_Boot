# Spring Boot 3 Learning

## To develop a simple backend system with CRUD APIs

Learn link:
https://www.youtube.com/watch?v=-mwpoE0x0JQ

Note:
- Open a file named "docker-compose.yml" at the root of project;
- Always make sure the indentation is correct!! (i.e. docker-compose.yml);
- set up the docker-compose.yml and connect to docker;
- Type "docker ps" inside Terminal;
- Run "docker exec -it <YOUR_DATABASE_NAME> bash" to open a specific database (e.g. docker exec -it javapostgres bash);
- Connect database with your username "psql -U <YOUR_USERNAME>" (e.g. root@9ad6450eeefc:/# psql -U blackwolfcode);
- After created customer table, go to Terminal and use "\dt" to check with customer table;
- use "\d" to check all lists of relations;
- run "select * from customer;" to check with customer data;
- Create an interface (i.e. CustomerRepository) for CRUD handling;
- Building APIs;
- Use "\d customer" to check all the column we need in order to insert a new customer;
- Try to insert a new customer in psql with :
  INSERT INTO customer(id, name, email, age) VALUES (nextval('customer_id_sequence'), 'Tony', 'tony@gmail.com', 18);




