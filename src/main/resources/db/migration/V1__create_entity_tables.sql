DROP TABLE IF EXISTS LIBRARY_USER;
DROP TABLE IF EXISTS BOOK;
DROP TABLE IF EXISTS BORROWED;

CREATE TABLE LIBRARY_USER (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    member_since DATE NOT NULL,
    member_till DATE DEFAULT NULL,
    gender VARCHAR(10) DEFAULT NULL
);

CREATE TABLE BOOK (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL
);

CREATE TABLE BORROWED (
    id INT AUTO_INCREMENT PRIMARY KEY,
    borrower_id INT,
    book_id INT,
    borrowed_from DATE NOT NULL,
    borrowed_to DATE NOT NULL,
    FOREIGN KEY (borrower_id) REFERENCES LIBRARY_USER(id),
    FOREIGN KEY (book_id) REFERENCES BOOK(id)
);