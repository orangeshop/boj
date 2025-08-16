-- 코드를 작성해주세요
with af_table as (
    select 
    ID,
    PARENT_ID,
    GENOTYPE
    from ECOLI_DATA
)


select 
a.ID,
a.GENOTYPE,
b.GENOTYPE as PARENT_GENOTYPE
from  ECOLI_DATA a join af_table b
on a.PARENT_ID = b.ID
where a.PARENT_ID is not null
and a.GENOTYPE & b.GENOTYPE >= b.GENOTYPE
order by ID
;