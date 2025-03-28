CREATE TABLE IF NOT EXISTS laboratory_tests(
                                            id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                            fasting_glucose DOUBLE PRECISION,
                                            hbA1c DOUBLE PRECISION,
                                            lipid_profile_id BIGINT,
                                            creatinine BIGINT,
                                            albuminuria BIGINT
)