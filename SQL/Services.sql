drop table Kunde CASCADE CONSTRAINTS;
drop table Service CASCADE CONSTRAINTS;
drop table Adresse CASCADE CONSTRAINTS;
drop table Service_Dict CASCADE CONSTRAINTS;
drop SEQUENCE service_seq;
drop SEQUENCE kunde_seq;
drop SEQUENCE adresse_seq;
drop SEQUENCE service_dict_seq;

---------------- SEQUENCE -----------------------

CREATE SEQUENCE service_seq
  MAXVALUE 999999999999999999999999999
  START WITH 100
  INCREMENT BY 1;

CREATE SEQUENCE kunde_seq
  MAXVALUE 999999999999999999999999999
  START WITH 100
  INCREMENT BY 1;

CREATE SEQUENCE adresse_seq
  MAXVALUE 999999999999999999999999999
  START WITH 100
  INCREMENT BY 1;

CREATE SEQUENCE service_dict_seq
  MAXVALUE 999999999999999999999999999
  START WITH 100
  INCREMENT BY 1;

---------------- TABELLEN -----------------------



create TABLE Kunde
(
  ID number(10) NOT NULL,
  NAME VARCHAR2(255) NOT NULL,
  GESCHLECHT VARCHAR (10),
  GRUENDUNGSDATUM DATE NOT NULL,
  TELEFON VARCHAR2(12),
  CONSTRAINT KUNDE_PK PRIMARY KEY(ID)
);

create TABLE Service
(
  ID number(10) NOT NULL,
  KUNDE_ID NUMBER(10) NOT NULL,
  SERVICE_NAME VARCHAR2(50) NOT NULL,
  CONSTRAINT SERVICE_PK PRIMARY KEY(ID),
  CONSTRAINT SERVICE_KUNDE_FK FOREIGN KEY(KUNDE_ID) REFERENCES Kunde(ID)
);

create TABLE Adresse
(
  ID number(10) NOT NULL,
  ORT VARCHAR(50) NOT NULL,
  STRASSE VARCHAR2(50) NOT NULL,
  HAUS_NR NUMBER(3) NOT NULL,
  WOHNUNG_NR NUMBER(3),
  KUNDE_ID NUMBER(10) NOT NULL,
  ADRESSE_ART NUMBER(1) NOT NULL,
  CONSTRAINT ADRESSE_PK PRIMARY KEY(ID),
  CONSTRAINT ADRESSE_KUNDE_FK FOREIGN KEY(KUNDE_ID) REFERENCES Kunde(ID)
);

create TABLE Service_Dict
(
  ID number(10) NOT NULL,
  NAME VARCHAR2 (255) NOT NULL,
  SERVICE_ART VARCHAR2 (50) NOT NULL,
  CONSTRAINT SERVICE_DICT_PK PRIMARY KEY (ID)
);

insert into Kunde(ID, NAME, GESCHLECHT, GRUENDUNGSDATUM) VALUES(1, 'Centralny Dom Maklerski', 'FIRMA', TO_DATE('10.11.2015', 'DD.MM.YYYY'));
insert into Kunde(ID, NAME, GESCHLECHT, GRUENDUNGSDATUM, TELEFON) VALUES(2, 'Bank Pekao', 'FIRMA', TO_DATE('13.02.2000', 'DD.MM.YYYY'), '6548765');
insert into Kunde(ID, NAME, GESCHLECHT, GRUENDUNGSDATUM, TELEFON) VALUES(3, 'Max Mustermann Enterpreis', 'MANN', TO_DATE('10.01.2016', 'DD.MM.YYYY'), '5322567');

insert into Service(ID, SERVICE_NAME, KUNDE_ID) VALUES(1, 'Reuters Serwis Polski', 1);
insert into Service(ID, SERVICE_NAME, KUNDE_ID) VALUES(2, 'Reuters Trader Eastern Europe', 1);
insert into Service(ID, SERVICE_NAME, KUNDE_ID) VALUES(3, 'Kondor', 2);
insert into Service(ID, SERVICE_NAME, KUNDE_ID) VALUES(4, 'Reuters Knowledge', 2);
insert into Service(ID, SERVICE_NAME, KUNDE_ID) VALUES(5, 'Reuters Trader Eastern Europe', 3);
insert into Service(ID, SERVICE_NAME, KUNDE_ID) VALUES(6, 'Kondor', 3);

insert into Adresse(ID, ORT, STRASSE, HAUS_NR, WOHNUNG_NR, ADRESSE_ART, KUNDE_ID) VALUES(1, 'Warszawa', 'Solidarnosci', 54, 11, 0, 1);
insert into Adresse(ID, ORT, STRASSE, HAUS_NR, WOHNUNG_NR, ADRESSE_ART, KUNDE_ID) VALUES(2, 'Rzeszow', 'Siemiradzkiego', 76, 22, 1, 1);

insert into Adresse(ID, ORT, STRASSE, HAUS_NR, WOHNUNG_NR, ADRESSE_ART, KUNDE_ID) VALUES(3, 'Warszawa', 'Dobra', 11, 33, 0, 2);
insert into Adresse(ID, ORT, STRASSE, HAUS_NR, WOHNUNG_NR, ADRESSE_ART, KUNDE_ID) VALUES(4, 'Rzeszow', 'Warszawska', 13, 44, 1, 2);

insert into Adresse(ID, ORT, STRASSE, HAUS_NR, WOHNUNG_NR, ADRESSE_ART, KUNDE_ID) VALUES(5, 'Warszawa', 'Wojska Polskiego', 11, 33, 0, 3);
insert into Adresse(ID, ORT, STRASSE, HAUS_NR, WOHNUNG_NR, ADRESSE_ART, KUNDE_ID) VALUES(6, 'Krakow', 'Nowotki', 13, 44, 1, 3);

insert into Service_Dict(ID, NAME, SERVICE_ART) VALUES (1, 'Kondor', 'DECODER');
insert into Service_Dict(ID, NAME, SERVICE_ART) VALUES (2, 'Reuters Trader Eastern Europe', 'WEB');
insert into Service_Dict(ID, NAME, SERVICE_ART) VALUES (3, 'Reuters Knowledge', 'DECODER');
insert into Service_Dict(ID, NAME, SERVICE_ART) VALUES (4, 'Reuters Serwis Polski', 'WEB');

commit;
