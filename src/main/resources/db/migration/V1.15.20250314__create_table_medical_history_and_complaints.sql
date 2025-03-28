CREATE TABLE IF NOT EXISTS medical_history_and_complaints(
                                                            id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                                            patient_id BIGINT,
                                                            created_at TIMESTAMP,
                                                            main_complaints VARCHAR(255),
                                                            comorbidities VARCHAR(255),
                                                            allergies VARCHAR(255),
                                                            physical_examination_id BIGINT,
                                                            laboratory_tests_id BIGINT,
                                                            prescription_id BIGINT,
                                                            next_visit_planning_id BIGINT
)