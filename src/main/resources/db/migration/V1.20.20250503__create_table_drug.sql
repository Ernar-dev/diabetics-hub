CREATE TABLE IF NOT EXISTS drug (
                                 id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                 patient_id BIGINT,
                                 create_at TIMESTAMP,
                                 morning BOOLEAN,
                                 noon BOOLEAN,
                                 night BOOLEAN
)