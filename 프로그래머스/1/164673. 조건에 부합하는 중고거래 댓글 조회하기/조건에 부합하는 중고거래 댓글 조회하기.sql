-- 코드를 입력하세요
SELECT a.Title, b.BOARD_ID, b.REPLY_ID, b.WRITER_ID, b.CONTENTS, DATE_FORMAT(b.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE 
from USED_GOODS_BOARD a inner join USED_GOODS_REPLY b
on a.BOARD_ID = b.BOARD_ID
where year(a.CREATED_DATE) = 2022
and month(a.CREATED_DATE) = 10
order by b.CREATED_DATE asc, a.Title asc

# ---
# select b.title,
#        b.board_id,
#        r.reply_id,
#        r.writer_id,
#        r.contents,
#        date_format(r.created_date, '%Y-%m-%d')
# from used_goods_board b inner join used_goods_reply r on b.board_id=r.board_id
# -- 둘 다 사용 가능
# where year(b.created_date)=2022 and month(b.created_date)=10

# --
# order by r.created_date asc,
#          b.title asc

# ---