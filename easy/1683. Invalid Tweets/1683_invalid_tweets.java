"
Performance:
Runtime: 531 ms, faster than 66.59% of MySQL online submissions for Invalid Tweets.
Memory Usage: 0B, less than 100.00% of MySQL online submissions for Invalid Tweets.
"

# Write your MySQL query statement below
SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15