CREATE TABLE IF NOT EXISTS next_visit_planning (
                                                   id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                                   next_visit_date TIMESTAMP,
                                                   next_visit_reason VARCHAR(255)
)