DROP TABLE IF EXISTS products;

CREATE TABLE products (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              name VARCHAR(250) NOT NULL,
                              description VARCHAR(250) NOT NULL,
                              category VARCHAR(250) NOT NULL
);

INSERT INTO products (name, description, category) VALUES
('Bed Sheets', 'Its a bedsheet', 'Bedroom'),
('Dresser', 'Put stuff in it', 'Bedroom');