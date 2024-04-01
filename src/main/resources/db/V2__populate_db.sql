
-- Insert 10 clients
INSERT INTO client (name) VALUES
('Client 1'), ('Client 2'), ('Client 3'), ('Client 4'), ('Client 5'),
('Client 6'), ('Client 7'), ('Client 8'), ('Client 9'), ('Client 10');

-- Insert 5 planets
INSERT INTO planet (id, planet_name) VALUES
('MARS', 'Mars'), ('VENUS', 'Venus'), ('EARTH', 'Earth'), ('JUPITER', 'Jupiter'), ('SATURN', 'Saturn');

-- Insert 10 tickets
-- Assumption: We randomly assign clients and planets for each ticket
INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
(NOW(), 1, 'MARS', 'EARTH'),
(NOW(), 2, 'VENUS', 'MARS'),
(NOW(), 3, 'EARTH', 'JUPITER'),
(NOW(), 4, 'JUPITER', 'SATURN'),
(NOW(), 5, 'SATURN', 'MARS'),
(NOW(), 6, 'EARTH', 'VENUS'),
(NOW(), 7, 'MARS', 'JUPITER'),
(NOW(), 8, 'JUPITER', 'VENUS'),
(NOW(), 9, 'VENUS', 'SATURN'),
(NOW(), 10, 'MARS', 'SATURN');
