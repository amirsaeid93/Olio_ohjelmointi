USE currency_db;

-- 1. This retrieves all the currencies
SELECT * FROM currency;

-- 2. This retrieves the currency with the abbreviation EUR
SELECT * FROM currency WHERE abbreviation = 'EUR';

-- 3. This retrieves the number of currencies in the database
SELECT COUNT(*) FROM currency;

-- 4. This retrieves the currency with the highest exchange rate
SELECT * FROM currency ORDER BY rate DESC LIMIT 1;