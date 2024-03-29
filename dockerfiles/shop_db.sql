BEGIN;

CREATE TABLE camera (camera_id SERIAL, brand VARCHAR, model VARCHAR, PRIMARY KEY(camera_id));

CREATE TABLE price (price_id SERIAL, price VARCHAR, currency VARCHAR, PRIMARY KEY(price_id));

CREATE TABLE address (address_id SERIAL, street VARCHAR, city VARCHAR, state VARCHAR, postal_code VARCHAR, country VARCHAR, PRIMARY KEY(address_id));

CREATE TABLE person (person_id SERIAL, address_id SERIAL, first_name VARCHAR, last_name VARCHAR, PRIMARY KEY(person_id), CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES address(address_id));

CREATE TABLE photo (photo_id SERIAL, price_id SERIAL, author_id VARCHAR, photo_details VARCHAR, camera_id SERIAL, resolution VARCHAR, place_of_photo VARCHAR, category VARCHAR, PRIMARY KEY(photo_id), CONSTRAINT fk_price FOREIGN KEY (price_id) REFERENCES price(price_id), CONSTRAINT fk_camera FOREIGN KEY (camera_id) REFERENCES camera(camera_id));

CREATE TABLE orders (order_id SERIAL, buyer_id SERIAL, author_id SERIAL, photo_id SERIAL, price_id SERIAL, order_method VARCHAR, PRIMARY KEY(order_id), CONSTRAINT fk_buyer FOREIGN KEY (buyer_id) REFERENCES person(person_id), CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES person(person_id), CONSTRAINT fk_price FOREIGN KEY (price_id) REFERENCES price(price_id));

CREATE TABLE orders_photo (order_id SERIAL, photo_id SERIAL, PRIMARY KEY(order_id, photo_id), CONSTRAINT orders_photo_ibfk_1 FOREIGN KEY (order_id) REFERENCES orders (order_id), CONSTRAINT orders_photo_ibfk_2 FOREIGN KEY (photo_id) REFERENCES photo (photo_id));

COMMIT;

CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;