-- 코드를 입력하세요
with af_table as(
    select 
    0 as num
    union select 
    1
    union select 
    2
    union select 
    3
    union select 
    4
    union select 
    5
    union select 
    6
    union select 
    7
    union select 
    8
    union select 
    9
    union select 
    10
    union select 
    11
    union select 
    12
    union select 
    13
    union select 
    14
    union select 
    15
    union select 
    16
    union select 
    17
    union select 
    18
    union select 
    19
    union select 
    20
    union select 
    21
    union select 
    22
    union select 
    23
)



select 
num
, (select count(*) from ANIMAL_OUTS where num = HOUR(DATETIME)) as COUNT
from af_table
group by num


;