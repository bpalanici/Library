CREATE OR REPLACE function insert_reader(p_fname readers.fname%type, p_lname readers.lname%type,
p_username readers.username%type, p_password varchar2, 
p_birthdate readers.birthdate%type)
RETURN int AS
  v_count int;
  v_new_id readers.id%type;
BEGIN 
  select count('a') into v_count from readers r where r.USERNAME = p_username;
  if v_count <> 0 then
    return 0;
  end if;
  
  select max(r.id) into v_new_id from readers r;
  v_new_id := v_new_id + 1;
  insert into Readers values(v_new_id, p_fname, p_lname, p_username, Encrypt_string(p_password), 
  p_birthdate, 0);  
  return 1;
END;
/
---------------------------------------------------------------------------------------END OF F1
--BEGIN OF F5 (VERIFICAT)

CREATE OR REPLACE function insert_author(p_afname authors.afname%type, p_alname authors.alname%type)
RETURN int AS
  v_count int;
  v_new_id authors.id%type;
BEGIN 
  select count('a') into v_count from authors a where a.AFNAME = p_afname and a.ALNAME = p_alname;
  if v_count <> 0 then
    return 0;
  end if;
  
  select max(a.id) into v_new_id from authors a;
  v_new_id := v_new_id + 1;
  insert into authors values(v_new_id, p_afname, p_alname);  
  return 1;
END;
/
--------------------------------------------------------------------------------------- END OF F5
--BEGIN OF F3 (VERIFICAT)

CREATE OR REPLACE function update_genre_of_book(p_bookName books.name%type, p_genre genres.gname%type)
RETURN int AS
  v_count int;
  v_book_id books.id%type;
BEGIN
  select count('a') into v_count from books b where b.name = lower(p_bookName);
  if v_count <> 1 then
    return -1;
  end if;

  select a into v_book_id from (select b.id a from books b where b.name = lower(p_bookName)) where rownum < 2;

  select count('a') into v_count from genres g where g.booksid = v_book_id;
  if v_count <> 1 then
    return 0;
  end if;
  update genres g set g.gname = lower(p_genre) where g.booksid = v_book_id; 
  return 1;
END;
/
---------------------------------------------------------------------------------------END OF F3
--BEGIN OF F4

CREATE OR REPLACE function update_sub_genre_of_book(p_bookName books.name%type, p_sub_genre subgenres.sgname%type)
RETURN int AS
  v_count int;
  v_book_id books.id%type;
BEGIN
  select count('a') into v_count from books b where b.name = lower(p_bookName);
  if v_count <> 1 then
    return -1;
  end if;

  select a into v_book_id from (select b.id a from books b where b.name = lower(p_bookName)) where rownum < 2;
  
  select count('a') into v_count from subgenres sg where sg.booksid = v_book_id;
  if v_count <> 1 then
    return 0;
  end if;
  update subgenres sg set sg.sgname = lower(p_sub_genre) where sg.booksid = v_book_id; 
  return 1;
END;
/
---------------------------------------------------------------------------------------END OF F4
--BEGIN OF F6

CREATE OR REPLACE function insert_read_book(p_reader_username readers.username%type, p_book_id books.id%type, p_rating readbooks.rating%type, p_review READBOOKS.REVIEW%type)
RETURN int AS
  v_count int;
  v_new_id readbooks.id%type;
  v_review READBOOKS.REVIEW%type;
  v_reader_id readers.id%type;
BEGIN
  select r.ID into v_reader_id from readers r where r.username = p_reader_username;
  select count('a') into v_count from books b where b.id = p_book_id;
  if v_count = 0 then
    return 0;
  end if;
  
  select count('a') into v_count from readers r where r.id = v_reader_id;
  if v_count = 0 then
    return 0;
  end if;
  select count('a') into v_count from readbooks rb where rb.booksid = p_book_id and rb.readersid = v_reader_id;
  v_review := p_review;
  if v_review is null then
    v_review := 'No review';
  end if;
  if v_count <> 0 then
    update readbooks rb set rb.REVIEW = v_review, rb.rating = p_rating where rb.booksid = p_book_id and rb.readersid = v_reader_id;
    update books b set b.RATING = nvl((
    select avg(rating) from ReadBooks r where 
    r.BooksID = b.ID
    group by r.BooksId
    ), 0) where b.id = p_book_id;
    return 1;
  end if;
  select max(rb.id) into v_new_id from readbooks rb;
  v_new_id := v_new_id + 1;
  insert into readbooks values(v_new_id, v_reader_id, p_book_id, p_rating, v_review); 
  update books b set b.RATING = nvl((
    select avg(rating) from ReadBooks r where 
    r.BooksID = b.ID
    group by r.BooksId
  ), 0) where b.id = p_book_id;
  return 1;
END;
/
/*
begin
  dbms_output.put_line(insert_read_book('a', 7, 1, 'asdf'));
end;
select * from readbooks order by 1 desc;*/
---------------------------------------------------------------------------------------END OF F6
--BEGIN OF F2

CREATE OR REPLACE function insert_book(p_name books.name%type, p_author_id BOOKS.AUTHORID%type,
p_isbn BOOKS.ISBN%type, p_nrpages books.nrpages%type, 
p_price BOOKS.PRICE%type)
RETURN int AS
  v_count int;
  v_new_id books.id%type;
  v_isbn BOOKS.ISBN%type;
  v_book_id int;
BEGIN 
  select count('a') into v_count from authors a where a.ID = p_author_id;
  if v_count <> 1 then
    return 0;
  end if;
  
  select count('a') into v_count from books b where b.NAME = lower(p_name);
  if v_count <> 0 then
    return 0;
  end if;
  if (length(p_isbn) is null) then
    return 'Isbn null.';
  end if;
  v_isbn := p_isbn;
  select count('a') into v_count from books b where b.ISBN = v_isbn;
  if v_count <> 0 then
    return 0;
  end if;
  
  select max(b.id) into v_new_id from books b;
  v_new_id := v_new_id + 1;
  v_book_id := v_new_id;
  insert into Books values(v_new_id, p_name, p_author_id, v_isbn, p_nrpages, 
  p_price, 0);
  select max(g.id) into v_new_id from genres g;
  v_new_id := v_new_id + 1;
  insert into genres values(v_new_id, v_book_id, 'no genre'); 
  select max(g.id) into v_new_id from subgenres g;
  v_new_id := v_new_id + 1;
  insert into subgenres values(v_new_id, v_book_id, 'no subgenre'); 
  
  return 1;
END;
/
---------------------------------------------------------------------------------------END OF F2
--BEGIN OF F7

CREATE OR REPLACE function borrow_book(p_reader_username READERS.USERNAME%type, p_book_id books.id%type)
RETURN int AS
  v_count int;
  v_new_id readers.id%type;
  v_reader_id BOOKSBORROWED.READERID%type;
  v_string varchar2(1005);
  v_book_price books.price%type;
  v_fine READERS.TOTALFINE%type;
BEGIN   
  select r.ID into v_reader_id from readers r where r.username = p_reader_username;
  
  select count('a') into v_count from BOOKSBORROWED where BOOKSID = p_book_id and READERID <> v_reader_id and ISRETURNED = 0;
  if v_count <> 0 then
    return -3; --CINEVA ARE CARTEA IMPRUMUTATA
  end if;
  
  select count('a') into v_count from BOOKSBORROWED where BOOKSID = p_book_id and READERID = v_reader_id and ISRETURNED = 0;
  if v_count <> 0 then
    return -2; --NOI AVEM CARTEA IMPRUMUTATA
  end if;
  
  select count('a') into v_count from BOOKSBORROWED where BOOKSID = p_book_id and READERID = v_reader_id and isfinepaid = 0;
  if v_count <> 0 then
    return -1; --NOI AM RETURNAT CARTEA, DAR NU AM PLATIT AMENDA
  end if;
  
  select r.TOTALFINE into v_fine from readers r where r.id = v_reader_id;
  select b.price into v_book_price from books b where b.id = p_book_id;
  
  if v_fine > v_book_price * 2 then
    return 0; --NOI AM RETURNAT CARTEA, DAR AMENDA E PREA MARE
  end if;
  
  select max(bb.id) into v_new_id from BOOKSBORROWED bb;
  v_new_id := v_new_id + 1;
  
  insert into BOOKSBORROWED values(v_new_id, v_reader_id, p_book_id, sysdate, sysdate + 30, 0, 0);
  v_string := insert_read_book(p_reader_username, p_book_id, 0, '');
  
  return 1;
END;
/

---------------------------------------------------------------------------------------END OF F7
--Start of f8

CREATE OR REPLACE procedure update_total_fine(p_reader_username READERS.USERNAME%type)
as
v_suma number(20, 4);
v_user_id int;
BEGIN 
  v_suma := 0;
  return ;
  select id into v_user_id from readers r where r.USERNAME = p_reader_username;
  begin
    FOR i IN (select loandate, returndate, price from 
              (SELECT loandate, returndate, price, isreturned, isfinepaid from booksborrowed b join books on b.booksid = books.id
               where b.READERID = v_user_id)
               where ISRETURNED = 1 and isfinepaid = 0) LOOP
        if (i.returndate - i.loandate > 30) then
          v_suma := v_suma + (i.returndate - i.loandate + 30) * 0.01 * i.price;
        end if;
    END LOOP;
  exception
    WHEN NO_DATA_FOUND THEN null;
  end;
  begin 
    FOR i IN (select loandate, returndate, price from 
              (SELECT loandate, returndate, price, isreturned, isfinepaid from booksborrowed b join books on b.booksid = books.id
               where b.READERID = v_user_id)
               where ISRETURNED = 0) LOOP
        if (i.returndate - i.loandate > 30) then
          v_suma := v_suma + (i.returndate - i.loandate + 30) * 0.01 * i.price;
        end if;
    END LOOP;
  exception
    WHEN NO_DATA_FOUND THEN null;
  end;
  
  update readers set totalfine = v_suma where readers.username = p_reader_username;
END;
/

---------------------------------------------------------------------------------------END OF F8 
--START of f9

CREATE OR REPLACE function return_book(p_reader_username READERS.USERNAME%type, p_book_name books.name%type)
RETURN int AS
  v_count int;
  v_reader_id BOOKSBORROWED.READERID%type;
  v_book_id books.id%type;
  v_loanDate booksborrowed.LOANDATe%type;
  v_ok int;
BEGIN 
  v_ok := 0;
  select count('a') into v_count from readers r where r.username = p_reader_username;
  if v_count <> 1 then
    return 0;
  end if;
  
  select count('a') into v_count from books b where b.name = p_book_name;
  if v_count <> 1 then
    return 0;
  end if;
  
  select r.ID into v_reader_id from readers r where r.username = p_reader_username;
  select id into v_book_id from books b where b.name = p_book_name;
    
  select count('a') into v_count from booksborrowed b where b.booksid = v_book_id and b.readerid = v_reader_id and b.isreturned = 0;
  if v_count <> 1 then
    return 0;
  end if;
  
  select b.LOANDATE into v_loanDate from booksborrowed b where b.booksid = v_book_id and b.readerid = v_reader_id and b.isreturned = 0;
  if (sysdate - v_loanDate) <= 30 then
    v_ok := 1;
  end if;
  update booksborrowed b set b.isreturned = 1, b.isfinepaid = v_ok, b.returndate = sysdate where b.booksid = v_book_id and b.readerid = v_reader_id and b.isreturned = 0;
 
  update_total_fine(p_reader_username);
  return 1;
END;
/
/*
select * from booksborrowed order by id desc;
delete from booksborrowed where id > 10000;
select * from books where id = 15 order by 1 ;
select * from readers order by 1 desc;
begin
  update_total_fine('a');
end;

commit;*/
---------------------------------------------------------------------------------------END OF F9
--START of f10

create or replace type type_book_table as table of int;
/
create or replace type type_book is object (
id Int,
authorId int,
Name varchar2(255),
ISBN varchar2(255), 
Nrpages Int,
Price Number(6,2),
Rating Number(4,2),
AuthorName varchar2(255),
Genre varchar2(255),
Subgenre varchar2(255)
)
/

create or replace type type_book_table as table of type_book;
/
select * from authors;

CREATE OR REPLACE function Select_top_books_a_to_b(p_start int, p_end int, p_search_string varchar2, p_type varchar2,
  p_sort varchar2, p_asc_desc varchar2)
RETURN type_book_table AS
  type type_local_books is record (
    ID books.id%type,
    authorId authors.id%type,
    Name books.name%type,
    ISBN books.isbn%type,
    nrPages books.nrpages%type,
    Price books.price%type,
    Rating books.rating%type,
    AuthorName varchar(255),
    Genre genres.gname%type,
    Subgenre subgenres.sgname%type
  );
  TYPE type_local_books_table IS table OF type_local_books INDEX BY PLS_INTEGER;
  v_local_books_table type_local_books_table;
  v_ret type_book_table;
  v_start int;
  v_end int;
  v_comanda varchar2(1005);
  v_subselect varchar2(1005);
  v_gname varchar2(1005);
BEGIN
  v_start := p_start;
  v_end := p_end;
  v_gname := p_type;
  if v_gname = 'Genre' then
    v_gname := 'gname';
  end if;
  if v_gname = 'Subgenre' then
    v_gname := 'sgname';
  end if;
  if v_gname = 'AuthorName' then
    v_gname := 'a.ALNAME || '' '' || a.AFNAME';
  end if;
  if (p_start >= p_end) then
    v_start := p_end;
    v_end := p_start;
  end if;
  v_ret := type_book_table();
  v_subselect := 'select b.id as "id", a.id as "Authorid", b.name as "Name", b.isbn as "ISBN", b. nrpages as "Nrpages", b.price as "Price", b.rating as "Rating",
     (a.ALNAME || '' '' || a.AFNAME) as "AuthorName", g.gname as "Genre", sg.sgname as "Subgenre" from books b
    join GENRES g on g.booksid = b.id
    join SUBGENRES sg on sg.booksid = b.id
    join AUTHORS a on a.ID = b.AUTHORID';  
  if (v_gname not like '<Type>' and p_search_string is not null)
  then
    v_subselect := v_subselect || ' where ' || v_gname || ' = ''' || p_search_string || ''' ';
  end if;

  if (p_sort not like '<Sort By>')
  then
    v_subselect := v_subselect || ' order by ' || p_sort || ' ';
    if (p_asc_desc <> '<Order>')
    then
      v_subselect := v_subselect || p_asc_desc;
    end if;
  end if;

  v_comanda := 'select "id", "Authorid", "Name", "ISBN", "Nrpages", "Price", "Rating", "AuthorName", "Genre", "Subgenre"
  from (
    select /*+ FIRST_ROWS('
    || (v_end - v_start + 2) || ') */  "id", "Authorid", "Name", "ISBN", "Nrpages", "Price", "Rating", "AuthorName", "Genre", "Subgenre", ROWNUM rnum
    from (
      ' || v_subselect ||
    ')
    where ROWNUM <= ' || v_end || '
  )
  where rnum >= ' || v_start;

  DBMS_OUTPUT.PUT_LINE(v_comanda);

  execute immediate(v_comanda) bulk collect into v_local_books_table;
  for i in 1..v_local_books_table.count
  loop
    v_ret.extend;
    v_ret(v_ret.count) := type_book(v_local_books_table(i).id,
    v_local_books_table(i).authorid,
    v_local_books_table(i).name, v_local_books_table(i).ISBN,
    v_local_books_table(i).Nrpages, v_local_books_table(i).Price,
    v_local_books_table(i).Rating, v_local_books_table(i).AuthorName,
    v_local_books_table(i).Genre, v_local_books_table(i).Subgenre);
  end loop;
  return v_ret;
END;
/
/*
select * from table(Select_top_books_a_to_b(1, 5, '3', 'Rating', 'Name', '<Order>'));


select a.ALNAME || ' ' || a.AFNAME from authors a;
declare 
v_ret type_book_table;
begin 
  v_ret := Select_top_books_a_to_b(1, 5, '3', 'Rating', 'Name', '<Order>'); 
end;
*/

/*
select * from table(Select_top_books_a_to_b(1, 600, 'Fairy Tale', 'subgenre', 'rating', 'desc'));

select * from table(Select_top_books_a_to_b(1, 600, 'new age', 'gname', 'rating', 'desc'));
select * from subgenres;
select * from table(Select_top_books_a_to_b(1, 5, null, 'price', 'rating', 'asc'));
select count(*) from books;*/

----------------------------------------------------------------------------------- END IF F10
--START OF F11

/*
create or replace type type_number_table as table of number(37);
/
*/

create or replace function encrypt_RSA_int(p_in number)
return number as
  v_nr number;
  v_ret number;
  v_public_key number;
  v_first_prime number;
  v_second_prime number;
  v_product number;
  v_phi number;
  v_pow number(5, 0);
begin
  v_nr := p_in;
  v_ret := 1;
  v_first_prime := 9999999997777777333; --19 DIGITS PRIME https://primes.utm.edu/curios/page.php/9999999997777777333.html
  v_second_prime := 1000000000100011; --16 DIGITS PRIME https://primes.utm.edu/curios/page.php/1000000000100011.html
  v_product := v_first_prime * v_second_prime;
  v_phi := (v_first_prime - 1) * (v_second_prime - 1);
  v_pow := 65537 ; -- prime number;
  while v_pow > 0 loop
    if mod(v_pow, 2) = 1 then
      v_ret := mod(v_ret * v_nr, v_phi);
      v_pow := v_pow - 1;
    end if;
    v_nr := mod(v_nr * v_nr, v_phi);
    v_pow := v_pow / 2;
  end loop;
  return v_ret;
end;
/

drop table charsEncrypted;

CREATE TABLE charsEncrypted(
ID Int NOT NULL PRIMARY KEY,
character char NOT NULL,
encryptedChar number not null
)
/
create index indx_chars on charsEncrypted(character);
/
begin
  for i in 32..126 loop
    insert into charsEncrypted values(i - 31, chr(i), encrypt_RSA_int(i));
  end loop;
  commit;
end;
/
create or replace function Encrypt_string(p_string varchar2)
RETURN type_number_table AS
  v_ret type_number_table;
begin
  v_ret := type_number_table();
  v_ret.extend(length(p_string));
  for i in 1..length(p_string)
  loop
    select ENCRYPTEDCHAR into v_ret(i) from CHARSENCRYPTED where CHARACTER = substr(p_string, i, 1);
  end loop;
  return v_ret;
end;
/
--select * from charsEncrypted;
CREATE OR REPLACE function login_pass(p_user_username READERS.USERNAME%type, p_pass_plain varchar2)
RETURN int AS
  v_pass_encrypted type_number_table;
  v_pass_database type_number_table;
  v_ok int;
BEGIN 
  v_pass_encrypted := Encrypt_string(p_pass_plain);
  
  select count('a') into v_ok from readers where p_user_username = username;
  if (v_ok <> 1) then
    return 0;
  end if;
  
  select password into v_pass_database from readers where p_user_username = username;
  if (v_pass_database.count <> v_pass_encrypted.count) then
    return 0;
  end if;
  
  for i in 1..v_pass_database.count
  loop
    if (v_pass_database(i) <> v_pass_encrypted(i)) then
      return 0;
    end if;
  end loop;
  
  update_total_fine(p_user_username);
  return 1;
END;
/
/*
select count(*) as "COUNT" from readers where username = 'a' 
or '1' = '1' and password = Encrypt_string('aasfd');*/
-----------------------------------------------------------------------------------
/*
select * from authors order by 1 desc;
delete from authors where id > 75000;
select * from subgenres order by 1 desc;
select * from books order by 1 desc;
select * from readbooks order by 1 desc;
select * from books order by 1 desc;
select * from authors order by 1 desc;
select * from booksborrowed order by 1 desc;

begin
  DBMS_OUTPUT.PUT_LINE(login_pass('user1', 'password3'));
end;

SELECT loandate, returndate, price from booksborrowed b join books on b.booksid = books.id
    where b.READERID = 97787; 
    
update booksborrowed b set b.loandate = sysdate - 60 where id = 1000001;
select * from booksborrowed where readerid = 97787;
select * from readers where id = 97787;
/

 SELECT (returndate - loandate) * 0.1, price, isreturned from booksborrowed b join books on b.booksid = books.id
             where b.READERID = 69755;  
             
SELECT max(count(b.readerid)) from booksborrowed b
    group by b.readerid;

drop procedure insert_reader;
select * from readers where id = 97787;
delete from readbooks where id > 1000000;
delete from booksborrowed where id > 1000000;*/