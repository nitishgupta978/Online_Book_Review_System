use online_book_Review_system;

CREATE TABLE BOOKS ( ISBN VARCHAR (200), LANGUAGE VARCHAR (200), DIMENSION VARCHAR (200), PAGES INTEGER, COVER VARCHAR (200), RANKING INTEGER, PRICE FLOAT,  CONSTRAINT pk_isbn PRIMARY KEY (ISBN));
CREATE TABLE SIMILAR (ISBN_1 VARCHAR (200), ISBN_2 VARCHAR (200),  CONSTRAINT pk_similar PRIMARY KEY (ISBN_1,ISBN_2),  CONSTRAINT fk_similar_isbn_1 FOREIGN KEY (ISBN_1) REFERENCES BOOKS (ISBN),  CONSTRAINT fk_similar_isbn_2 FOREIGN KEY (ISBN_2) REFERENCES BOOKS (ISBN));
CREATE TABLE CUSTOMER (CUSTOMER_ID VARCHAR (200), NAME VARCHAR (200), E_MAIL VARCHAR (200), PHONE_NUMBER INTEGER, PASSWORD VARCHAR (200),  CONSTRAINT pk_cusotmer_id PRIMARY KEY (CUSTOMER_ID));

CREATE TABLE REVIEW (CUSTOMER_ID VARCHAR (200), ISBN VARCHAR (200), DATE DATE, REVIEW_TEXT VARCHAR (500), RATING NUMERIC(3,1), CONSTRAINT pk_review PRIMARY KEY (CUSTOMER_ID,ISBN), CONSTRAINT fk_review_customer_id FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (CUSTOMER_ID),  CONSTRAINT fk_review_isbn FOREIGN KEY (ISBN) REFERENCES BOOKS (ISBN), CONSTRAINT chk_review_rating CHECK (RATING >= 0.0 and RATING <= 10.0));

CREATE TABLE AUTHOR ( AUTHOR_ID VARCHAR (200), NAME VARCHAR (200),  CONSTRAINT pk_author_id PRIMARY KEY (AUTHOR_ID));

CREATE TABLE SUPPLIER ( SUP_ID VARCHAR (200), NAME VARCHAR (200), RATING NUMERIC (3,1), CONSTRAINT pk_sup_id PRIMARY KEY (SUP_ID), CONSTRAINT chk_supplier_rating CHECK (RATING <= 10.0 and RATING >= 0.0));

CREATE TABLE PUBLISHER ( PUB_ID VARCHAR (200), NAME VARCHAR (200),  CONSTRAINT pk_pub_id PRIMARY KEY (PUB_ID));

CREATE TABLE SUPPLY (ISBN VARCHAR (200), SUP_ID VARCHAR (200), IN_OUT_STOCK CHAR(1), CONSTRAINT pk_supply PRIMARY KEY (ISBN,SUP_ID), CONSTRAINT fk_supply_isbn FOREIGN KEY (ISBN) REFERENCES BOOKS (ISBN),  CONSTRAINT fk_supply_sup_id FOREIGN KEY (SUP_ID) REFERENCES SUPPLIER (SUP_ID),  CONSTRAINT chk_in_out_stock CHECK (IN_OUT_STOCK IN ('Y','N')));

CREATE TABLE AUTHORED_BY (ISBN VARCHAR (200), AUTHOR_ID VARCHAR (200),  CONSTRAINT pk_authored_by PRIMARY KEY (ISBN,AUTHOR_ID),  CONSTRAINT fk_authored_by_isbn FOREIGN KEY (ISBN) REFERENCES BOOKS (ISBN),  CONSTRAINT fk_authored_by_author_id FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHOR (AUTHOR_ID));

CREATE TABLE PUBLISHED_BY (ISBN VARCHAR (200), PUB_ID VARCHAR (200), CONSTRAINT pk_published_by PRIMARY KEY (ISBN,PUB_ID), CONSTRAINT fk_published_by_isbn FOREIGN KEY (ISBN) REFERENCES BOOKS (ISBN),  CONSTRAINT pk_published_by_pub_id FOREIGN KEY (PUB_ID) REFERENCES PUBLISHER (PUB_ID));

CREATE TABLE BUYS (CUSTOMER_ID VARCHAR (200), ISBN VARCHAR (200), DATE DATE, COUNT INTEGER,  CONSTRAINT pk_buys PRIMARY KEY (CUSTOMER_ID,ISBN,DATE,COUNT),  CONSTRAINT fk_buys_customer_id FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (CUSTOMER_ID),  CONSTRAINT fk_buys_isbn FOREIGN KEY (ISBN) REFERENCES BOOKS (ISBN));
select * from books;
select * from customer;
select * from review;
show tables;