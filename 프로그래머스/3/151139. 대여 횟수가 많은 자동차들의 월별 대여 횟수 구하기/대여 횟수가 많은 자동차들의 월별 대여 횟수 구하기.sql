-- 코드를 입력하세요
SELECT MONTH, CAR_ID, RECORDS
FROM 
(
    SELECT DATE_FORMAT(START_DATE, '%c') AS MONTH, 
        CAR_ID,
        COUNT(*) AS RECORDS
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY MONTH, CAR_ID
) SUB
WHERE CAR_ID IN (
    SELECT CAR_ID
    FROM (
        SELECT DATE_FORMAT(START_DATE, '%c') AS MONTH,
            CAR_ID,
            COUNT(*) AS RECORDS
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
        GROUP BY MONTH, CAR_ID
    ) TEMP
    GROUP BY CAR_ID
    HAVING SUM(RECORDS) >= 5
)
ORDER BY CAST(MONTH AS UNSIGNED) ASC, CAR_ID DESC