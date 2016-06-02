INSERT INTO items (title, genre, price, company, img, description)
VALUES ('The Witcher 3', 'RPG', 19.98, 'CD Project Red', '/withcer.jpg', 'Fantastic game!');

INSERT INTO items (title, genre, price, company, img, description)
VALUES ('Assassins Creed', 'Action/Stels', 13.98, 'Ubisoft', '/assassins.jpg', 'Awesome game!');

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