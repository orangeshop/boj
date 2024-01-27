-- 코드를 입력하세요
SELECT FP.PRODUCT_ID, FP.PRODUCT_NAME, (sum(FO.AMOUNT) * FP.PRICE) as `TOTAL_SALES`
from FOOD_PRODUCT FP left join FOOD_ORDER FO
on FP.PRODUCT_ID = FO.PRODUCT_ID
where 1 = 1
and date_format(Fo.PRODUCE_DATE, '20%y-%m') = date_format(STR_TO_DATE('2022-05', '20%y-%m'), '20%y-%m')
group by Fp.PRODUCT_NAME
order by TOTAL_SALES desc, Fp.PRODUCT_ID
;

# select date_format(Fo.PRODUCE_DATE, '20%y-%m') from FOOD_ORDER FO;