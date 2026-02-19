-- 코드를 입력하세요
with t1 as(
    select 0 as HOUR, 0 as COUNT
    from dual
    
    UNION ALL 
    
    select 1 , 0
    from dual
    
    UNION ALL 
    
    select 2 , 0
    from dual
    
    UNION ALL 
    
    select 3 , 0
    from dual
    
    UNION ALL 
    
    select 4 , 0
    from dual
    
    UNION ALL 
    
    select 5 , 0
    from dual
    
    UNION ALL 
    
    select 6 , 0
    from dual
    
    UNION ALL 
    
    select 7 , 0
    from dual
    
    UNION ALL 
    
    select 8 , 0
    from dual
    
    UNION ALL 
    
    select 9 , 0
    from dual
    
    UNION ALL 
    
    select 10 , 0
    from dual
    
    UNION ALL 
    
    select 11 , 0
    from dual
    
    UNION ALL 
    
    select 12 , 0
    from dual
    
    UNION ALL 
    
    select 13 , 0
    from dual
    
    UNION ALL 
    
    select 14 , 0
    from dual
    
    UNION ALL 
    
    select 15 , 0
    from dual
    
    UNION ALL 
    
    select 16 , 0
    from dual
    
    UNION ALL 
    
    select 17 , 0
    from dual
    
    UNION ALL 
    
    select 18 , 0
    from dual
    
    UNION ALL 
    
    select 19 , 0
    from dual
    
    UNION ALL 
    
    select 20 , 0
    from dual
    
    UNION ALL 
    
    select 21 , 0
    from dual
    
    UNION ALL 
    
    select 22 , 0
    from dual
    
    UNION ALL 
    
    select 23 , 0
    from dual
), t2 as(
    select HOUR(DATETIME) as HOUR, count(*) as count
    from ANIMAL_OUTS
    group by HOUR(DATETIME)
)


select a.HOUR, 
case 
    when a.count + b.count is null then 0 
    else a.count + b.count
end as COUNT
from t1 a left join t2 b
on a.hour = b.hour

