-- 코드를 입력하세요
SELECT P.PRODUCT_CODE, sum(P.price * o.SALES_AMOUNT) as `SALE`
from PRODUCT P left join OFFLINE_SALE o
on p.PRODUCT_ID = o.PRODUCT_ID
group by PRODUCT_CODE
order by `SALE` desc, P.PRODUCT_CODE
;