CREATE TABLE IF NOT EXISTS measurement(
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        patient_id BIGINT,
                                        glucose_level DOUBLE PRECISION,
                                        weight DOUBLE PRECISION,
                                        blood_pressure VARCHAR(55),
                                        create_date TIMESTAMP
)