INSERT INTO items (title, genre, price, company, img, description)
VALUES ('The Witcher 3', 'RPG', 19.98, 'CD Project Red', 'https://images2.alphacoders.com/551/551471.jpg',
        'Welcome to the land of summer, a remote valley untouched by war. The land of wandering knights, noble ladies and magnificent wineries. What better time to visit than now, when this kingdom of virtue is torn apart by a series of savage massacres! Geralt of Rivia, a legendary monster slayer, takes on his last great contract. Blood and Wine offers over 30 hours of adventure, where beauty clashes with horror, and love dances with deceit.!');

INSERT INTO items (title, genre, price, company, img, description)
VALUES ('Arkham Knight', 'Action/Stels', 15.99, '	Rocksteady Studios', 'http://blogs-images.forbes.com/jasonevangelho/files/2015/06/maxresdefault.jpg',
        'Arkham Knight''s main story follows Scarecrow, the Arkham Knight and Deathstroke, who have made an alliance on Halloween night, and plan to drown Gotham City in fear toxin and unmask Batman. The game has received universal acclaim but was criticized for the extensive use of the Batmobile combat segments.');

INSERT INTO items (title, genre, price, company, img, description)
VALUES ('Assassins Creed', 'Action/Stels', 13.98, 'Ubisoft', 'https://i.ytimg.com/vi/iFJ-0lknYcc/maxresdefault.jpg',
        'The Assassin''s Creed series is an award-winning video game series that currently consists of nine main games, seventeen spin-off games, several short films and various transmedia projects. Each of the main games have spawned novelizations, adapting and adding to the story of their respective game.');

INSERT INTO items (title, genre, price, company, img, description)
VALUES ('Skyrim', 'RPG', 13.98, 'Bethesda Game Studios', 'http://www.onlysp.com/wp-content/uploads/2014/01/the_elder_scrolls_v_skyrim.jpg',
        'EPIC FANTASY REBORN The next chapter in the highly anticipated Elder Scrolls saga arrives from the makers of the 2006 and 2008 Games of the Year, Bethesda Game Studios. Skyrim reimagines and revolutionizes the open-world fantasy epic, bringing to life a complete virtual world open for you.');

INSERT INTO items (title, genre, price, company, img, description)
VALUES ('Mass Effect', 'RPG', 12.98, 'BioWare', 'https://georgespigot.files.wordpress.com/2012/03/mass-effect-3-01.jpg',
        'With unique in-game bonus items including powerful N7 grade weapons, a robotic canine companion and an insightful DLC pack that delves into Mass Effect lore, the Digital Deluxe Edition gives you even more material to enhance your galactic adventure. Plus, bring the journey home with the limited edition Mass Effect Comic and a 70-page art book packed full of unique drawings from the Mass Effect universe.');

INSERT INTO users (EMAIL, PASSWORD, ROLE)
VALUES ('pxjoke@gmaul.com', '1234560', 'admin');

INSERT INTO users (EMAIL, PASSWORD, ROLE)
VALUES ('ginvaell@gmaul.com', '89172879534', 'user');

INSERT INTO orders (SALE_DATE, USER_ID, STATUS) VALUES ('2016-06-01', 1, 'cart');
INSERT INTO orders (SALE_DATE, USER_ID, STATUS) VALUES ('2015-06-01', 1, 'paid');
INSERT INTO orders (SALE_DATE, USER_ID, STATUS) VALUES ('2016-06-01', 2, 'cart');

INSERT INTO ORDER_POSITION (ORDER_ID, ITEM_ID, PRICE, AMOUNT) VALUES (1, 1, 15.38, 2);
INSERT INTO ORDER_POSITION (ORDER_ID, ITEM_ID, PRICE, AMOUNT) VALUES (1, 2, 13.28, 1);
INSERT INTO ORDER_POSITION (ORDER_ID, ITEM_ID, PRICE, AMOUNT) VALUES (2, 1, 3.25, 1);