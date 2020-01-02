--select FIRST_NAME, LAST_NAME, EMAIL, salary, commission_pct 
--from employees 
--where lower(first_name) like 'a%' AND commission_pct is NULL
--order by 2


--select * from employees e inner join departments d on e.department_id=d.department_id where d.department_name = 'IT'

--select * from employees where department_id 
--in (select department_id from departments where location_id 
--in (select location_id from locations where city ='&&city' and locations.state_province = '&state_province'))

--select * from employees where employee_id in (select employee_id from job_history)

--select round(avg(salary),1),department_id from employees group by department_id

--select employee_id, count(employee_id) promotion
--from job_history
--group by employee_id
--order by employee_id



--Comments
--A%
--A__
--A_B
--is null
--is not null
