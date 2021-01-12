create type type_book is object (
ID Int,
Name varchar(255),
AuthorID Int,
ISBN varchar(255), 
nrPages Int,
Price Number(6,2),
Rating Number(4,2)
)
/
set serveroutput on;
  
create or replace type type_book_table as table of type_book;
/
  
create or replace type type_number_table as table of number(37);
/
  
create or replace type type_dummy_table as table of type_dummy;
/


begin
  DBMS_OUTPUT.put_line(borrow_book('user1', 1));
  commit;
end;


select * from BOOKSBORROWED order by 1 desc, 2 asc;
select totalfine from readers;
delete from BOOKSBORROWED where id > 10002;
select * from readbooks order by 1 desc;

update BOOKSBORROWED set isfinepaid = 1 where readerid = 1 and booksid = 1;
update BOOKSBORROWED set isreturned = 1 where readerid = 1 and booksid = 1;
update readers set TOTALFINE = 100000 where id = 1;
select * from table(get_type_dummy());
select count(*) from books;
       
drop table passwords;
INSERT INTO passwords VALUES(1, 1, Encrypt_string('aasdf'));
INSERT INTO passwords VALUES(2, 2, type_number_table('15', '2'));
INSERT INTO passwords VALUES(3, 3, type_number_table('3', '6'));
insert into usernamev2 values(1, 'x', 1);
/
SELECT * FROM passwords p;
----------------------------------------------------------------------------START OF CRYPT FUNCTION
drop table passwords;

CREATE TABLE passwords (
ID Int NOT NULL PRIMARY KEY,
PassId int NOT NULL,
Password type_number_table
--, CONSTRAINT fk_passwords_passId FOREIGN KEY (PassId) REFERENCES Books(ID)
)
NESTED TABLE Password STORE AS lista;
/

create table usernamev2 (
id int not null primary key,
username varchar2(105) not null,
id_pass int
)
/
select * from usernamev2;
SELECT * FROM passwords p;

CREATE OR REPLACE function login_pass(p_user_username READERS.USERNAME%type, p_pass_plain varchar2)
RETURN int AS
  v_pass_encrypted type_number_table;
  v_pass_database type_number_table;
  v_pass_id int;
BEGIN 
  v_pass_encrypted := Encrypt_string(p_pass_plain);
  select id into v_pass_id from usernamev2 where p_user_username = username;
  --v_pass_id := 1;
  select password into v_pass_database from passwords where passid = v_pass_id;
  if (v_pass_database.count <> v_pass_encrypted.count) then
    return 0;
  end if;
  for i in 1..v_pass_database.count
  loop
    if (v_pass_database(i) <> v_pass_encrypted(i)) then
      return 0;
    end if;
  end loop;
  
  return 1;
END;
/
declare
i int;
begin
  i := login_pass('x', 'asdf');
  DBMS_OUTPUT.put_line(i);
end;

describe passwords;
set serveroutput on;


select b.*, g.gname, sg.sgname from books b 
  join genres g on g.booksid = b.id
  join subgenres sg on sg.booksid = b.id order by b.id asc;
----------------------------------------------------------------------

select * from (
  select b.id, b.name, b.isbn, b.nrpages, b.price, b.rating, g.gname, sg.sgname from books b 
    join genres g on g.booksid = b.id
    join subgenres sg on sg.booksid = b.id 
    where b.id not in (
      select distinct booksid from readbooks r where readersid = 22466
    )
    order by b.rating desc
)
where rownum <= 50; -- TOP CARTI NECITITE ORDONATE DUPA RATING
----------------------------------------------------------------------
select * from (
  select b.id, b.name, b.isbn, b.nrpages, b.price, b.rating, g.gname, sg.sgname from books b 
    join genres g on g.booksid = b.id
    join subgenres sg on sg.booksid = b.id 
    where b.id in (
      select booksid from (
        select count('a'), booksid from booksborrowed group by booksid order by 1 desc) where rownum <= 50
    ) and b.id not in (
      select distinct booksid from readbooks r where readersid = 9078
    )
    order by b.rating desc
)
where rownum <= 50; -- TOP CARTI NECITITE ORDONATE DUPA nr imprumuturi
----------------------------------------------------------------------

select distinct booksid from readbooks r where r.readersid = 15;
select * from (
  select b.id, b.name, b.isbn, b.nrpages, b.price, b.rating, g.gname, sg.sgname from books b 
    join genres g on g.booksid = b.id
    join subgenres sg on sg.booksid = b.id 
    where b.id not in (
      select distinct booksid from readbooks r where r.readersid = 15
    ) and ( g.gname in (
      select distinct g.gname from genres g join readbooks rb on rb.booksid = g.BOOKSID 
        where rb.readersid = 15
      ) and sg.sgname in (
      select distinct sg.sgname from subgenres sg join readbooks rb on rb.booksid = sg.BOOKSID 
        where rb.readersid = 15
      )
    )
    order by b.rating desc
)
where rownum <= 50; -- TOP CARTI NECITITE ORDONATE DUPA RATING DIN GENURILE     SAU    SUBGENURILE CITITE

select distinct booksid from readbooks r where r.readersid = 15;
select * from (
  select b.*, g.gname, sg.sgname from books b 
    join genres g on g.booksid = b.id
    join subgenres sg on sg.booksid = b.id 
    where b.id not in (
      select distinct booksid from readbooks r where r.readersid = 15
    ) and ( g.gname in (
      select distinct g.gname from genres g join readbooks rb on rb.booksid = g.BOOKSID 
        where rb.readersid = 15
      ) and sg.sgname in (
      select distinct sg.sgname from subgenres sg join readbooks rb on rb.booksid = sg.BOOKSID 
        where rb.readersid = 15
      )
    )
    order by b.rating desc
)
where rownum <= 50; -- TOP CARTI NECITITE ORDONATE DUPA RATING DIN GENURILE     SI     SUBGENURILE CITITE
----------------------------------------------------------------------


select distinct sg.sgname from subgenres sg join readbooks rb on rb.booksid = sg.BOOKSID 
        where rb.readersid = 15;
        
select b.*, g.sgname from books b join subgenres g on g.booksid = b.id
  join readbooks rb on b.id = rb.booksid
  where rb.readersid = 15;
  

select count('a'), booksid from booksborrowed group by booksid order by 1 desc;
select readersid from readbooks where booksid = 80657; 
select r.booksid, b.* from readbooks r 
join books b on b.id = r.booksid 
where r.readersid = 22466;
  
select * from booksborrowed order by 3;

select b.*, g.gname, sg.sgname from books b 
join genres g on g.booksid = b.id
join subgenres sg on sg.booksid = b.id 
where b.id in (
  select booksid from (
    select count('a'), booksid from booksborrowed group by booksid order by 1 desc) where rownum < 10
);

select count('a'), booksid from booksborrowed group by booksid order by 1 desc;

select count('a') from booksborrowed where booksid = 4429 group by booksid order by 1 desc;

select count('a') from booksborrowed;
select count(*) from subgenres group by booksid order by 1 desc;
-- TOP 30 CARTI DUPA : RATING, NR CITITORI, 
    
    select count(*), readersid from readbooks group by readersid order by 1 desc;

select count('*') as "COUNT" from readers where username = 'a' or '1' = '1' 
and password = Encrypt_string('aasgagfadsgdfa');
select Encrypt_string('aasgagfadsgdfa') from dual;
select * from readers order by 1 desc;
create table charsEncrypted

select * from charsEncrypted;
drop table charsEncrypted;
select ascii(' ') from dual;

select chr(126) from dual;

select b.id as "id", b.name as "Name", b.isbn as "ISBN", b.price as "Price", b.rating as "Rating",
 (a.AFNAME || ' ' || a.ALNAME) as "AuthorName", g.gname as "Genre", sg.sgname as "Subgenre" from books b
join GENRES g on g.booksid = b.id
join SUBGENRES sg on sg.booksid = b.id
join AUTHORS a on a.ID = b.AUTHORID;

select id as "id", id as "id2" from books;

--export table
create or replace procedure export_table(camp IN varchar2) as
   v_cursor_id INTEGER;
   v_ok INTEGER;

   TYPE varr IS varray(100) OF varchar2(255);
    v_column_names varr := varr('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
    v_count int;
    v_constraint_count int;
    v_i int;
    v_name varchar2(255);

   v_id_prof int;
   v_nume_prof varchar2(15);
   v_prenume_prof varchar2(30);

  v_fisier_tabela UTL_FILE.FILE_TYPE;
  v_cursor_id2 NUMBER;
  v_rec_tab     DBMS_SQL.DESC_TAB;
  v_nr_col     NUMBER;
  v_total_coloane     NUMBER;
begin
    v_fisier_tabela := UTL_FILE.FOPEN('MYDIR', camp || '.sql', 'W');
    UTL_FILE.PUTF(v_fisier_tabela, 'DROP TABLE '|| camp || ' CASCADE CONSTRAINTS \n/');
    UTL_FILE.PUTF(v_fisier_tabela, '\n CREATE TABLE '|| camp || ' (');

     v_cursor_id2  := DBMS_SQL.OPEN_CURSOR;
  DBMS_SQL.PARSE(v_cursor_id2 , 'SELECT * FROM ' || camp, DBMS_SQL.NATIVE);
  v_ok := DBMS_SQL.EXECUTE(v_cursor_id2 );
  DBMS_SQL.DESCRIBE_COLUMNS(v_cursor_id2, v_total_coloane, v_rec_tab);

  v_nr_col := v_rec_tab.first;
  IF (v_nr_col IS NOT NULL) THEN
    LOOP
        IF (v_rec_tab.next(v_nr_col) IS NULL) THEN
                UTL_FILE.PUTF(v_fisier_tabela, '\n'|| v_rec_tab(v_nr_col).col_name || ' ' || gettype(v_rec_tab,v_nr_col));
        ELSE
            IF(v_rec_tab(v_nr_col).col_name = 'ID') then
                UTL_FILE.PUTF(v_fisier_tabela, '\n'|| v_rec_tab(v_nr_col).col_name || ' ' || gettype(v_rec_tab,v_nr_col) || ' NOT NULL PRIMARY KEY,');
            else
                UTL_FILE.PUTF(v_fisier_tabela, '\n'|| v_rec_tab(v_nr_col).col_name || ' ' || gettype(v_rec_tab,v_nr_col) || ',');
            end if;
      END IF;
      v_nr_col := v_rec_tab.next(v_nr_col);

      EXIT WHEN (v_nr_col IS NULL);
    END LOOP;
  END IF;
  DBMS_SQL.CLOSE_CURSOR(v_cursor_id2);
  select count(*) into v_constraint_count from user_cons_columns where table_name = camp and position = 1;
  v_constraint_count := v_constraint_count - 1;
  FOR rows in (select * from user_cons_columns where table_name = camp) loop
       if rows.Position = 1 and rows.column_name != 'ID' then
           v_constraint_count := v_constraint_count - 1;
           if(v_constraint_count = 0) then
            UTL_FILE.PUTF(v_fisier_tabela, '\nCONSTRAINT ' || rows.constraint_name || ' FOREIGN KEY (' || rows.column_name || ') REFERENCES ' || SUBSTR(rows.column_name, 0, (LENGTH(ROWS.COLUMN_NAME)-2)) || '(ID)'); --CONSTRAINT fk_Books_AuthorID FOREIGN KEY (AuthorID) REFERENCES Authors(ID)
            else
               UTL_FILE.PUTF(v_fisier_tabela, '\nCONSTRAINT ' || rows.constraint_name || ' FOREIGN KEY (' || rows.column_name || ') REFERENCES ' || SUBSTR(rows.column_name, 0, (LENGTH(ROWS.COLUMN_NAME)-2)) || '(ID),');
            end if;
        end if;
   end loop;
  UTL_FILE.PUTF(v_fisier_tabela, '\n) \n/');


  --INSERT
  select count(*) into v_count from ALL_COL_COMMENTS where TABLE_NAME = camp;
  v_count := v_count / 2;
  v_i := 1;
  for row in (select COLUMN_NAME from ALL_COL_COMMENTS where TABLE_NAME = camp) loop
        v_column_names(v_i):= row.COLUMN_NAME;
        v_i := v_i + 1;
    end loop;


  v_cursor_id := DBMS_SQL.OPEN_CURSOR;
  DBMS_SQL.PARSE(v_cursor_id, 'SELECT * FROM ' || camp, DBMS_SQL.NATIVE);

  for i in 1..v_count loop
      DBMS_SQL.DEFINE_COLUMN(v_cursor_id, i, v_column_names(i), 100);
  end loop;
  v_ok := DBMS_SQL.EXECUTE(v_cursor_id);

  LOOP
     IF DBMS_SQL.FETCH_ROWS(v_cursor_id)>0 THEN
          UTL_FILE.PUTF(v_fisier_tabela, '\nINSERT INTO '||camp||' VALUES(');
         for i in 1..v_count loop
             DBMS_SQL.COLUMN_VALUE(v_cursor_id, i, v_column_names(i));
         end loop;
         for i in 1..v_count loop
         if i+1 > v_count then
            UTL_FILE.PUTF(v_fisier_tabela, v_column_names(i));
                else
            UTL_FILE.PUTF(v_fisier_tabela, v_column_names(i) || ',');
            end if;
         end loop;
         UTL_FILE.PUTF(v_fisier_tabela, ' );');
      ELSE
        EXIT;
      END IF;
      DBMS_OUTPUT.PUT_LINE('');
  END LOOP;

  DBMS_SQL.CLOSE_CURSOR(v_cursor_id);
   UTL_FILE.FCLOSE(v_fisier_tabela);
    end export_table;
/

--get column type function
create or replace function getType(v_rec_tab DBMS_SQL.DESC_TAB, v_nr_col int) return varchar2 as
  v_tip_coloana varchar2(200);
  v_precizie VARCHAR2(40);
begin
     CASE (v_rec_tab(v_nr_col).col_type)
        WHEN 1 THEN v_tip_coloana := 'VARCHAR2'; v_precizie := '(' || v_rec_tab(v_nr_col).col_max_len || ')';
        WHEN 2 THEN v_tip_coloana := 'NUMBER'; v_precizie := '(' || v_rec_tab(v_nr_col).col_precision || ',' || v_rec_tab(v_nr_col).col_scale || ')';
        WHEN 12 THEN v_tip_coloana := 'DATE'; v_precizie := '';
        WHEN 96 THEN v_tip_coloana := 'CHAR'; v_precizie := '(' || v_rec_tab(v_nr_col).col_max_len || ')';
        WHEN 112 THEN v_tip_coloana := 'CLOB'; v_precizie := '';
        WHEN 113 THEN v_tip_coloana := 'BLOB'; v_precizie := '';
        WHEN 109 THEN v_tip_coloana := 'XMLTYPE'; v_precizie := '';
        WHEN 101 THEN v_tip_coloana := 'BINARY_DOUBLE'; v_precizie := '';
        WHEN 100 THEN v_tip_coloana := 'BINARY_FLOAT'; v_precizie := '';
        WHEN 8 THEN v_tip_coloana := 'LONG'; v_precizie := '';
        WHEN 180 THEN v_tip_coloana := 'TIMESTAMP'; v_precizie :='(' || v_rec_tab(v_nr_col).col_scale || ')';
        WHEN 181 THEN v_tip_coloana := 'TIMESTAMP' || '(' || v_rec_tab(v_nr_col).col_scale || ') ' || 'WITH TIME ZONE'; v_precizie := '';
        WHEN 231 THEN v_tip_coloana := 'TIMESTAMP' || '(' || v_rec_tab(v_nr_col).col_scale || ') ' || 'WITH LOCAL TIME ZONE'; v_precizie := '';
        WHEN 114 THEN v_tip_coloana := 'BFILE'; v_precizie := '';
        WHEN 23 THEN v_tip_coloana := 'RAW'; v_precizie := '(' || v_rec_tab(v_nr_col).col_max_len || ')';
        WHEN 11 THEN v_tip_coloana := 'ROWID'; v_precizie := '';
        WHEN 109 THEN v_tip_coloana := 'URITYPE'; v_precizie := '';
      END CASE;
      return v_tip_coloana||v_precizie;
end;
/

DECLARE

BEGIN
 export_table('BOOKS');
END;
/
select * from booksborrowed;

--select * from user_cons_columns where table_name = 'BOOKS';

select count(*) as COUNT from readers 
                where username = '0' or id = '1' and password = Encrypt_string('-') or (id = '1');
                
0' or id = '1

-') or (id = '1



'

select count(*) as "COUNT" from readers where username = 'a' or 1 = '1' and password = Encrypt_string('x') or (1 = '1');

select max(id) from authors;

