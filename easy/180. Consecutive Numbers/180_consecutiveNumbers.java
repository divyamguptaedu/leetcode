"
Performance:
Runtime: 499 ms, faster than 62.47% of MySQL online submissions for Consecutive Numbers.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Consecutive Numbers.
"

# Write your MySQL query statement below
SELECT distinct a.num AS ConsecutiveNums FROM 
Logs a, Logs b, Logs c
WHERE a.id - b.id = 1 
    AND a.num = b.num 
    AND b.id - c.id = 1
    AND b.num = c.num ; 