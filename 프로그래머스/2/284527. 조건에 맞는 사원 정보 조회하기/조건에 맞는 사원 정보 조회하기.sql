-- 코드를 작성해주세요
select 
sum(a.SCORE) as SCORE
,b.EMP_NO	
,b.EMP_NAME
,b.POSITION
,b.EMAIL
from HR_GRADE a left join HR_EMPLOYEES b
on a.EMP_NO = b.EMP_NO
where a.YEAR = 2022
group by a.EMP_NO
order by SCORE desc
limit 1
;