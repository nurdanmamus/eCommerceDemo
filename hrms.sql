-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public."Employee"
(
    "EmployeeId" integer NOT NULL,
    "Name" character varying(30) NOT NULL,
    "Surname" character varying(30) NOT NULL,
    "Tckn" character(11) NOT NULL,
    "YearOfBirth" character(4) NOT NULL,
    PRIMARY KEY ("EmployeeId")
);

CREATE TABLE public."Users"
(
    "Id" integer NOT NULL,
    "Email" character varying(30) NOT NULL,
    "Password" character varying(20) NOT NULL,
    PRIMARY KEY ("Id")
);

ALTER TABLE public."Employee"
    ADD FOREIGN KEY ("EmployeeId")
    REFERENCES public."Users" ("Id")
    NOT VALID;

END;