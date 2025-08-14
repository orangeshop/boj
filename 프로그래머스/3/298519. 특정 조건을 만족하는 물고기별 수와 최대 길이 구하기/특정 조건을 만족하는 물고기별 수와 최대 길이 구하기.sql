-- 코드를 작성해주세요
with FISH_INFO_a as(
    select 
        ID,
        case
            when LENGTH is null then 10
            else LENGTH
        end as LENGTH
    from FISH_INFO
)


select 
count(a.ID) as FISH_COUNT,
(
    max(b.LENGTH) 
    
) as MAX_LENGTH,
a.FISH_TYPE
from FISH_INFO a left join FISH_INFO_a b
on a.ID = b.ID
group by a.FISH_TYPE
having avg(b.LENGTH) > 33
order by a.FISH_TYPE
;