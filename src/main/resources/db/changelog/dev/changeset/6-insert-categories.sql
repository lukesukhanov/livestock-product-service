-- changeset lukesukhanov:6

SET search_path TO livestock_shop_dev;

INSERT INTO category (category_name)
	VALUES ('Овцы'),
			('Коровы'),
			('Свиньи'),
			('Лошади'),
			('Козы');

-- rollback TRUNCATE category