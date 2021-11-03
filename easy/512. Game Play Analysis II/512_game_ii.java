// Runtime: 3555 ms, faster than 5.00% of MySQL online submissions for Game Play Analysis II.
// Memory Usage: 0B, less than 100.00% of MySQL online submissions for Game Play Analysis II.

# Write your MySQL query statement below
SELECT 
  player_id,
  device_id
FROM Activity a
WHERE event_date = (
  SELECT 
     MIN(event_date)
  FROM Activity b
  WHERE a.player_id = b.player_id
)







