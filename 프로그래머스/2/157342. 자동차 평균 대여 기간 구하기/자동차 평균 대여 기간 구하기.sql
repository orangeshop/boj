-- 코드를 입력하세요
with af_table as(
    select 
    car_id,
    DATEDIFF(END_DATE, START_DATE) + 1 as AVERAGE_DURATION
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
)

SELECT 
car_id as CAR_ID,
round(avg(AVERAGE_DURATION),1) as AVERAGE_DURATION
from af_table
group by car_id
having avg(AVERAGE_DURATION) >= 7
order by AVERAGE_DURATION desc,CAR_ID desc
;