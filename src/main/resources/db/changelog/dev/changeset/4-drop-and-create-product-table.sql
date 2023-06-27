-- changeset lukesukhanov:4

SET search_path TO livestock_shop_dev;

-- 'product' table
DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (
	id bigint NOT NULL PRIMARY KEY DEFAULT nextval('common_id_seq'),
	product_name varchar NOT NULL,
	description varchar,
	quantity integer NOT NULL CHECK(quantity >= 0),
	price numeric NOT NULL CHECK(price > 0),
	currency varchar(3) NOT NULL,
	image bytea,
	created_at timestamp with time zone,
	last_modified_at timestamp with time zone
);
-- rollback DROP TABLE IF EXISTS product CASCADE;

-- Trigger for inserting the 'created_at' column
DROP TRIGGER IF EXISTS sync_insert_created_at_column ON product;
CREATE TRIGGER sync_insert_created_at_column
	BEFORE INSERT
	ON product
	FOR EACH ROW 
	EXECUTE FUNCTION sync_insert_created_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_insert_created_at_column ON product;

-- Trigger for updating the 'created_at' column
DROP TRIGGER IF EXISTS sync_update_created_at_column ON product;
CREATE TRIGGER sync_update_created_at_column
	BEFORE UPDATE
	ON product
	FOR EACH ROW 
	EXECUTE FUNCTION sync_update_created_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_update_created_at_column ON product;

-- Trigger for inserting the 'last_modified_at' column
DROP TRIGGER IF EXISTS sync_insert_last_modified_at_column ON product;
CREATE TRIGGER sync_insert_last_modified_at_column
	BEFORE INSERT
	ON product
	FOR EACH ROW 
	EXECUTE FUNCTION sync_last_modified_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_insert_last_modified_at_column ON product;

-- Trigger for updating the 'last_modified_at' column
DROP TRIGGER IF EXISTS sync_update_last_modified_at_column ON product;
CREATE TRIGGER sync_update_last_modified_at_column
	BEFORE UPDATE
	ON product
	FOR EACH ROW 
	EXECUTE FUNCTION sync_last_modified_at_column();
-- rollback DROP TRIGGER IF EXISTS sync_update_last_modified_at_column ON product;