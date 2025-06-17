-- 코드를 입력하세요
SELECT concat ('/home/grep/src/', a.BOARD_ID , '/', b.FILE_ID,b.FILE_NAME,b.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD a inner join USED_GOODS_FILE b
on a.BOARD_ID = b.BOARD_ID
where a.VIEWS like (
    select a.views 
    from USED_GOODS_BOARD a 
    order by a.VIEWS desc 
    limit 1
)
order by b.FILE_ID desc

