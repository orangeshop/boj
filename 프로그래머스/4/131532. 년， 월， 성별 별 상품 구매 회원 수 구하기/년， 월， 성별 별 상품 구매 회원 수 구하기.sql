-- 코드를 입력하세요
with t1 as(
    select 
    a.ONLINE_SALE_ID,
    a.USER_ID,
    a.PRODUCT_ID,	
    a.SALES_AMOUNT,	
    a.SALES_DATE,
    b.GENDER,
    b.AGE,
    b.JOINED
    from ONLINE_SALE a join USER_INFO b
    on a.USER_ID = b.USER_ID
)


SELECT 
YEAR(SALES_DATE) as YEAR, 
MONTH(SALES_DATE) as MONTH,
GENDER,
count(distinct USER_ID) as USERS
from t1
where GENDER is not null
group by YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER
order by YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER

# select * from t1

;




