-- 코드를 입력하세요
SELECT a.FLAVOR
from FIRST_HALF a inner join ICECREAM_INFO b
on a.FLAVOR = b.FLAVOR
where INGREDIENT_TYPE = 'fruit_based'
and a.TOTAL_ORDER >= 3000
order by a.TOTAL_ORDER desc