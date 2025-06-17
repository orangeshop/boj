-- 코드를 작성해주세요
select a.ITEM_ID,	a.ITEM_NAME, 	a.RARITY
from ITEM_INFO a join ITEM_TREE b
on a.ITEM_ID = b.ITEM_ID
where b.PARENT_ITEM_ID in (
    select ITEM_ID
    from ITEM_INFO
    where RARITY = 'RARE'
)
order by ITEM_ID desc