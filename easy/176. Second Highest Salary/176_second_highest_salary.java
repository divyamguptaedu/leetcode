"
Performance:
Runtime: 226 ms, faster than 27.11% of MySQL online submissions for Second Highest Salary.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Second Highest Salary.
"

# Write your MySQL query statement below
SELECT (
SELECT DISTINCT Salary
FROM Employee
ORDER BY Salary DESC
LIMIT 1 OFFSET 1) 
AS SecondHighestSalary;