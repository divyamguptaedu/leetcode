/*
Runtime: 838 ms, faster than 10.70% of MySQL online submissions for Customers Who Bought All Products.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Bought All Products.
*/

# Write your MySQL query statement below
select customer_id
from customer
group by customer_id
having count(distinct(product_key))=(select count(*) from product)