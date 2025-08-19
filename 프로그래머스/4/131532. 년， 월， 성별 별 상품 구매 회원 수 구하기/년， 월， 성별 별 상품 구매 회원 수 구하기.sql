-- 코드를 입력하세요




SELECT
YEAR(b.SALES_DATE) as YEAR
, MONTH(b.SALES_DATE) as MONTH
, a.GENDER
, count(DISTINCT a.USER_ID) as USERS
from USER_INFO a join ONLINE_SALE b
on a.USER_ID = b.USER_ID
where year(b.SALES_DATE) = 2022
and a.GENDER is not null
group by MONTH, a.GENDER
order by YEAR, MONTH, a.GENDER
;