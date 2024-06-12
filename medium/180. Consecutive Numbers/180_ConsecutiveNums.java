#I joined the Logs table with itself twice, each join offset by one ID. 
#This allowed me to compare three consecutive rows. 
#I checked if the numbers in these rows were the same. 
#If so, the number appeared at least three times consecutively. 
#Using DISTINCT, I ensured each qualifying number appeared only once in the result.

SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num
;