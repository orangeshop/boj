-- 코드를 입력하세요
SELECT CATEGORY, sum(SALES) as "TOTAL_SALES"
from BOOK b left join BOOK_SALES s
on b.BOOK_ID = s.BOOK_ID
where year(s.SALES_DATE) = 2022
and month(s.SALES_DATE) = 1
group by CATEGORY
order by CATEGORY

# select * from book;

# select * from BOOK_SALES;