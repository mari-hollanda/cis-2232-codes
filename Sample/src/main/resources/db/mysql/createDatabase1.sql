drop database if exists cis2232_sample;
create database cis2232_sample;
use cis2232_sample;


CREATE TABLE CodeType (codeTypeId int(3) COMMENT 'This is the primary key for code types',
  englishDescription varchar(100) NOT NULL COMMENT 'English description',
  frenchDescription varchar(100) DEFAULT NULL COMMENT 'French description',
  createdDateTime datetime DEFAULT NULL,
  createdUserId varchar(20) DEFAULT NULL,
  updatedDateTime datetime DEFAULT NULL,
  updatedUserId varchar(20) DEFAULT NULL
) COMMENT 'This tables holds the code types that are available for the application';

INSERT INTO CodeType (CodeTypeId, englishDescription, frenchDescription, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
(1, 'User Types', 'User Types FR', sysdate(), '', CURRENT_TIMESTAMP, ''),
(2, 'Courses', 'Status Types FR', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, '');

CREATE TABLE CodeValue (
  codeTypeId int(3) NOT NULL COMMENT 'see code_type table',
  codeValueSequence int(3) NOT NULL,
  englishDescription varchar(100) NOT NULL COMMENT 'English description',
  englishDescriptionShort varchar(20) NOT NULL COMMENT 'English abbreviation for description',
  frenchDescription varchar(100) DEFAULT NULL COMMENT 'French description',
  frenchDescriptionShort varchar(20) DEFAULT NULL COMMENT 'French abbreviation for description',
  sortOrder int(3) DEFAULT NULL COMMENT 'Sort order if applicable',
  createdDateTime datetime DEFAULT NULL,
  createdUserId varchar(20) DEFAULT NULL,
  updatedDateTime datetime DEFAULT NULL,
  updatedUserId varchar(20) DEFAULT NULL
) COMMENT='This will hold code values for the application.';

INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
(1, 1, 'General', 'General', 'GeneralFR', 'GeneralFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
(1, 2, 'Admin', 'Admin', 'Admin', 'Admin', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');

INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
(2, 1, 'CIS1201', 'OOP', 'OOP', 'OOP', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin'),
(2, 2, 'CIS1280', 'Web App', 'Web', 'Not Active', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin'),
(2, 3, 'CIS1300', 'Operating Systems', 'OS', 'OS', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin'),
(2, 4, 'CIS1360', 'Networking', 'Networking', 'Networking', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');






CREATE TABLE UserAccess (
  userAccessId int(3) NOT NULL,
  username varchar(100) NOT NULL COMMENT 'Unique user name for app',
  password varchar(128) NOT NULL,
  name varchar(128),
  userAccessStatusCode int(3) NOT NULL DEFAULT '1' COMMENT 'Code type #2',
  userTypeCode int(3) NOT NULL DEFAULT '1' COMMENT 'Code type #1',
  createdDateTime datetime DEFAULT NULL COMMENT 'When user was created.'
);

ALTER TABLE CodeType
  ADD PRIMARY KEY (codeTypeId);

ALTER TABLE CodeValue
  ADD PRIMARY KEY (codeTypeId,codeValueSequence);
--  ADD KEY codeTypeId (codeTypeId);

ALTER TABLE UserAccess
  ADD PRIMARY KEY (userAccessId),
  ADD KEY userTypeCode (userTypeCode);

ALTER TABLE CodeType
  MODIFY codeTypeId int(3) NOT NULL COMMENT 'This is the primary key for code types';

ALTER TABLE CodeValue
  MODIFY codeValueSequence int(3) NOT NULL;

ALTER TABLE UserAccess
  MODIFY userAccessId int(3) NOT NULL AUTO_INCREMENT;
