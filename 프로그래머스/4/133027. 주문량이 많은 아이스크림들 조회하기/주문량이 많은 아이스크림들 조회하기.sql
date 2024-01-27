# -- 코드를 입력하세요
SELECT fh.FLAVOR
from FIRST_HALF fh left join (select flavor, sum(TOTAL_ORDER) as total_order1 from july group by flavor) j
on fh.flavor = j.flavor
where 1 = 1
order by fh.TOTAL_ORDER + j.total_order1 desc
limit 3
;

# select * from july;

# select flavor, sum(total_order) from july group by flavor;