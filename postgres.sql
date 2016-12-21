CREATE TABLE users (
  EMAIL    VARCHAR(50)        NOT NULL UNIQUE,
  PASSWORD VARCHAR(50)        NOT NULL,
  USERNAME VARCHAR(50)        NOT NULL,
  USER_ID  SERIAL PRIMARY KEY NOT NULL,
  UNIQUE (EMAIL),
  UNIQUE (USER_ID)
);

INSERT INTO users (EMAIL, PASSWORD, USERNAME, USER_ID) VALUES ('admin@knigi.ru', 'admin', 'admin', 1);

CREATE TABLE PRODUCTS
(
  PRODUCT_NAME VARCHAR(50)        NOT NULL,
  PUBLISHER    VARCHAR(100)       NOT NULL,
  AUTHOR       VARCHAR(50)        NOT NULL,
  PRODUCT_ID   SERIAL PRIMARY KEY NOT NULL,
  PRICE        INTEGER            NOT NULL,
  IMAGE        VARCHAR(100)       NOT NULL,
  EDITION      INTEGER            NOT NULL,
  ISBN         VARCHAR(100)       NOT NULL,
  LANGUAGE     VARCHAR(100)       NOT NULL,
  PAGE         INTEGER            NOT NULL,
  WEIGHT       INTEGER            NOT NULL,
  YEAR         INTEGER            NOT NULL,
  UNIQUE (PRODUCT_ID)
);


INSERT INTO PRODUCTS (PRODUCT_NAME, PUBLISHER, AUTHOR, PRICE, IMAGE, EDITION, ISBN, LANGUAGE, PAGE, WEIGHT, YEAR) VALUES
  ('Повелитель мух', 'АСТ, Neoclassic', 'Уильям Голдинг', 148,
                     'http://ozon-st.cdn.ngenix.net/multimedia/1008785760.jpg', 44000, '978-5-17-080086-5', 'Русский',
                     322, 229, 2013);
INSERT INTO PRODUCTS (PRODUCT_NAME, PUBLISHER, AUTHOR, PRICE, IMAGE, EDITION, ISBN, LANGUAGE, PAGE, WEIGHT, YEAR) VALUES
  ('Заводной апельсин', 'АСТ, Neoclassic', 'Энтони Берджесс', 141,
                        'http://ozon-st.cdn.ngenix.net/multimedia/1008785755.jpg', 39000, '978-5-17-080109-1',
                        'Русский', 512, 585, 2015);
INSERT INTO PRODUCTS (PRODUCT_NAME, PUBLISHER, AUTHOR, PRICE, IMAGE, EDITION, ISBN, LANGUAGE, PAGE, WEIGHT, YEAR) VALUES
  ('1984', 'АСТ, Neoclassic', 'Джордж Оруэлл', 141, 'http://ozon-st.cdn.ngenix.net/multimedia/1011499468.jpg', 84000,
           '978-5-17-080115-2', 'Русский', 256, 183, 2013);
INSERT INTO PRODUCTS (PRODUCT_NAME, PUBLISHER, AUTHOR, PRICE, IMAGE, EDITION, ISBN, LANGUAGE, PAGE, WEIGHT, YEAR) VALUES
  ('Клуб бездомных мечтателей', 'Эксмо', 'Лиз Мюррей', 272,
                                'https://j.livelib.ru/boocover/1001385848/o/a074/Liz_Myurrej__Klub_bezdomnyh_mechtatelej.jpeg',
                                7000, '978-5-699-80362-0', 'Русский', 336, 245, 2015);
INSERT INTO PRODUCTS (PRODUCT_NAME, PUBLISHER, AUTHOR, PRICE, IMAGE, EDITION, ISBN, LANGUAGE, PAGE, WEIGHT, YEAR) VALUES
  ('Мальчик на вершине горы', 'Фантом Пресс', 'Джон Бойн', 333,
                              'https://i.livelib.ru/boocover/1001448900/o/8e55/Dzhon_Bojn__Malchik_na_vershine_gory.jpeg',
                              2500, '978-5-86471-716-5', 'Русский', 320, 229, 2013);
INSERT INTO PRODUCTS (PRODUCT_NAME, PUBLISHER, AUTHOR, PRICE, IMAGE, EDITION, ISBN, LANGUAGE, PAGE, WEIGHT, YEAR) VALUES
  ('Мальчик в полосатой пижаме', 'Фантом Пресс', 'Джон Бойн', 364,
                                 'http://ozon-st.cdn.ngenix.net/multimedia/1015969087.jpg', 3000, '978-5-86471-663-2',
                                 'Русский', 288, 215, 2016);
INSERT INTO PRODUCTS (PRODUCT_NAME, PUBLISHER, AUTHOR, PRICE, IMAGE, EDITION, ISBN, LANGUAGE, PAGE, WEIGHT, YEAR) VALUES
  ('Таинственная страсть. Роман о шестидесятниках', 'ИП Бирюкова Оксана Анатольевна', 'Василий Аксенов', 709,
                                                    'https://ozon-st.cdn.ngenix.net/multimedia/1013924922.jpg', 25000,
                                                    '978-5-9907536-0-0', 'Русский', 738, 895, 2015);
INSERT INTO PRODUCTS (PRODUCT_NAME, PUBLISHER, AUTHOR, PRICE, IMAGE, EDITION, ISBN, LANGUAGE, PAGE, WEIGHT, YEAR) VALUES
  ('Дом, в котором...', 'Гаятри/Livebook', 'Мариам Петросян', 556,
                        'https://ozon-st.cdn.ngenix.net/multimedia/1013166953.jpg', 10000, '978-5-9907536-1-2',
                        'Русский', 960, 1005, 2015);
INSERT INTO PRODUCTS (PRODUCT_NAME, PUBLISHER, AUTHOR, PRICE, IMAGE, EDITION, ISBN, LANGUAGE, PAGE, WEIGHT, YEAR) VALUES
  ('Тринадцатая сказка', 'Азбука, Азбука-Аттикус', 'Диана Сеттерфилд', 308,
                         'https://ozon-st.cdn.ngenix.net/multimedia/1005997207.jpg', 3000, '	978-5-389-05833-0',
                         'Русский', 464, 482, 2016);


CREATE TABLE COMMENTS
(
  COMMENT TEXT               NOT NULL,
  PRODUCT SERIAL REFERENCES PRODUCTS (PRODUCT_ID),
  EMAIL   VARCHAR(50)        NOT NULL,
  COM_ID  SERIAL PRIMARY KEY NOT NULL,
  UNIQUE (COM_ID)
);
