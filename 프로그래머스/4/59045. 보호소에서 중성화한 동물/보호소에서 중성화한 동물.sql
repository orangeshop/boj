-- 코드를 입력하세요
SELECT ai.ANIMAL_ID, ai.ANIMAL_TYPE, ai.name
from ANIMAL_INS ai left join ANIMAL_OUTS ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
where 1=1
and ai.SEX_UPON_INTAKE in('Intact Male', 'Intact Female')
and ao.SEX_UPON_OUTCOME in('Neutered Male', 'Spayed Female')
;