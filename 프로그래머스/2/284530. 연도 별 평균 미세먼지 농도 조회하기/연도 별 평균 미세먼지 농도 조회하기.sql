-- 코드를 작성해주세요

SELECT
  YEAR(YM)        AS "YEAR",        -- alias는 소문자나 backtick 사용
  round(AVG(PM_VAL1),2)    AS "PM10",        -- 집계함수 뒤에 반드시 쉼표!
  round(AVG(PM_VAL2),2)    AS "PM2.5"        -- 마침표 대신 언더스코어 사용
FROM AIR_POLLUTION
where LOCATION2 like '수원'
GROUP BY YEAR(YM)
ORDER BY YEAR(YM)
;