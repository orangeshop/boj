-- 코드를 작성해주세요
select
b.EMP_NO,
b.EMP_NAME,
case
    when avg(c.SCORE) >= 96 then "S"
    when avg(c.SCORE) >= 90 then "A"
    when avg(c.SCORE) >= 80 then "B"
    else "C"
end
as GRADE
,
case
    when avg(c.SCORE) >= 96 then b.sal * 0.2
    when avg(c.SCORE) >= 90 then b.sal * 0.15
    when avg(c.SCORE) >= 80 then b.sal * 0.1
    else 0
end
as BONUS
from HR_DEPARTMENT a inner join HR_EMPLOYEES b 
on a.DEPT_ID = b.DEPT_ID
inner join HR_GRADE c
on b.EMP_NO = c.EMP_NO

group by c.EMP_NO

order by b.EMP_NO

;