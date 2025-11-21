-- 코드를 작성해주세요
with af_table as(
    select 
    a.ITEM_NAME
    from ITEM_INFO a join ITEM_TREE b
    on a.ITEM_ID = b.PARENT_ITEM_ID
    group by a.ITEM_NAME
)

# select * from af_table

select
ITEM_ID,
ITEM_NAME,
RARITY
from ITEM_INFO
where ITEM_NAME not in (
    select * from af_table
)
order by ITEM_ID desc
;