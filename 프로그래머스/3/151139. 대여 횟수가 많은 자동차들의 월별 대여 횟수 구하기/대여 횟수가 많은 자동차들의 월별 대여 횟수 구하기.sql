-- 코드를 입력하세요
with d_table as (
    SELECT 
    CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    group by CAR_ID
    having count(HISTORY_ID) >= 5
    
)

select  
month(a.START_DATE) as MONTH,
a.CAR_ID,
count(a.CAR_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY a right join d_table b
on a.CAR_ID = b.CAR_ID
WHERE a.START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
group by CAR_ID,MONTH
order by MONTH, CAR_ID desc
;

