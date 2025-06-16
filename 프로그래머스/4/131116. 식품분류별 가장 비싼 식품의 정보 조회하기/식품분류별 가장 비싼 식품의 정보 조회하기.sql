-- 코드를 입력하세요
SELECT CATEGORY, PRICE	as 'MAX_PRICE',	PRODUCT_NAME
from FOOD_PRODUCT
where CATEGORY in ('과자', '국', '김치', '식용유')
and (PRICE) in (
    
    select max(PRICE) from FOOD_PRODUCT
    group by CATEGORY
    
)
group by CATEGORY
order by max(PRICE) desc

# select max(PRICE) from FOOD_PRODUCT
# group by CATEGORY


# select * from FOOD_PRODUCT


# MAX_PRICE	PRODUCT_NAME
# 김치	19000	맛있는배추김치
# 식용유	8950	맛있는콩기름
# 국	2900	맛있는미역국
# 과자	1950	맛있는포카칩