-- 코드를 입력하세요
SELECT a.AUTHOR_ID,	b.AUTHOR_NAME,	a.CATEGORY
, sum(c.SALES * a.PRICE) as 'TOTAL_SALES'
from BOOK a 
inner join AUTHOR b
    on a.AUTHOR_ID = b.AUTHOR_ID
inner join BOOK_SALES c
    on a.BOOK_ID = c.BOOK_ID
    
where Year(SALES_DATE) = 2022
and month(SALES_DATE) = 01
group by a.AUTHOR_ID,b.AUTHOR_NAME, a.CATEGORY
order by a.AUTHOR_ID , a.CATEGORY desc


# select * from BOOK
# book_id	category	author_id	price	published_date
# 1	경제	1	9000	2020-01-10 00:00:00
# 2	경제	1	12000	2021-06-10 00:00:00
# 3	인문	1	11000	2021-10-24 00:00:00
# 4	소설	2	7500	2020-03-03 00:00:00
# 5	기술	3	11000	2020-02-17 00:00:00
# 6	기술	3	8000	2020-04-29 00:00:00
# 7	생활	3	9500	2021-08-20 00:00:00

# select * from AUTHOR
# author_id	author_name
# 1	홍길동
# 2	김영호
# 3	김수진


# select * from BOOK_SALES