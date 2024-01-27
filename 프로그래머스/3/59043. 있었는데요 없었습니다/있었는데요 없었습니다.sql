-- 코드를 입력하세요
SELECT ai.ANIMAL_ID, ai.NAME 
from ANIMAL_INS ai left join ANIMAL_OUTS ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
where 1 =1
and ai.DATETIME > ao.DATETIME
and ao.name is not null
order by ai.DATETIME
;