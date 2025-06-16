-- 코드를 입력하세요
SELECT a.car_id
from CAR_RENTAL_COMPANY_CAR a left join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
on a.CAR_ID = b.CAR_ID
where month(b.START_DATE) = 10
and a.CAR_TYPE = "세단"
group by a.car_id
order by a.CAR_ID desc