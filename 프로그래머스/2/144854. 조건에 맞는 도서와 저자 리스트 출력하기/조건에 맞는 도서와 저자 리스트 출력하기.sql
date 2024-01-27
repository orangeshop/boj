-- 코드를 입력하세요
SELECT b.book_id, a.author_name, date_format(b.published_date, '20%y-%m-%d') as 'PUBLISHED_DATE'
from Book b left join author a
on b.AUTHOR_ID = a.AUTHOR_ID
where 1 =1 
and b.category like '경제'
order by b.published_date
;