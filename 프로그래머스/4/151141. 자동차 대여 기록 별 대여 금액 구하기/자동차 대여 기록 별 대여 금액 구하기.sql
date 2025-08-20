WITH rental_data AS (
    SELECT 
        h.HISTORY_ID,
        c.DAILY_FEE,
        DATEDIFF(h.END_DATE, h.START_DATE) + 1 AS rental_days
    FROM CAR_RENTAL_COMPANY_CAR c
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY h ON c.CAR_ID = h.CAR_ID
    WHERE c.CAR_TYPE = '트럭'
),
discount_rates AS (
    SELECT 
        MAX(CASE WHEN DURATION_TYPE = '7일 이상' THEN DISCOUNT_RATE END) AS rate_7,
        MAX(CASE WHEN DURATION_TYPE = '30일 이상' THEN DISCOUNT_RATE END) AS rate_30,
        MAX(CASE WHEN DURATION_TYPE = '90일 이상' THEN DISCOUNT_RATE END) AS rate_90
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
    WHERE CAR_TYPE = '트럭'
)
SELECT 
    HISTORY_ID,
    CASE 
        WHEN rental_days >= 90 THEN 
            FLOOR(DAILY_FEE * (100 - rate_90) / 100 * rental_days)
        WHEN rental_days >= 30 THEN 
            FLOOR(DAILY_FEE * (100 - rate_30) / 100 * rental_days)
        WHEN rental_days >= 7 THEN 
            FLOOR(DAILY_FEE * (100 - rate_7) / 100 * rental_days)
        ELSE 
            DAILY_FEE * rental_days
    END AS FEE
FROM rental_data, discount_rates
ORDER BY FEE DESC, HISTORY_ID DESC;