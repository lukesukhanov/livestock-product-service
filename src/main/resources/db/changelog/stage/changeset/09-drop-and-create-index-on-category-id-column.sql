-- changeset lukesukhanov:9

SET search_path TO livestock_stage;

DROP INDEX IF EXISTS category_id_idx CASCADE;
CREATE INDEX category_id_idx
ON product (category_id)
-- rollback DROP INDEX IF EXISTS category_id_idx;