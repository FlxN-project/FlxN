CREATE SEQUENCE USER_ID_SEQ;

CREATE TABLE "USERS"(
"USER_ID" bigint PRIMARY KEY default nextval('USER_ID_SEQ'),
"EMAIL" varchar(30) NOT NULL,
"PASSWORD" varchar(100) NOT NULL
);

CREATE SEQUENCE USER_PROJECT_ID_SEQ;

CREATE TABLE "PROJECTS"(
"PROJECT_ID" bigint PRIMARY KEY default nextval('USER_PROJECT_ID_SEQ'),
"TITLE" varchar(30) NOT NULL,
"USER_ID" bigint NOT NULL,
"DESCRIPTION" varchar(400),
CONSTRAINT project_foreign_key FOREIGN KEY ("USER_ID") REFERENCES "USERS" ("USER_ID") 
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT project_unique UNIQUE ("USER_ID","TITLE")
);

CREATE SEQUENCE USER_CLASS_ID_SEQ;

CREATE TABLE "CLASSES"(
"CLASS_ID" bigint PRIMARY KEY default nextval('USER_CLASS_ID_SEQ'),
"NAME" varchar(40) NOT NULL,
"PROJECT_ID" bigint NOT NULL,
"DESCRIPTION" varchar(400),
CONSTRAINT class_foreign_key FOREIGN KEY ("PROJECT_ID") REFERENCES "PROJECTS" ("PROJECT_ID") MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT class_unique UNIQUE ("NAME","PROJECT_ID")
);

CREATE SEQUENCE USER_ATTR_ID_SEQ;

CREATE TABLE "ATTRIBUTES"(
"ATTRIBUTE_ID" bigint PRIMARY KEY default nextval('USER_ATTR_ID_SEQ'),
"CLASS_ID" bigint NOT NULL,
"NAME" varchar(40) NOT NULL,
CONSTRAINT attribute_foreign_key FOREIGN KEY ("CLASS_ID") REFERENCES "CLASSES" ("CLASS_ID") MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT attribute_unique UNIQUE ("CLASS_ID","NAME")
);

CREATE SEQUENCE USER_OBJECT_ID_SEQ;

CREATE TABLE "OBJECTS"(
"OBJECT_ID" bigint PRIMARY KEY default nextval('USER_OBJECT_ID_SEQ'),
"CLASS_ID" bigint NOT NULL,
"LINK" varchar(40) NOT NULL,
CONSTRAINT object_foreign_key FOREIGN KEY ("CLASS_ID") REFERENCES "CLASSES" ("CLASS_ID") MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT object_unique UNIQUE ("LINK","CLASS_ID")
);

CREATE SEQUENCE USER_VALUE_ID_SEQ;

CREATE TABLE "VALUES"(
"VALUE_ID" bigint PRIMARY KEY default nextval('USER_VALUE_ID_SEQ'),
"ATTRIBUTE_ID" bigint NOT NULL,
"OBJECT_ID" bigint NOT NULL,
"VALUE" varchar(250) NOT NULL,
CONSTRAINT attr_foreign_key FOREIGN KEY ("ATTRIBUTE_ID") REFERENCES "ATTRIBUTES" ("ATTRIBUTE_ID") MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT obj_foreign_key FOREIGN KEY ("OBJECT_ID") REFERENCES "OBJECTS" ("OBJECT_ID") MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT value_unique UNIQUE ("ATTRIBUTE_ID","OBJECT_ID")
);

