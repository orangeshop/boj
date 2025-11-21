-- 코드를 작성해주세요

select
# *
count(*) as FISH_COUNT
from FISH_INFO a join FISH_NAME_INFO b
on a.FISH_TYPE = b.FISH_TYPE
where b.FISH_NAME like "BASS"
or b.FISH_NAME like "SNAPPER"