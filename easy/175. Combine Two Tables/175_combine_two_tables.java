# Write your MySQL query statement below
SELECT FirstName, LastName, City, State FROM PERSON 
LEFT JOIN Address
ON Person.PersonId = Address.PersonId;