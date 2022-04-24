REM   Script: Session 01_Activity2
REM   Activity2

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12);

SELECT 1 FROM DUAL;

SELECT * from saleman;

SELECT * from salesman;

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * from salesman;

DELETE * from SALESMAN where SALESMAN_ID=5002;

DELETE * from salesman where SALESMAN_ID=5002;

SELECT * from salesman;

SELECT SALESMAN_ID,SALESMAN_NAME,SALESMAN_CITY,COMMISSION,COUNT(*) as frequency from salesman 
group by SALESMAN_ID,SALESMAN_NAME,SALESMAN_CITY,COMMISSION having frequency>1;

SELECT SALESMAN_ID,SALESMAN_NAME,SALESMAN_CITY,COMMISSION,COUNT(*) as frequency from salesman 
group by SALESMAN_ID,SALESMAN_NAME,SALESMAN_CITY,COMMISSION having COUNT(*)>1;

SELECT SALESMAN_ID,SALESMAN_NAME,SALESMAN_CITY,COMMISSION,COUNT(*) as frequency from salesman 
group by SALESMAN_ID,SALESMAN_NAME,SALESMAN_CITY,COMMISSION;

SELECT SALESMAN_ID,SALESMAN_NAME,SALESMAN_CITY,COMMISSION,COUNT(*) as frequency from salesman 
group by SALESMAN_ID,SALESMAN_NAME,SALESMAN_CITY,COMMISSION having count(*)=1;

DELETE * from salesman where SALESMAN_ID=5002;

SELECT * from salesman;

DELETE FROM salesman WHERE SALESMAN_ID NOT IN (SELECT MAX(SALESMAN_ID) FROM salesman GROUP BY SALESMAN_ID,SALESMAN_NAME,SALESMAN_CITY,COMMISSION);

SELECT * from salesman;

DELETE from salesman where SALESMAN_ID=5002;

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

SELECT * from salesman;

