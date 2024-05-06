CREATE TABLE client(
    id BIGINT PRIMARY KEY,
    name VARCHAR(200) CHECK (LENGTH(name) >= 3)
);

CREATE TABLE planet(
    id VARCHAR(20) PRIMARY KEY CHECK (id ~ '^[A-Z0-9]+$'),
    name VARCHAR(500) CHECK (LENGTH(name) >= 1)
);

CREATE TABLE ticket(
    id BIGINT PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    client_id BIGINT NOT NULL,
    from_planet_id VARCHAR(20) NOT NULL,
    to_planet_id VARCHAR(20) NOT NULL
);

CREATE SEQUENCE clients_seq START 1;
CREATE SEQUENCE tickets_seq START 1;

ALTER TABLE client ALTER COLUMN id SET DEFAULT nextval('clients_seq');
ALTER TABLE ticket ALTER COLUMN id SET DEFAULT nextval('tickets_seq');

ALTER TABLE ticket
ADD CONSTRAINT client_id_fk
FOREIGN KEY(client_id) REFERENCES client(id);

ALTER TABLE ticket
ADD CONSTRAINT from_planet_id_fk
FOREIGN KEY(from_planet_id) REFERENCES planet(id);

ALTER TABLE ticket
ADD CONSTRAINT to_planet_id_fk
FOREIGN KEY(to_planet_id) REFERENCES planet(id);

SET timezone TO 'UTC';