"
Performance:
Runtime: 489 ms, faster than 50.08% of MySQL online submissions for Find Total Time Spent by Each Employee.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Find Total Time Spent by Each Employee.
"

# Write your MySQL query statement below
SELECT
    event_day AS day,
    emp_id,
    SUM(out_time-in_time) AS total_time
FROM Employees
GROUP BY emp_id, event_day