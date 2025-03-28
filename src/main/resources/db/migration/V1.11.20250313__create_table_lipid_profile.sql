CREATE TABLE IF NOT EXISTS lipid_profile(
                                            id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                            total_cholesterol DOUBLE PRECISION,
                                            ldl_cholesterol DOUBLE PRECISION,
                                            hdl_cholesterol DOUBLE PRECISION,
                                            triglycerides DOUBLE PRECISION
)