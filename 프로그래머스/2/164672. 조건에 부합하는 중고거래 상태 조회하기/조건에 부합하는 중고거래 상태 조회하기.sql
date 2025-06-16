-- 코드를 입력하세요
SELECT BOARD_ID,	WRITER_ID,	TITLE,	PRICE,	(
    case
        when STATUS like "SALE" then '판매중'
        when STATUS like "RESERVED" then '예약중'
        else '거래완료'  
    end
) as 'STATUS'
from USED_GOODS_BOARD
where date(CREATED_DATE) = '2022-10-05'
order by BOARD_ID desc