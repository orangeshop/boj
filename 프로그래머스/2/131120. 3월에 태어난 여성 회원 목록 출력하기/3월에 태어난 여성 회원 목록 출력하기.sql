-- 코드를 입력하세요
select MEMBER_ID, MEMBER_NAME, GENDER, Date_format(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
from MEMBER_PROFILE
where TLNO is not null
and month(DATE_OF_BIRTH) = 3
and GENDER = 'W'
order by MEMBER_ID