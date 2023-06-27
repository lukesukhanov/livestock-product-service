-- changeset lukesukhanov:5

SET search_path TO livestock_shop_dev;

INSERT INTO product (product_name, 
					category, 
					description, 
					quantity, 
					price, 
					currency, 
					image)
	VALUES ('Овцы Ярки Овцематки Романовская порода племенные', 
			'Овцы',
			'Сельхозпредприятие выращивает и реализует в год до 1000 голов Чистопородных Племенных ярок, '
			|| 'овцематок и баранов Романовской породы овец.',
			100,
			12900,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\sheeps\1.jpg')),
			
			('Овцы бараны', 
			'Овцы',
			'Продаю баранов и овец',
			57,
			10500,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\sheeps\2.jpg')),
			
			('Бараны на Курбан', 
			'Овцы',
			'Всем ассаляму алейкум братья у нас есть хороший бараны на курбан-байрам всем с праздником',
			20,
			9300,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\sheeps\3.jpg')),
			
			('Овцы на продажу', 
			'Овцы',
			'Продаются : переярка и матка на развод , бараны на КУРБАН и вайлахи на мясо ,молодые ягнята на мясо.',
			34,
			10000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\sheeps\4.jpg')),
			
			('Овци Барани', 
			'Овцы',
			'Продаю молодых баранов стада 250 голов все молодые все курдючные ,есть от 20 кг до 80 кг есть доставка',
			250,
			10700,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\sheeps\5.jpg')),
			
			('Бараны живым весом', 
			'Овцы',
			'Продаю баранов молодых живым весом есть место порезать и разделать',
			20,
			10700,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\sheeps\6.jpg')),
			
			('Продаются ягнята породы "Меринос"', 
			'Овцы',
			'Продаются ягнята 6-7 месяцев.',
			50,
			10200,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\sheeps\7.jpg')),
			
			('Овцы', 
			'Овцы',
			'В продаже бараны овцы',
			30,
			10000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\sheeps\8.jpg')),
			
			('Бараны', 
			'Овцы',
			'85 голов',
			85,
			10000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\sheeps\9.jpg')),
			
			('Овца', 
			'Овцы',
			'Продам овцу живьём. На Курбан.',
			1,
			8000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\sheeps\10.jpg')),
			
			('Корова стельная дойная', 
			'Коровы',
			'Продаётся корова будет 3 отёл, стелена, причина продажи продают Родители устали.'
			|| 'Коровка зарегестрирована в меркурие все онализы брали уже в этом году, спокойная, '
			|| 'от неё есть тёлочка чёрная 6 месяцев 30т',
			1,
			115000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\cows\1.jpg')),
			
			('Бык Лимузин', 
			'Коровы',
			'Возврат 3 года на племя.',
			1,
			210000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\cows\2.jpg')),
			
			('Коровы', 
			'Коровы',
			'Мясного направления',
			7,
			60000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\cows\3.jpg')),
			
			('Корова дойная', 
			'Коровы',
			'Дойная, в январе отелилась',
			1,
			55000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\cows\4.jpg')),
			
			('Корова', 
			'Коровы',
			'Продается дойная корова , дает от 30/32 литров молока',
			1,
			100000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\cows\5.jpg')),
			
			('Быки', 
			'Коровы',
			'16 голов все бычки. Помес сементалкой.',
			16,
			60000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\cows\6.jpg')),
			
			('Корова', 
			'Коровы',
			'2 отëла. Спокойная. Доиться руками. Покрылась в апреле',
			1,
			50000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\cows\7.jpg')),
			
			('Бык год и четыре месяца', 
			'Коровы',
			'Продается молодой упитанный бык(год и четыре месяца), на мясо',
			1,
			75000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\cows\8.jpg')),
			
			('Быки и телята', 
			'Коровы',
			'3 быка по 1 году, и 2 бычка и телочка,1 бычку 4 месяца ,другому месяц,тёлочке 3 недели',
			6,
			60000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\cows\9.jpg')),
			
			('Бык', 
			'Коровы',
			'Новая партия, 10 голов бычки. С возростом 1-1.5 года. 4 абирдин, 6 голов казахский белоголовый.',
			10,
			75000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\cows\10.jpg')),
			
			('Дюрок свинья', 
			'Свиньи',
			'Свинья дюрок вес около 150 кг готова к спариванию',
			1,
			25000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\pigs\1.jpg')),
			
			('Свиньи', 
			'Свиньи',
			'Поросенок живым весом 7 месяцев срочно потом цена будет выше не где таких цен нету',
			1,
			8000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\pigs\2.jpg')),
			
			('Свинья', 
			'Свиньи',
			'Продам свинью супоросную возраст 1.5года живым весом под 150кг.',
			1,
			27000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\pigs\3.jpg')),
			
			('Супоросная свинья', 
			'Свиньи',
			'Покрыта 2 месяца. Будет второй опорос. Родила 14 поросят , всех выкормила ,'
			|| 'заболеваний никаких не выявлено. Здоровая , ласковая .',
			1,
			52000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\pigs\4.jpg')),
			
			('Продам свинью', 
			'Свиньи',
			'продам свинью, выращенную в домашних условиях без гормонов роста и добавок .Есть поросята',
			1,
			15500,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\pigs\5.jpg')),
			
			('Хряк', 
			'Свиньи',
			'Продается чистокровный хряк на племя.Венгерской пуховой мангалицы. Срочно!!! '
			|| 'Возраст 2года. Отличный производитель,ваши свинки будут довольны. Живым весом 180 кг.',
			1,
			19000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\pigs\6.jpg')),
			
			('Хряк', 
			'Свиньи',
			'Есть хорошая порода семь месяцев срочные деньги нужно',
			1,
			13000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\pigs\7.jpg')),
			
			('Хряк', 
			'Свиньи',
			'Продается хряк на племя или мясо. Примерный вес 200 кг+. Возраст 2года',
			1,
			18000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\pigs\8.jpg')),
			
			('Лошадь, жеребец', 
			'Лошади',
			'Продаём любимца нашей конюшнию. Рос в одних руках, парень статный и красивый, '
			|| 'ещё детство в попе играет.',
			1,
			200000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\horses\1.jpg')),
			
			('Лошадь пони', 
			'Лошади',
			'Продается жеребчик пони срочно',
			1,
			30000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\horses\2.jpg')),
			
			('Лошади', 
			'Лошади',
			'Продам лошадей. Кобыла жеребая, выжеребка конец августа, заезженна в круг, '
			|| 'отличный пастух, на переступи. Жеребчик 1,5 года, кобыла 1,5 года.',
			2,
			50000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\horses\3.jpg')),
			
			('Лошади', 
			'Лошади',
			'Продаётся конь хоть под воду , хоть под воеводу. Жеребец орловских кровей 7 лет. '
			|| 'Заезжен в круг. Без доков. Рост в холке примерно 160 см. Цена 200т.',
			1,
			200000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\horses\4.jpg')),
			
			('Лошадь 2г', 
			'Лошади',
			'лошадь сытая 120тыс',
			1,
			120000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\horses\5.jpg')),
			
			('Лошади', 
			'Лошади',
			'Жеребец 1,5 года , 65тысяч',
			1,
			65000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\horses\6.jpg')),
			
			('Лошадь с жеребенком', 
			'Лошади',
			'Обучена лошадь 4 года, жеребенок 2 месяца. Без обмена',
			1,
			120000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\horses\7.jpg')),
			
			('Лошадь Андалузская (рre)', 
			'Лошади',
			'На продажу предлагается серый (постепенно белеет, светлеет) испанский (PRE, андалуз) '
			|| 'мерин 2016 г.р., 165см в/х, на эффектных движениях. Без проблем со здоровьем. '
			|| 'Обладатель длинной, густой гривы. Ручной котёнок, добронравный, в меру импульсный. '
			|| 'Заезжен под верх и в беговую упряжь.',
			1,
			750000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\horses\8.jpg')),
			
			('Козел зааненский', 
			'Козы',
			'Продам на племя козла . Возраст 3 года . Характер отличный достаточно '
			|| 'спокойный своё дело исполняет.',
			1,
			12000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\goats\1.jpg')),
			
			('Козы', 
			'Козы',
			'Продам коз, они дойные дают 4,5 л',
			5,
			4500,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\goats\2.jpg')),
			
			('Козы', 
			'Козы',
			'Здравствуйте, срочная продажа коз',
			5,
			1000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\goats\3.jpg')),
			
			('Козы', 
			'Козы',
			'Продам козу дойную и козочку на мясо. Окот был 13 апреля 2023 года. '
			|| 'Козочка ещё под матерью, ест сено и зерно.',
			2,
			3500,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\goats\4.jpg')),
			
			('Козы', 
			'Козы',
			'Продам 9 козлят, 6 девочек и 3 мальчика. Возраст 4 месяца, молочной породы.',
			2,
			2000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\goats\5.jpg')),
			
			('Козы, козлы', 
			'Козы',
			'Продам молод дойную козу (2 окота), дает по 3 л молока при 2-х разовой дойки. '
			|| 'Порода мама зааненская, пап альпиец, цена 7 т.р. Козлята 5 месяцев, '
			|| '5 козликов, можно на племя и 1 козочка.',
			6,
			3000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\goats\6.jpg')),
			
			('Козел на племя', 
			'Козы',
			'неспешно предлагается к продаже англо-нубийский козел 4х лет. отличный производитель. '
			|| 'осенью 22г за месяц не напрягаясь покрыл 15 коз и все дали двойни. '
			|| '50% козлят получается комолыми.',
			1,
			15000,
			'RUB',
			pg_read_binary_file('C:\dev\projects\livestock-shop\livestock-shop-product-service\src\main\'
			|| 'resources\db\changelog\dev\static\images\goats\7.jpg'))	
				
-- rollback TRUNCATE product