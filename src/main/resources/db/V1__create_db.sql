-- Create client table
CREATE TABLE IF NOT EXISTS client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);

-- Create planet table
CREATE TABLE IF NOT EXISTS planet (
    id VARCHAR(255) PRIMARY KEY,
    planet_name VARCHAR(500) NOT NULL
);

-- Create ticket table with foreign key constraints
CREATE TABLE IF NOT EXISTS ticket (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    client_id BIGINT NOT NULL,
    from_planet_id VARCHAR(255) NOT NULL,
    to_planet_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (from_planet_id) REFERENCES planet(id),
    FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);
