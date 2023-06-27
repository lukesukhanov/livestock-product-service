-- changeset lukesukhanov:6

SET search_path TO livestock_shop_dev;

DROP INDEX IF EXISTS category_idx CASCADE;
CREATE INDEX category_idx
ON product (category)
-- rollback DROP INDEX category_idx;