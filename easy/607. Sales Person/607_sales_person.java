# Write your MySQL query statement below
SELECT
   name 
FROM
   salesperson 
WHERE
   sales_id NOT IN 
   (
      SELECT
         o.sales_id 
      FROM
         company c 
         JOIN
            orders o 
      WHERE
         c.com_id = o.com_id 
         AND c.name = "RED"
   )
;