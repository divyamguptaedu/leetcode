// Runtime: 342 ms, faster than 33.27% of MySQL online submissions for Rank Scores.
// Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rank Scores.


# Write your MySQL query statement below
SELECT S.Score, COUNT(S2.Score) as `Rank`
FROM Scores S,
(SELECT DISTINCT Score FROM Scores) S2
WHERE S.Score<=S2.Score
GROUP BY S.Id
ORDER BY S.Score DESC;