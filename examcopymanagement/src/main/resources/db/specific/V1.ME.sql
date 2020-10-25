use cs_records;

SET @s = CONCAT('CREATE TABLE CS_', DATE_FORMAT(CURDATE(), '%Y%m%d'), ' SELECT * FROM examcopymanagement.detailed_info_cs');
 PREPARE stmt FROM @s;
 EXECUTE stmt;
 
 use examcopymanagement;
 
 TRUNCATE `examcopymanagement`.`detailed_info_cs`;
 
 insert into `examcopymanagement`.`detailed_info_cs` (id,enrollment_no) values(0,"ENROLLMENT NO");
 
 insert into `examcopymanagement`.`detailed_info_cs` (id,enrollment_no) select * from `examcopymanagement`.`student_cs`;