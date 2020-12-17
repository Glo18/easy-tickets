CREATE DATABASE bookings;
\c bookings;
CREATE TABLE bookings (id SERIAL PRIMARY KEY, name VARCHAR, number INT, destination VARCHAR, travelClass VARCHAR, food VARCHAR, tickets INT);
CREATE DATABASE bookings_test WITH TEMPLATE bookings;