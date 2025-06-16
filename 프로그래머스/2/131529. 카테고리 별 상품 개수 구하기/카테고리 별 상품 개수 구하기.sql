-- 코드를 입력하세요
SELECT LEFT(PRODUCT_CODE, 2) as "CATEGORY", count(*) as "PRODUCTS"
from PRODUCT
group by LEFT(PRODUCT_CODE, 2)

# select * from PRODUCT;
