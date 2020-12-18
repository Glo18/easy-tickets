CREATE DATABASE passenger;
\c passenger;
CREATE TABLE passenger (id SERIAL PRIMARY KEY, name VARCHAR, origin VARCHAR, destination VARCHAR);
CREATE DATABASE passenger_test WITH TEMPLATE passenger;