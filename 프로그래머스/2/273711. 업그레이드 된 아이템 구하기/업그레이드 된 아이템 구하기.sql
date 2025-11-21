-- 코드를 작성해주세요
with af_table as(
    select 
    Item_id,
    Item_name,
    Rarity,
    price
    from ITEM_INFO
    where RARITY like "RARE"
)
# select * from af_table;

select 
a.ITEM_ID,	
a.ITEM_NAME,	
a.RARITY 
# *
from ITEM_INFO a right join ITEM_TREE b
on a.ITEM_ID = b.ITEM_ID
right join af_table c
on b.PARENT_ITEM_ID = c.Item_id
where b.PARENT_ITEM_ID is not null
order by a.ITEM_ID desc
;


