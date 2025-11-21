-- 코드를 작성해주세요
with af_table as(
    select 
    ID,
    IFNULL(PARENT_ID, 0) as PARENT_ID
    from ECOLI_DATA
)

select 
a.ID,
(select 
 count(*) 
 from af_table 
 where PARENT_ID = a.ID
) as CHILD_COUNT

from ECOLI_DATA a
order by a.ID 
;

