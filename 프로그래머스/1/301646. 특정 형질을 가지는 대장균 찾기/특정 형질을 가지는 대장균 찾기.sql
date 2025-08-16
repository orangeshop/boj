-- 코드를 작성해주세요
select count(*) as COUNT
from ECOLI_DATA
WHERE
    -- 조건 1: 2번 형질이 없고
    (GENOTYPE & 2) = 0
    -- 조건 2: 그리고 1번 또는 3번 형질을 가짐
    AND (GENOTYPE & 5) > 0
ORDER BY
    ID ASC;

;