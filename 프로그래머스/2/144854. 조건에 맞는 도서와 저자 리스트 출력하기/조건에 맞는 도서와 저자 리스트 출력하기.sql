-- 코드를 입력하세요
SELECT 
a.BOOK_ID,
b.AUTHOR_NAME,
Date_format(a.PUBLISHED_DATE, "%Y-%m-%d") as PUBLISHED_DATE
from book a join AUTHOR b
on a.AUTHOR_ID = b.AUTHOR_ID
where a.CATEGORY like '경제'
order by PUBLISHED_DATE 