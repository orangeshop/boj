-- 코드를 작성해주세요
with af_table as(
    select 
    max(SIZE_OF_COLONY) as maxNum,
    year(DIFFERENTIATION_DATE) as YEAR
    from ECOLI_DATA
    group by year(DIFFERENTIATION_DATE)
)

select 
b.YEAR,
b.maxNum - a.SIZE_OF_COLONY as YEAR_DEV,
a.ID
from ECOLI_DATA a left join af_table b
on year(a.DIFFERENTIATION_DATE) = b.YEAR
order by b.YEAR, YEAR_DEV
;