-- 코드를 작성해주세요




SELECT a.ID ,b.FISH_NAME, a.LENGTH
FROM FISH_INFO a
JOIN FISH_NAME_INFO b ON a.FISH_TYPE = b.FISH_TYPE
where (a.FISH_TYPE, a.LENGTH) in (
    select FISH_TYPE, max(LENGTH) 
    from FISH_INFO
    group by FISH_TYPE
)
order by a.id
;