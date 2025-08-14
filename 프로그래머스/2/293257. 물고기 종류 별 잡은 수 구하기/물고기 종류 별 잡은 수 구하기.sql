-- 코드를 작성해주세요
select 
count(a.FISH_TYPE) as "FISH_COUNT", 
(select FISH_NAME from FISH_NAME_INFO where a.FISH_TYPE like FISH_TYPE) as "FISH_NAME"
from FISH_INFO a
group by a.FISH_TYPE
order by count(a.FISH_TYPE) desc
;