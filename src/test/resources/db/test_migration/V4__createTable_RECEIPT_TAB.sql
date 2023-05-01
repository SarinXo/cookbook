CREATE TABLE IF NOT EXISTS cookbook.RECEIPT_TAB
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    short_description VARCHAR(1000),
    photo VARCHAR(250) NOT NULL,
    ingredients VARCHAR(5000) NOT NULL,
    receipt VARCHAR(10000) NOT NULL,
    rating FLOAT DEFAULT 0.0,
    editable BOOLEAN NOT NULL,
    cook_time INT,
    portions INT,

    author_id VARCHAR(50) NOT NULL,
    category_id INT,
    energy_value_id INT,

    FOREIGN KEY (author_id) REFERENCES COOKBOOK.AUTHOR_TAB(id),
    FOREIGN KEY (category_id) REFERENCES COOKBOOK.CATEGORY_TAB(id),
    FOREIGN KEY (energy_value_id) REFERENCES COOKBOOK.ENERGY_VALUE_TAB(id)

);