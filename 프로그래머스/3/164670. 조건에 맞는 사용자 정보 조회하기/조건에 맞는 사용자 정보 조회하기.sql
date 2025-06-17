-- 코드를 입력하세요
SELECT 
b.USER_ID,	
b.NICKNAME, 
concat(b.CITY," ",b.STREET_ADDRESS1," ", b.STREET_ADDRESS2) as '전체주소',
concat(
    SUBSTR(b.TLNO, 1,3),
    '-', 
    SUBSTR(b.TLNO, 4,4),
    '-', 
    SUBSTR(b.TLNO, 8,4)
) as '전화번호'
from USED_GOODS_BOARD a join USED_GOODS_USER b
on a.WRITER_ID = b.USER_ID
group by a.WRITER_ID
having count(*) >= 3
order by a.WRITER_ID desc

# select * from USED_GOODS_BOARD
# group by WRITER_ID
# having count(*) >= 3

# xlqpfh2
# xlaortm1	
# spdlqj12	
# s2s2123	
# miyeon89	
# kwag98	
# hwahwa2		
# hong02	
# hoho1112	
# hakju88	
# dhfkzmf09

