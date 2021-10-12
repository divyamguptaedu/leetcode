"
Performance:
Runtime: 405 ms, faster than 97.29% of MySQL online submissions for Daily Leads and Partners.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Daily Leads and Partners.
"

# Write your MySQL query statement below
SELECT
  date_id,
  make_name,
  COUNT(DISTINCT lead_id) unique_leads,
  COUNT(DISTINCT partner_id) unique_partners
FROM dailysales
GROUP BY
  date_id,
  make_name