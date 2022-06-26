"Performance:
Runtime: 372 ms, faster than 89.62% of MySQL online submissions for Tree Node.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Tree Node.
"

# Write your MySQL query statement below

SELECT id, (
    CASE
        WHEN p_id IS NULL THEN 'Root'
        WHEN id IN (SELECT id FROM Tree WHERE id IN (SELECT p_id FROM Tree)) THEN 'Inner'
        ELSE 'Leaf'
    END
) AS type FROM Tree ORDER BY id; 