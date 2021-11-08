# Write your MySQL query statement below
(SELECT name AS results 
 FROM Movie_Rating JOIN Users USING (user_id) 
 GROUP BY user_id 
 ORDER BY COUNT(movie_id) DESC, name ASC 
 LIMIT 1)

UNION

(SELECT title AS results 
 FROM Movie_Rating JOIN Movies USING (movie_id) 
 WHERE created_at LIKE "2020-02%" 
 GROUP BY movie_id 
 ORDER BY AVG(rating) DESC, title ASC 
 LIMIT 1); 