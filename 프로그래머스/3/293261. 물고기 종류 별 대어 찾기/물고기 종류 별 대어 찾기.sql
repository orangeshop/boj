-- 코드를 작성해주세요

with af_table as(
    select 
    FISH_TYPE,
    max(LENGTH) as LENGTH
    from FISH_INFO
    group by FISH_TYPE
)

# select * from af_table;

select
a.ID
,b.FISH_NAME
,c.LENGTH
from FISH_INFO a join FISH_NAME_INFO b
on a.FISH_TYPE = b.FISH_TYPE
join af_table c
on a.FISH_TYPE = c.FISH_TYPE
where a.LENGTH = c.LENGTH
order by a.ID 
;