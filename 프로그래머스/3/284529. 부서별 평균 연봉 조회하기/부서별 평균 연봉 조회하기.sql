-- 코드를 작성해주세요
select
a.DEPT_ID,
a.DEPT_NAME_EN,
round(avg(b.sal),0) as "AVG_SAL"
from HR_DEPARTMENT a right join HR_EMPLOYEES b
on a.DEPT_ID = b.DEPT_ID
group by b.DEPT_ID
order by avg(b.SAL) desc
;