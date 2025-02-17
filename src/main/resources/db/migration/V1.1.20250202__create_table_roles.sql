CREATE TABLE IF NOT EXISTS roles (
                                     id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS user_roles (
                                          user_id BIGINT,
                                          role_id BIGINT,
                                          FOREIGN KEY (user_id) REFERENCES users (id),
                                          FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO roles(name) VALUES ('ADMIN'), ('PATIENT'), ('DOCTOR'), ('SCIENTIST');