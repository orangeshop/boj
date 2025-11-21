-- 코드를 작성해주세요



select
a.ID,
b.FISH_NAME,
a.Length
from FISH_INFO a join FISH_NAME_INFO b
on a.FISH_TYPE = b.FISH_TYPE
where (a.FISH_TYPE, a.Length) in (
    select FISH_TYPE, max(LENGTH)
    from FISH_INFO
    group by FISH_TYPE
)
order by a.id
;