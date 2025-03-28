CREATE TABLE IF NOT EXISTS prescription(
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        doctor_id BIGINT,
                                        patient_id BIGINT,
                                        medicine VARCHAR(255),
                                        dosage VARCHAR(255),
                                        created_at TIMESTAMP
)