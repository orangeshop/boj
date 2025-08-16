-- 코드를 작성해주세요
with 
first_table as(
    select ID as one_id from ECOLI_DATA where PARENT_ID is null
),
second_table as(
    select ID as two_id 
    from ECOLI_DATA a right join first_table b
    on a.PARENT_ID = b.one_id
),
third_table as(
    select ID as third_id 
    from ECOLI_DATA a right join second_table b
    on a.PARENT_ID = b.two_id
)

select third_id as ID  from third_table
where third_id is not null
order by ID
;