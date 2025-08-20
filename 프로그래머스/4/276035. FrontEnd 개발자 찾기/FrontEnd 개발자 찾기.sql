-- 코드를 작성해주세요
with af_table as (
    select 
    Sum(code) 
    from SKILLCODES
    where CATEGORY like "Front End"
)

select 
ID,
EMAIL,
FIRST_NAME,
LAST_NAME
from DEVELOPERS
where SKILL_CODE & (select * from af_table)
order by ID
;