-- 코드를 입력하세요
# SELECT USER_ID,	GENDER,	AGE, date_format(JOINED, '%Y-%m-%d') as JOINED

select count(*) as USERS
from USER_INFO
where age between 20 and 29
and year(JOINED) like '2021'
;