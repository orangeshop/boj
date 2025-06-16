-- 코드를 입력하세요
SELECT count(*) as 'USERS'
from USER_INFO
where AGE is not null
and age >= 20 and age <= 29
and YEAR(JOINED) = 2021;