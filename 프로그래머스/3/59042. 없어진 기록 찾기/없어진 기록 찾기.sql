-- 코드를 입력하세요
SELECT AO.ANIMAL_ID, AO.name
from ANIMAL_INS AI right join ANIMAL_OUTS AO
on AI.ANIMAL_ID = AO.ANIMAL_ID
where 1= 1
and AI.ANIMAL_ID is null
;