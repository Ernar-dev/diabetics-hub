ALTER TABLE prescription
    DROP COLUMN doctor_id,
    DROP COLUMN patient_id,
    ADD COLUMN IF NOT EXISTS reminders_patient VARCHAR(255);