desc members;
desc lendings;
desc user_objects;
desc user_tables;

CREATE TABLE artist (
    aid int not null,
    name varchar(255),
    style varchar(255)
);

CREATE TABLE songs (
    sid int,
    name varchar(255),
    duration int,
    genre varchar(255)
);


ALTER TABLE artist
ADD PRIMARY KEY (aid);

ALTER TABLE songs
ADD PRIMARY KEY (sid);

insert into songs values(1,'Gm',23,'relax');

insert into songs values(2,'Gn',43,'sad');

insert into artist VALUES(1,'jubin','chill');

insert into artist values(2,'sonu','dance');

select * from artist;

select * from songs;

alter table artist add constraint uq_name unique (name);

create SEQUENCE seq3_20 
    MINVALUE 1
    MAXVALUE 20
    start with 3
    INCREMENT by 1
    cache 20;
    
    
-- use seq3_20 now instead of inserting vaules manually



-- select e.name d.mob  from employee e join department d using (department_id);
    
select e.employee_id,e.FIRST_NAME,m.manager_id,m.FIRST_NAME
    from employees e, employees m
    where m.employee_id=e.manager_id order by m.manager_id;

--select e.employee_id,e.FIRST_NAME,m.manager_id,m.FIRST_NAME
--    from employees e, employees m
--    where e.employee_id=m.manager_id;


desc employees;


--Q2.
select FIRST_NAME, HIRE_DATE from employees where HIRE_DATE between '01-JAN-2002' and '31-DEC-2005' order by hire_date;

SELECT FIRST_NAME, HIRE_DATE
   FROM employees
   WHERE EXTRACT(YEAR FROM
   TO_DATE(hire_date, 'DD-MON-RR')) >= 2002 
   AND EXTRACT(YEAR FROM
   TO_DATE(hire_date, 'DD-MON-RR')) <= 2005
   ORDER BY hire_date;
   
   
--Q3.
desc employees;
select FIRST_NAME,HIRE_DATE from employees where  JOB_ID='IT_PROG' OR JOB_ID='SA_REP';

--Q4.
select FIRST_NAME, HIRE_DATE from employees where EXTRACT(YEAR FROM
   TO_DATE(hire_date, 'DD-MON-RR')) >= 2008;
   
--Q5.
select * from employees where employee_id=150 or employee_id=160;

--Q6.
select FIRST_NAME, SALARY, COMMISSION_PCT, HIRE_DATE from employees where SALARY <= 10000;

-Q7.
select JOB_TITLE;


-Q8.
select FIRST_NAME,round(SALARY,-3) from employees


-Q9.
select * from JOBS order by JOB_Title desc;

-Q10.
select * from employees where FIRST_NAME LIKE 'S%' OR LAST_NAME LIKE 'S%';


-Q11.
select * from employees where EXTRACT(MONTH FROM
   TO_DATE(hire_date, 'DD-MON-RR')) =5;
   
-Q12.
select * from employees where COMMISSION_PCT is null and salary >=5000 and salary<=10000 and department_id =30;

-Q13.
select FIRST_NAME, EXTRACT(MONTH FROM hire_date )+1 from employees;


-Q14.
select FIRST_NAME, EXTRACT(YEAR FROM sysdate)-EXTRACT(YEAR FROM  hire_date) from employees;

-Q15.
select first_name from employees where EXTRACT(YEAR FROM hire_date)=2001;

-Q16.
Select INITCAP(first_name) from employees;

-Q17.
select
   regexp_replace(
     job_title,
     '(((\w+)\s){1}).*',  -- Change 4 to wanted number of words here!
     '\1'
   ) from jobs;
   
   
-Q18.
select length(first_name) from employees where instr(last_name,'b',3) is not null;


--Q19.
select UPPER(first_name), lower(email) from employees where first_name=email;

--Q20.
select * from employees where EXTRACT(YEAR FROM sysdate)= EXTRACT(YEAR FROM  hire_date)

--q21.
--select  EXTRACT(YEAR FROM sysdate)-EXTRACT(YEAR FROM '01-JAN-2001') from dual; 
select sysdate-to_date('2001-01-01','yyyy-mm-dd') from dual;

--q22.



--q23.

select manager_id, count(employee_id)from employees group by manager_id;


---q24.
--select e.employee_id, j.enddate from employees e inner join JOB_HISTORY j where e.employee_id  = j.employee_id;
select employee_id, end_date from job_history;


--q25.
select count(employee_id) from employees where (EXTRACT(DAY FROM  hire_date))>15 ;


--q26
select country_id, count(city) from locations group by country_id;


--q27
select avg(salary) from employees where commission_pct is not null group by department_id;

--q28
select job_id, count(employee_id), max(salary)-min(salary) from employees group by (job_id);

--q29
select job_id from employees having avg(salary)>=10000 group by job_id;

--q30
select extract(YEAR from hire_date) from employees having count (employee_id)>10 group by  extract(YEAR from hire_date);

--q31


--q32


--q33
select job_id ;


--q34
select department_id, extract(YEAR from hire_date), count(employee_id) from employees group by department_id,extract(YEAR from hire_date);



--q35
select department_id,manager_id from employees group by manager_id,department_id having count(employee_id)>5;

--q40
select department_name,count(employee_id) from departments,employees 
where departments.department_id = employees.department_id group by department_name; 

--q42
select d.department_name, e.first_name from departments d,employees e where d.manager_id=e.employee_id;

--q43 not done
selectd d.departmentname, e.first_name, l.city from
department d, employees e, locations l where e.employee_id=d.manager_id and  d.location_id = l.location_id;

--q44
select c.country_name,l.city,d.department_name from COUNTRIES c,DEPARTMENTS d, LOCATIONS l
where c.COUNTRY_ID=l.country_id and l.location_id = d.location_id;

--q45

--q46

--q47

--q48

--q49

--q50
select d.Department_name, e.first_name, e.salary from Departments d, Employees e 
 where d.manager_id=e.manager_id and EXTRACT(YEAR FROM sysdate)-EXTRACT(YEAR FROM  e.hire_date)>=5;
 
 
-- q51
select e.first_name from employees e, employees b where e.manager_id=b.employee_id and e.hire_date>b.hire_date; 

--q52
select e.first_name, j.job_title from employees e, job_history jh, jobs j
where  e.job_id=j.job_title and jh.start_date-jh.end_date >180;

--q53
select e.first_name 