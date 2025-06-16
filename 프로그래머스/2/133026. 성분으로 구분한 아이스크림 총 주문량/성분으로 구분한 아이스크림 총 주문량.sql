-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, sum(f.TOTAL_ORDER) as 'TOTAL_ORDER'
# select * 
from FIRST_HALF f right join ICECREAM_INFO i
on f.FLAVOR = i.FLAVOR
group by INGREDIENT_TYPE