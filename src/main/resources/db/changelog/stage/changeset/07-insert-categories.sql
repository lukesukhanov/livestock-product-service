-- changeset lukesukhanov:7

SET search_path TO livestock_stage;

INSERT INTO category (category_name)
	VALUES ('Овцы'),
			('Коровы'),
			('Свиньи'),
			('Лошади'),
			('Козы');

-- rollback TRUNCATE category