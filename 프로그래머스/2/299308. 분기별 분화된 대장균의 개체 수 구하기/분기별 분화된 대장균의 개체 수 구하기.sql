-- 코드를 작성해주세요
select 

(
    case
        when 1 <= month(DIFFERENTIATION_DATE) and month(DIFFERENTIATION_DATE) < 4 then '1Q'
        when 4 <= month(DIFFERENTIATION_DATE) and month(DIFFERENTIATION_DATE) < 7 then '2Q'
        when 7 <= month(DIFFERENTIATION_DATE) and month(DIFFERENTIATION_DATE) < 10 then '3Q'
        else '4Q'
    end 
) as QUARTER,
count(*) as ECOLI_COUNT
from ECOLI_DATA
group by QUARTER
order by QUARTER;