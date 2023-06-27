-- changeset lukesukhanov:4

SET search_path TO livestock_shop_dev;

-- 'category' table
DROP TABLE IF EXISTS category CASCADE;
CREATE TABLE category (
	id integer NOT NULL PRIMARY KEY DEFAULT nextval('common_id_seq'),
	category_name varchar NOT NULL UNIQUE,
	created_at timestamp with time zone,
	last_modified_at timestamp with time zone
);
-- rollback DROP TABLE IF EXISTS category CASCADE;

-- Trigger for inserting the 'created_at' column
DROP TRIGGER IF EXISTS sync_insert_created_at_column ON category;
CREATE TRIGGER sync_insert_created_at_column
	BEFORE INSERT
	ON category
	FOR EACH ROW 
	EXECUTE FUNCTION sync_insert_created_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_insert_created_at_column ON category;

-- Trigger for updating the 'created_at' column
DROP TRIGGER IF EXISTS sync_update_created_at_column ON category;
CREATE TRIGGER sync_update_created_at_column
	BEFORE UPDATE
	ON category
	FOR EACH ROW 
	EXECUTE FUNCTION sync_update_created_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_update_created_at_column ON category;

-- Trigger for inserting the 'last_modified_at' column
DROP TRIGGER IF EXISTS sync_insert_last_modified_at_column ON category;
CREATE TRIGGER sync_insert_last_modified_at_column
	BEFORE INSERT
	ON category
	FOR EACH ROW 
	EXECUTE FUNCTION sync_last_modified_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_insert_last_modified_at_column ON category;

-- Trigger for updating the 'last_modified_at' column
DROP TRIGGER IF EXISTS sync_update_last_modified_at_column ON category;
CREATE TRIGGER sync_update_last_modified_at_column
	BEFORE UPDATE
	ON category
	FOR EACH ROW 
	EXECUTE FUNCTION sync_last_modified_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_update_last_modified_at_column ON category;