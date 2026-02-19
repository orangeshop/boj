-- 코드를 입력하세요
SELECT
a.ANIMAL_ID,
a.NAME
from ANIMAL_OUTS a join ANIMAL_INS b
on a.ANIMAL_ID = b.ANIMAL_ID
order by (b.DATETIME - a.DATETIME)
limit 2
;