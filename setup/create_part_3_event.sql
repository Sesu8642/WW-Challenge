SET GLOBAL event_scheduler = ON;

USE wwChallenge;

delimiter |

CREATE EVENT

IF NOT EXISTS update_parent_summary ON SCHEDULE EVERY 15 MINUTE DO
BEGIN
	TRUNCATE TABLE wwChallenge.parent_summary;

	INSERT INTO wwChallenge.parent_summary
	SELECT ROW_NUMBER() OVER (
			ORDER BY children_count
			) AS id
		,children_count AS amount_of_children
		,COUNT(children_count) AS amount_of_persons
	FROM (
		SELECT parent_id
			,COUNT(parent_id) AS children_count
		FROM wwChallenge.child c
		GROUP BY parent_id
		) AS children_per_parent
	GROUP BY children_count;
END |

delimiter ;