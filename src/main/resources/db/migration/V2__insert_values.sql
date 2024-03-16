INSERT INTO LIBRARY_USER (name, first_name, member_since, member_till, gender) VALUES
    ('Aexi','Liam','2010-01-01',null,'m'),
    ('Zhungwang','Noah','2020-11-24',null,'m'),
    ('Odum','Oliver','1999-08-05','2021-01-01','m');


INSERT INTO BOOK (title, author, genre, publisher) VALUES
    ('Image Processing & Mathematical Morphology','Shih, Frank','signal_processing','CRC'),
    ('India from Midnight to Milennium','Tharoor, Shashi','history','Penguin'),
    ('Hunchback of Notre Dame, The','Hugo, Victor','fiction','Random House'),
    ('False Impressions','Archer, Jeffery','fiction','Pan'),
    ('Electric Universe','Bodanis, David','science','Penguin'),
    ('Amulet of Samarkand, The','Stroud, Jonathan','fiction','Random House'),
    ('Complete Sherlock Holmes, The - Vol II','Doyle, Arthur Conan','fiction','Random House'),
    ('Identity & Violence','Sen, Amartya','philosophy','Penguin');


INSERT INTO BORROWED (borrower_id, book_id, borrowed_from, borrowed_to) VALUES
    (3,3,'2019-07-30','2019-08-20'),
    (1,7,'2015-05-09','2019-05-31'),
    (1,8,'2020-06-23','2020-07-19');