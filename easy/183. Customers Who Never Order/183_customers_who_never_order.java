"
Performance:
Runtime: 524 ms, faster than 26.83% of MySQL online submissions for Customers Who Never Order.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.
"

# Write your MySQL query statement below
SELECT Customers.Name as 'Customers'
from Customers
where Customers.id NOT IN (SELECT CustomerId FROM Orders);