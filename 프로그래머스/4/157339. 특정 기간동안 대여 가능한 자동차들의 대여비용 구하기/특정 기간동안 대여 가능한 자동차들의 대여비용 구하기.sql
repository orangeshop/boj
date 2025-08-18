-- 코드를 입력하세요
with af_table as(
    select
    a.car_id,
    b.DISCOUNT_RATE,
    b.CAR_TYPE,
    ROUND(a.DAILY_FEE * 30 * (1 - b.DISCOUNT_RATE / 100),0) AS FEE
    from CAR_RENTAL_COMPANY_CAR a join CAR_RENTAL_COMPANY_DISCOUNT_PLAN b
    on a.CAR_TYPE = b.CAR_TYPE
    where b.DURATION_TYPE = '30일 이상'
    AND a.CAR_TYPE IN ('세단', 'SUV')
    
)

select
a.CAR_ID
,a.CAR_TYPE
, a.FEE
from af_table a
where NOT EXISTS (
    select 
    1
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY b
    where a.CAR_ID = b.CAR_ID
    AND b.START_DATE < '2022-12-01'
    AND b.END_DATE   >= '2022-11-01'
)
AND a.FEE >= 500000
    AND a.FEE < 2000000
ORDER BY a.FEE DESC, a.CAR_TYPE ASC, a.CAR_ID DESC;



;