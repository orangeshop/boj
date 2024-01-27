-- 코드를 입력하세요
SELECT ai.NAME, ai.DATETIME
from ANIMAL_INS ai left join ANIMAL_OUTS ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
where 1 = 1
and ao.ANIMAL_ID is null
order by ai.DATETIME
limit 3
;