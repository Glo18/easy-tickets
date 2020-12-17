CREATE DATABASE booking;
\c booking;
CREATE TABLE booking (id SERIAL PRIMARY KEY, name VARCHAR, number INT, destination VARCHAR, travel-class VARCHAR, food VARCHAR, tickets INT,);)
CREATE DATABASE booking_test WITH TEMPLATE booking;