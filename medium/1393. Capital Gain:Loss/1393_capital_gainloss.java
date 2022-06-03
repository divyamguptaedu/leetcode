"
Peformance:
Runtime: 396 ms, faster than 99.25% of MySQL online submissions for Capital Gain/Loss.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Capital Gain/Loss.
"

# Write your MySQL query statement below
SELECT stock_name, sum((CASE WHEN operation = 'Buy' THEN (price * -1) ELSE (price * 1) END)) as capital_gain_loss

FROM stocks

GROUP BY stock_name;
