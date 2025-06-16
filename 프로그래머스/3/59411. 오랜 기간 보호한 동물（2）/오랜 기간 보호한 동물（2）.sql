-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.name

from ANIMAL_INS a inner join ANIMAL_OUTS b
on a.ANIMAL_ID = b.ANIMAL_ID
order by a.DATETIME - b.DATETIME
limit 2