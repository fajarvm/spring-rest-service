SET @default_timestamp = UNIX_TIMESTAMP() * 1000;

INSERT INTO localhost_db.products (current_price, last_update, name) VALUES (50, @default_timestamp, 'Mouse');
INSERT INTO localhost_db.products (current_price, last_update, name) VALUES (45.50, @default_timestamp, 'Keyboard');
INSERT INTO localhost_db.products (current_price, last_update, name) VALUES (150, @default_timestamp, 'Monitor');
