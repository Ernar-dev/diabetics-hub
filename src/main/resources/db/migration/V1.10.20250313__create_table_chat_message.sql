CREATE TABLE IF NOT EXISTS chat_message(
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        sender_id BIGINT,
                                        receiver_id BIGINT,
                                        message VARCHAR(255),
                                        created_at TIMESTAMP
)