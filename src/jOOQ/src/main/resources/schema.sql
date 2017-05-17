DROP TABLE IF EXISTS YEAR_RESULT;
CREATE TABLE YEAR_RESULT (
  id INT AUTO_INCREMENT PRIMARY KEY,
  departement VARCHAR(50),
  manager VARCHAR(50) NOT NULL,
  netprofit DOUBLE,
  operatingexpense DOUBLE,
  turnover DOUBLE,
  creation_date TIMESTAMP
);

insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 12000.46, 2010.34, 5.5, PARSEDATETIME('01-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 11000.46, 1010.34, 5.5, PARSEDATETIME('02-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 13000.46, 2510.34, 5.5, PARSEDATETIME('03-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 14000.46, 2040.34, 5.5, PARSEDATETIME('04-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 10000.46, 2110.34, 5.5, PARSEDATETIME('05-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 11000.46, 2210.34, 5.5, PARSEDATETIME('06-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 12000.46, 2310.34, 5.5, PARSEDATETIME('07-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 12500.46, 2150.34, 5.5, PARSEDATETIME('08-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 11500.46, 2210.34, 5.5, PARSEDATETIME('09-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 13400.46, 2510.34, 5.5, PARSEDATETIME('10-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 10500.46, 2310.34, 5.5, PARSEDATETIME('11-2016', 'MM-yyyy'));
insert into year_result (departement, manager, netprofit, operatingexpense, turnover, creation_date) values('IT', 'DBA', 14500.46, 2210.34, 5.5, PARSEDATETIME('12-2016', 'MM-yyyy'));
