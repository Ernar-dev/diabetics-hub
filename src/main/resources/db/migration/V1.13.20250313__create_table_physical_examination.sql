CREATE TABLE IF NOT EXISTS physical_examination(
                                                id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                                height VARCHAR(255),
                                                weight VARCHAR(255),
                                                blood_pressure DOUBLE PRECISION,
                                                pulse_rate BIGINT,
                                                body_temperature DOUBLE PRECISION
)