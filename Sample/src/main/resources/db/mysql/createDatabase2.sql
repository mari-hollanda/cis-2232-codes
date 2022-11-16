use cis2232_sample;

--
-- Database: `cis2232_sample`
--

CREATE TABLE Student (
  studentId int(3) NOT NULL COMMENT 'The student id',
  name varchar(100) NOT NULL COMMENT 'Name',
  program varchar(100) DEFAULT NULL COMMENT 'Program',
  hollPassBalance int(4) NOT NULL DEFAULT 0 COMMENT 'Student HollPass Balance in whole dollars'
) COMMENT='This table to hold student data';

INSERT INTO Student (studentId, name, program) VALUES
(1, 'Adline', 'CIS'),
(2, 'Francisco', 'CISC');
COMMIT;

CREATE TABLE StudentCourse(
id int(5),
studentId int(5) COMMENT 'FK to Student',
studentCourse int(3) COMMENT 'Code Type 2 (Course in which student is registered)' 
) COMMENT 'This table holds student course data';

ALTER TABLE Student
  ADD PRIMARY KEY (studentId);
ALTER TABLE Student
  MODIFY studentId int(3) NOT NULL AUTO_INCREMENT COMMENT 'This is the primary key', AUTO_INCREMENT=1;

ALTER TABLE StudentCourse
  ADD PRIMARY KEY (id);
ALTER TABLE StudentCourse
  MODIFY id int(5) NOT NULL AUTO_INCREMENT COMMENT 'This is the primary key', AUTO_INCREMENT=1;


INSERT INTO studentcourse (id, studentId, studentCourse) VALUES
(1, 2, 2),
(2, 2, 1);


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getName`(IN IdIn INT, OUT NameOut VARCHAR(255))
BEGIN
   SELECT name INTO NameOut
   FROM Student
   WHERE studentId = idIn;
END$$
DELIMITER ;