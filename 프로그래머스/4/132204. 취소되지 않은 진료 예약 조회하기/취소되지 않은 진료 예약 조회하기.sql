-- 코드를 입력하세요
SELECT
b.APNT_NO,
a.PT_NAME,
a.PT_NO,
b.MCDP_CD,
c.DR_NAME,
b.APNT_YMD
from PATIENT a join APPOINTMENT b
on a.PT_NO = b.PT_NO
join DOCTOR c
on c.DR_ID = b.MDDR_ID
where YEAR(b.APNT_YMD) = 2022
and MONTH(b.APNT_YMD) = 4
and DAY(b.APNT_YMD) = 13
and b.APNT_CNCL_YN like "N"
and b.MCDP_CD like "CS"
order by b.APNT_YMD