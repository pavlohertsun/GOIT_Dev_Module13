
INSERT INTO Client (name)
VALUES
    ('John'),
    ('Emily'),
    ('Helen'),
    ('Paul'),
    ('Andrew'),
    ('James'),
    ('Robert'),
    ('Michael'),
    ('David'),
    ('William');

INSERT INTO Planet (id, name)
VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('MER', 'Mercury'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id)
VALUES
    (1, 'MARS', 'VEN'),
    (2, 'MER', 'JUP'),
    (3, 'VEN', 'MARS'),
    (4, 'SAT', 'MARS'),
    (5, 'MARS', 'JUP'),
    (6, 'MER', 'SAT'),
    (7, 'JUP', 'MER'),
    (8, 'MARS', 'VEN'),
    (9, 'MARS', 'VEN'),
    (10, 'MARS', 'JUP');
