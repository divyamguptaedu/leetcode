"
Performance:
Runtime: 395 ms, faster than 24.54% of MySQL online submissions for Nth Highest Salary.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Nth Highest Salary.
"

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N = N - 1;
  RETURN (
        SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET N     
  );
END