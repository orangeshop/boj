-- 코드를 입력하세요
SELECT HOUR(DATETIME) as "HOUR", count(*)	as "COUNT"
from ANIMAL_OUTS
where HOUR(DATETIME) between '9' and '20'
group by HOUR(DATETIME)
order by HOUR(DATETIME)