DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE role (
  id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name varchar(50) NOT NULL
);

CREATE TABLE usr (
  id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  role integer NOT NULL,
  name varchar(100) NOT NULL,
  suspended boolean DEFAULT false,
  password varchar(255) NOT NULL,
  email varchar(255) NOT NULL UNIQUE,
  FOREIGN KEY (role) REFERENCES role (id)
);

CREATE TABLE card (
  id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  number varchar(19) NOT NULL,
  expiration varchar(5) NOT NULL,
  cvv integer NOT NULL,
  name varchar(100) NOT NULL,
  usr integer NOT NULL,
  FOREIGN KEY (usr) REFERENCES usr (id) ON DELETE CASCADE
);

CREATE TABLE category (
  id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name varchar(100) NOT NULL UNIQUE
);

CREATE TABLE item (
  id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name varchar(150) NOT NULL,
  description text,
  image varchar(255) NOT NULL,
  price double precision DEFAULT 0.0,
  stock integer DEFAULT 1,
  new boolean DEFAULT true,
  category integer NOT NULL,
  usr integer NOT NULL,
  rating double precision DEFAULT 0.0,
  rates integer DEFAULT 0,
  accepted boolean DEFAULT false,
  rejected boolean DEFAULT false,
  
  FOREIGN KEY (category) REFERENCES category (id) ON DELETE CASCADE,
  FOREIGN KEY (usr) REFERENCES usr (id) ON DELETE CASCADE
);

CREATE TABLE purchase (
  id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  total double precision,
  usr integer NOT NULL,
  delivery_date timestamp DEFAULT (now() + interval '5 days'),
  delivered boolean DEFAULT false,
  created_at timestamp DEFAULT now(),
  card integer NOT NULL,
  FOREIGN KEY (usr) REFERENCES usr (id) ON DELETE CASCADE,
  FOREIGN KEY (card) REFERENCES card (id) ON DELETE CASCADE
);

CREATE TABLE item_purchased (
  usr integer NOT NULL,
  item integer NOT NULL,
  purchase integer NOT NULL,
  quantity integer DEFAULT 0,
  PRIMARY KEY (usr, item, purchase),
  FOREIGN KEY (usr) REFERENCES usr (id) ON DELETE CASCADE,
  FOREIGN KEY (item) REFERENCES item (id),
  FOREIGN KEY (purchase) REFERENCES purchase (id) ON DELETE CASCADE
);

CREATE TABLE cart_item (
  usr integer NOT NULL,
  item integer NOT NULL,
  quantity integer DEFAULT 0,
  PRIMARY KEY (usr, item),
  FOREIGN KEY (usr) REFERENCES usr (id) ON DELETE CASCADE,
  FOREIGN KEY (item) REFERENCES item (id)
);
 
CREATE TABLE item_notification (
  id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  message varchar(255) NOT NULL,
  item integer NOT NULL,
  FOREIGN KEY (item) REFERENCES item (id) ON DELETE CASCADE
);

CREATE TABLE purchase_notification (
  id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  message varchar(255) NOT NULL,
  purchase integer NOT NULL,
  FOREIGN KEY (purchase) REFERENCES purchase (id) ON DELETE CASCADE
);
