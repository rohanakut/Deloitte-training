

1. select job_title,min_salary from jobs 
where min_salary>10000;

2. SELECT first_name, hire_date from employees
where EXTRACT(YEAR FROM hire_date)
between 2002 and 2005;

3.SELECT first_name, hire_date from employees
where job_id = 'IT_PROG' 
or job_id = 'SA_REP';

4. SELECT first_name, hire_date from employees
where EXTRACT(YEAR FROM hire_date)>2007;

5. select * from employees 
where employee_id between 150 and 160;

6. select first_name, salary, commission_pct, hire_date from employees
where salary<10000;

7. select max_salary-min_salary from jobs
where max_salary>=10000 and max_salary<20000

8. select first_name, round(salary,-2) from employees;

9. select * from jobs
order by job_title desc;

10. select first_name, last_name from employees
where first_name like 's%' or first_name like '%s' or last_name like 's%' or last_name like '%s';

11.SELECT first_name, hire_date from employees
where EXTRACT(month FROM hire_date) = 05;

12. select * from employees
where commission_pct = null and
salary between 5000 and 10000 and 
department_id = 30;

13. select first_name, extract(month from hire_date)+1 from employees

14 select first_name, (sysdate-hire_date)/365 from employees;

15. select first_name from employees
where extract(year from hire_date)=2001;

16. select INITCAP(first_name), INITCAP(last_name) from employees;

17. select regexp_replace(
     job_title,
     '(((\w+)\s){1}).*',  -- Change 4 to wanted number of words here!
     '\1'
   ) from jobs;
   
18. select length(first_name) from employees
where instr(last_name,'b',3) is not null;

19. select upper(first_name), lower(email) from employees
where lower(first_name) = lower(email);

20. select first_name from employees 
where extract(year from hire_date) = extract(year from sysdate);

21. select sysdate - to_date('2001-01-01', 'yyyy-mm-dd') from dual;

22. select count(first_name) from employees
where extract(year from hire_date) = extract (year from sysdate);

23. select manager_id, count(first_name) from employees
group by manager_id;

24. select employee_id, end_date from job_history;

25. select count(first_name) from employees
where extract( day from hire_date)>15
group by(extract(month from hire_date));

26. select country_id, count(country_id) from locations
group by(country_id);

27. select avg(salary) from employees
where commission_pct is not null
group by department_id;

28. select job_id, sum(salary),max(salary)-min(salary), count (employee_id) from employees
group by (job_id);

29. select job_id from employees
having avg(salary)>10000
group by(job_id);

30.
select extract(year from hire_date) from employees
having count(employee_id)>10
group by (extract(year from hire_date));

31.select department_id from employees
having count (commission_pct)>5 
group by department_id;

32. 
select employee_id from job_history
having count(employee_id)>1
group by employee_id;

33.
select job_id from employees
group by(job_id)
having count(employee_id)>3 ;

34. 
select department_id,extract(year from hire_date) , count(employee_id) from employees
group by department_id,extract(year from hire_date) ;

35.
select department_id, manager_id from employees
group by manager_id, department_id
having count(employee_id)>5;

40.
select department_name, count(employee_id) from departments,employees
where departments.department_id = employees.department_id
group  by department_name;

41.
select jobs.job_title, employees.employee_id, job_history.end_date-job_history.start_date from jobs, employees, job_history
where (employees.job_id = jobs.job_id and employees.department_id = 30)
and (job_history.department_id = employees.department_id and employees.department_id = 30);

42.
select b.department_name, a.first_name from employees a, departments b
where b.manager_id = a.employee_id;

43.
select a.department_name, b.first_name as "Manager 1st Name", c.city
from departments a, employees b, locations c where a.manager_id = b.employee_id and a.location_id = c.location_id;

44.
select a.country_name, b.city, c.department_name from countries a, locations b, departments c where a.country_id = b.country_id and c.location_id = b.location_id;


45. 
select a.job_title, b.department_name, c.last_name from jobs a, departments b, employees c
where a.job_id = c.job_id and b.department_id = c.department_id and (extract(year from c.hire_date) between 2000 and 2005);

46.
select job_title, avg(salary) from employees,jobs
where employees.job_id = jobs.job_id
group by jobs.job_title;

47. 
select a.job_title, b.first_name, (a.max_salary - b.salary) from jobs a, employees b where a.job_id = b.job_id;

48.
select a.last_name, b.job_title from employees a, jobs b
where a.job_id = b.job_id and
a.commission_pct is not null and a.department_id = 30;

49.
select a.* from jobs a, employees b 
where b.job_id = a.job_id and 
b.salary > 15000;

50. 
select a.department_name, b.first_name, b.salary from departments a, employees b
where a.manager_id = b.manager_id
and extract(year from sysdate)-extract(year from hire_date)>5;

51. 
select a.first_name, a.last_name from employees a, employees b
where a.manager_id = b.employee_id and
a.hire_date > b.hire_date;

52.
select a.first_name, b.job_title from employees a, jobs b, job_history c
where a.job_id = b.job_id and b.job_id  =c.job_id and (c.end_date - c.start_date)<180;

53.
select a.first_name, b.country_name from employees a, countries b, departments c, locations d
where a.department_id = c.department_id and c.location_id = d.location_id and d.country_id =b.country_id;
