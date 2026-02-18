USE currency_db;

-- 1. Retrieve all currencies
SELECT * FROM currency;

-- 2. Retrieve the currency with the abbreviation EUR
SELECT * FROM currency WHERE abbreviation = 'EUR';

-- 3. Retrieve the number of currencies in the database
SELECT COUNT(*) FROM currency;

-- 4. Retrieve the currency with the highest exchange rate
SELECT * FROM currency ORDER BY rate DESC LIMIT 1;