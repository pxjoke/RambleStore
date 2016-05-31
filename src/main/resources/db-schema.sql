CREATE TABLE items (
  id           NUMBER AUTO_INCREMENT PRIMARY KEY,
  title        VARCHAR2(100),
  genre        VARCHAR2(50),
  release_date DATE   DEFAULT now(),
  price        NUMBER DEFAULT 0,
  company      VARCHAR2(100),
  img          VARCHAR2(100),
  description VARCHAR2(300)
);

CREATE TABLE users (
  id       NUMBER AUTO_INCREMENT PRIMARY KEY,
  email    VARCHAR2(200),
  password VARCHAR2(30),
  role     VARCHAR(30)
);

CREATE TABLE orders
(
  id NUMBER AUTO_INCREMENT PRIMARY KEY,
  sale_date DATE DEFAULT NOW(),
  user_id NUMBER,
  CONSTRAINT orders_USERS_ID_fk FOREIGN KEY (user_id) REFERENCES USERS (ID)
);

CREATE TABLE order_position (
  id       NUMBER AUTO_INCREMENT PRIMARY KEY,
  order_id NUMBER,
  item_id  NUMBER,
  price    NUMBER,
  amount   NUMBER,
  CONSTRAINT order_position_order_id_fk FOREIGN KEY (order_id) REFERENCES orders (id),
  CONSTRAINT order_position_item_id_fk FOREIGN KEY (item_id) REFERENCES items (id)
);