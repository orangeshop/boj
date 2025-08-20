-- 코드를 입력하세요
with af_table1 as (
    select
    *
    from ONLINE_SALE
    where YEAR(SALES_DATE) = 2022
    and MONTH(SALES_DATE) = 3
),
af_table2 as (
    select
    *
    from OFFLINE_SALE
    where YEAR(SALES_DATE) = 2022
    and MONTH(SALES_DATE) = 3
)

select 
DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
PRODUCT_ID,
USER_ID,
SALES_AMOUNT
from af_table1
UNION ALL
select 
DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
PRODUCT_ID,
NULL as USER_ID,
SALES_AMOUNT
from af_table2
order by SALES_DATE, product_id, user_id
;