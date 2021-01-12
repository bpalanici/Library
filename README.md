# Library

This project represents a library. The users will be able to borrow books. After they return them, they will be able to write an opinion. The users will receive recommendations based on the type of books they read and based on the score given by other readers to the books. Each book will have a return term. If some reader does not return a book on time, they will receive a fine. From a certain sum, a user will not be able to take any more books. If they pay the fine, they will be able to take books again.

This project is implemented in Java for the GUI and controller, and database calls are made and optimised in PLSQL.
 
We will use the following indexes:
1)	Books : Name, AuthorID, Price, Rating
2)	BooksRead: ReaderID, BooksID
3)	Readers : BirthDate, UserName
4)	SubGenre : sname
5)	Genres : Gname
6)	BooksRead : Rating

We will have the following constraints:
1)	The rating of a book will update as the average Rating of the reviews to that book.
2)	The pair ReaderId and BooksId from ReadBooks will be unique

We will use the functions:
1)	insert_reader that will insert a new Reader, and will receive as arguments the information about that reader 
2)	insert_book that will insert a new Book, and will receive as arguments the information about that book
3)	insert_genre_to_book that will insert a new Genre to a book, and will receive as argument the name of the book and the genre 
4)	insert_sub_genre_to_book that will insert a new Subgenre to a book, and will receive as argument the name of the book and the subgenre 
5)	insert_author that will insert a new author, and will receive as arguments the information about that author
6)	Insert_read_book that will insert a new ReadBooks record. It will receive as arguments the id of the reader and the book
7)	borrow_book that will set add the register formed by Book name, Reader username, set LoanDate to current date and ReturnDate to current date + 2 weeks, and also add the pair (ReaderId, BookId) to ReadBooks table. It will take as parameter the name of book and username of Reader and will return a String meaning success or failure.
8)	update_total_fine that will run every time the program starts and will check in the Books table if the user has books that he did not returned, and update the field TotalFine from the table Readers. It will take as parameter the ID of the Reader.
9)	Select_top_books_a_to_b that will return a table data type consisting of the b - a books from book with number a to book with number b
ordered by Rating, having the fields ID, Name, AuthorID, Price, Rating. It will get as argument the number of books.
10)	select_top_n_Readers that will return a table data type consisting of top n Readers ordered by number of books Read. The table data type will contain Fname, Lname and number_of_books. It will get as argument the number of readers.
11)	Select_next_n_books that will return a table data type consisting of n books. The function will receive a user ID and the number of books and based on that it will take first n books sorted by Rating(from all the books), that have the genre or subgenre in the list of genres and subgenres of the first 10(or less) books that the user has read ordered by Rating(from BooksRead).

Database Normal Form:
The database is in 1NF because all fields are atomic.
The tables ReadBooks, Genres, SubGenres, and Authors are all in 4 Nf, because the fields depend only on the primary key field(ID). The fields does not depend on any foreign key, so we have the only key, the ID.

The table Reviews also is in 4NF because the 2 fields Rating and Opinion depend on the key formed from the primary ke. One Reader can have 2 different ratings and Opinions, and one book can also have 2 or more different Ratings and Opinions. So the fields depend only on the Primary key.

The table Readers is in 2NF, because the only key is the field ID. By definition, if the key is just 1 field, then the table is in 2NF. But the table is not in 3NF, because all the other fields except Id and username, are functional dependent on the field Username. So we have
Id -> Username, but Username -> Password.
The same thing we can say about the Books table. The key is formed from a single field, ID, so it sure is in 2NF. But because of the unique field ISBN, we have ID -> ISBN, but ISBN -> Name.
