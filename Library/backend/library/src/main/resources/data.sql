insert into Genre (genre_name) values ('Love');
insert into Genre (genre_name) values ('Thriller');
insert into Genre (genre_name) values ('Mystery');
insert into Genre (genre_name) values ('Novel');
insert into Genre (genre_name) values ('Fantasy');

insert into Book_Order (order_date,order_price,order_status) values (parsedatetime('17-09-2012 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), 1000,'Complete');

insert into Book (book_name, book_author, book_description, book_publisher, book_language, book_year, book_price, book_quantity)
values ('The Great Gatsby', 'F. Scott Fitzgerald', 'The story of this novel primarily concerns the young and mysterious millionaire
Jay Gatsby and his passion and obsession with the beautiful former debutante Daisy Buchanan.', 'Vulkan', 'Srpski', 1925, 500.00, 10);

insert into Book (book_name, book_author, book_description, book_publisher, book_language, book_year, book_price, book_quantity)
values ('Harry Potter and the Philosophers Stone', 'J. K. Rowling', 'A young wizard discovers his
magical heritage when he receives a letter of acceptance to Hogwarts School.
Harry with the help of his friends faces the dark wizard Lord Voldemort.', 'Vulkan', 'Srpski', 1997, 600.00, 5);

insert into Customer (customer_name,customer_surname,customer_gender,customer_phone_num,
                        customer_email,customer_country,customer_city,customer_street,customer_password)
values ('Marko','Markovic','m','+38162564736','mmarkovic@gmail.com','Serbia','Novi Sad','Bulevar Oslobodjenja bb','marko')