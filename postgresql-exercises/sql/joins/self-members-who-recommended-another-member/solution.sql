SELECT DISTINCT
    recs.firstname AS firstname,
    recs.surname AS surname
FROM cd.members AS mems
INNER JOIN cd.members AS recs
    ON recs.memid = mems.recommendedby
ORDER BY recs.surname, recs.firstname;
