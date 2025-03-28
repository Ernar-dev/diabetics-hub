CREATE TABLE IF NOT EXISTS doctor_profile(
                                            id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                            user_id BIGINT,
                                            name VARCHAR(55),
                                            specialty VARCHAR(55)
)