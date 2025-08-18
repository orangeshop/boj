-- 코드를 입력하세요

with af_table as(
    select
    a.USER_ID,	
    a.GENDER,	
    a.AGE,	
    a.JOINED,
    b.ONLINE_SALE_ID,
    b.PRODUCT_ID,
    b.SALES_AMOUNT,
    b.SALES_DATE
    from USER_INFO a join ONLINE_SALE b
    on a.USER_ID = b.USER_ID
    where year(a.JOINED) = 2021
)
,
af2_table as(   
    select
    count(*) 
    from USER_INFO
     where year(JOINED) = 2021
)


select 
year(SALES_DATE) as YEAR,
month(SALES_DATE) as MONTH,
count(DISTINCT USER_ID) as PURCHASED_USERS,
round(count(DISTINCT USER_ID)/(select * from af2_table),1) as PUCHASED_RATIO
from af_table
group by month(SALES_DATE)
order by YEAR, MONTH
;