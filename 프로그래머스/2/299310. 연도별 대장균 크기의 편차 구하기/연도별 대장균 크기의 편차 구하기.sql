-- 코드를 작성해주세요

with t1 as(
    select year(DIFFERENTIATION_DATE) as YEAR, max(SIZE_OF_COLONY) as size from ECOLI_DATA
    group by year(DIFFERENTIATION_DATE)
)

select 
YEAR(a.DIFFERENTIATION_DATE) as YEAR,
b.size - a.SIZE_OF_COLONY as YEAR_DEV
,a.id as ID
from ECOLI_DATA a join t1 b
on YEAR(a.DIFFERENTIATION_DATE) = b.YEAR
order by YEAR, YEAR_DEV
;