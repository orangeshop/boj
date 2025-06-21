-- 코드를 입력하세요
SELECT 
distinct CART_ID
from CART_PRODUCTS
where NAME in ('Milk','Yogurt')
group by CART_ID
having count(distinct name) >= 2
order by CART_ID