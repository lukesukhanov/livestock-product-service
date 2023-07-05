-- changeset lukesukhanov:6

SET search_path TO livestock_shop_dev;

-- 'product_image' table
DROP TABLE IF EXISTS product_image CASCADE;
CREATE TABLE product_image (
	id bigint NOT NULL PRIMARY KEY DEFAULT nextval('common_id_seq'),
	image bytea NOT NULL,
	created_at timestamp with time zone NOT NULL,
	last_modified_at timestamp with time zone NOT NULL,
	product_id bigint NOT NULL REFERENCES product(id) ON DELETE CASCADE
);
-- rollback DROP TABLE IF EXISTS product_image CASCADE;

-- Trigger for inserting the 'created_at' column
DROP TRIGGER IF EXISTS sync_insert_created_at_column ON product_image;
CREATE TRIGGER sync_insert_created_at_column
	BEFORE INSERT
	ON product_image
	FOR EACH ROW 
	EXECUTE FUNCTION sync_insert_created_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_insert_created_at_column ON product_image;

-- Trigger for updating the 'created_at' column
DROP TRIGGER IF EXISTS sync_update_created_at_column ON product_image;
CREATE TRIGGER sync_update_created_at_column
	BEFORE UPDATE
	ON product_image
	FOR EACH ROW 
	EXECUTE FUNCTION sync_update_created_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_update_created_at_column ON product_image;

-- Trigger for inserting the 'last_modified_at' column
DROP TRIGGER IF EXISTS sync_insert_last_modified_at_column ON product_image;
CREATE TRIGGER sync_insert_last_modified_at_column
	BEFORE INSERT
	ON product_image
	FOR EACH ROW 
	EXECUTE FUNCTION sync_last_modified_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_insert_last_modified_at_column ON product_image;

-- Trigger for updating the 'last_modified_at' column
DROP TRIGGER IF EXISTS sync_update_last_modified_at_column ON product_image;
CREATE TRIGGER sync_update_last_modified_at_column
	BEFORE UPDATE
	ON product_image
	FOR EACH ROW 
	EXECUTE FUNCTION sync_last_modified_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_update_last_modified_at_column ON product_image;