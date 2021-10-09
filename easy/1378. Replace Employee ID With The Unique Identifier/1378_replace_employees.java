"
Performance:
Runtime: 903 ms, faster than 82.16% of MySQL online submissions for Replace Employee ID With The Unique Identifier.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Replace Employee ID With The Unique Identifier.
"

# Write your MySQL query statement below
SELECT unique_id, name
FROM Employees 
LEFT JOIN EmployeeUNI 
USING (id)