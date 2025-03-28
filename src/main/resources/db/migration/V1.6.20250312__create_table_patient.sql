CREATE TABLE IF NOT EXISTS patient (
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        user_id BIGINT,
                                        first_name VARCHAR(55),
                                        middle_name VARCHAR(55),
                                        last_name VARCHAR(55),
                                        birth_date TIMESTAMP NOT NULL,
                                        gender VARCHAR(55),
                                        contact_number VARCHAR(55),
                                        create_date TIMESTAMP NOT NULL,
                                        diabetes_type VARCHAR(55)
)