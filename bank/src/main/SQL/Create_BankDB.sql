/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     24.01.2015 11:27:39                          */
/*==============================================================*/
/* vor ersten Ausführung in MySQL:  create database bank;*/

drop table if exists ACCOUNT;

drop table if exists BANK;

drop table if exists CHECKING_ACCOUNT;

drop table if exists CONTRA_ACCOUNT;

drop table if exists CUSTODY_ACCOUNT;

drop table if exists CUSTODY_TRANSACTION;

drop table if exists CUSTOMER;

drop table if exists SAVINGS_ACCOUNT;

drop table if exists STOCKS_PORTFOLIO;

drop table if exists TRANSACTION;

/*==============================================================*/
/* Table: ACCOUNT                                               */
/*==============================================================*/
create table ACCOUNT
(
   ACCOUNT_DESCRIPTION  varchar(128) not null,
   ACCOUNT_ID           int not null,
   CUSTOMER_ID          int not null,
   ACCOUNT_IBAN         varchar(34) not null,
   ACCOUNT_SALDO        decimal(15,2) not null,
   ACCOUNT_STATEMENT    decimal(15,2),
   ACCOUNT_STATEMENT_DATE timestamp,
   primary key (ACCOUNT_ID)
);

/*==============================================================*/
/* Table: BANK                                                  */
/*==============================================================*/
create table BANK
(
   BANK_BIC             varchar(11) not null,
   BANK_ADDRESS         varchar(128) not null,
   BANK_ID              int not null AUTO_INCREMENT,
   BANK_NAME            varchar(50) not null,
   primary key (BANK_ID)
);

/*==============================================================*/
/* Table: CHECKING_ACCOUNT                                      */
/*==============================================================*/
create table CHECKING_ACCOUNT
(
   ACCOUNT_ID           int not null,
   CUS_ACCOUNT_ID       int,
   primary key (ACCOUNT_ID)
);

/*==============================================================*/
/* Table: CONTRA_ACCOUNT                                        */
/*==============================================================*/
create table CONTRA_ACCOUNT
(
   TRANSACTIONS_ID      int not null,
   CONTRA_IBAN          varchar(34) not null,
   CONTRA_BIC           varchar(11) not null,
   primary key (TRANSACTIONS_ID)
);

/*==============================================================*/
/* Table: CUSTODY_ACCOUNT                                       */
/*==============================================================*/
create table CUSTODY_ACCOUNT
(
   ACCOUNT_ID           int not null,
   CHE_ACCOUNT_ID       int not null,
   primary key (ACCOUNT_ID)
);

/*==============================================================*/
/* Table: CUSTODY_TRANSACTION                                   */
/*==============================================================*/
create table CUSTODY_TRANSACTION
(
   TRANSACTIONS_ID      int not null,
   STOCK_QUANTITY       int not null,
   STOCK_EXCHANGE_RATE  decimal(15,5) not null,
   STOCK_NAME           varchar(128) not null,
   primary key (TRANSACTIONS_ID)
);

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER
(
   CUSTOMER_ADDRESS     varchar(128) not null,
   CUSTOMER_NAME        varchar(128) not null,
   CUSTOMER_ID          int not null AUTO_INCREMENT,
   BANK_ID              int not null,
   PIN                  varchar(128) not null,
   primary key (CUSTOMER_ID)
);

/*==============================================================*/
/* Table: SAVINGS_ACCOUNT                                       */
/*==============================================================*/
create table SAVINGS_ACCOUNT
(
   ACCOUNT_ID           int not null,
   CHE_ACCOUNT_ID       int not null,
   primary key (ACCOUNT_ID)
);

/*==============================================================*/
/* Table: STOCKS_PORTFOLIO                                      */
/*==============================================================*/
create table STOCKS_PORTFOLIO
(
   ACCOUNT_ID           int not null,
   STOCK_ID             int not null,
   STOCK_AMOUNT         int not null,
   STOCKNAME            varchar(128) not null,
   primary key (ACCOUNT_ID, STOCK_ID)
);

/*==============================================================*/
/* Table: TRANSACTION                                           */
/*==============================================================*/
create table TRANSACTION
(
   TRANSACTION_AMOUNT   decimal(15,2) not null,
   VALUTA_DATE          date not null,
   TRANSACTION_TYPE     int not null,
   TIMESTAMP            timestamp not null,
   TRANSACTIONS_ID      int not null,
   ACCOUNT_ID           int not null,
   CON_TRANSACTIONS_ID  int,
   CUS_TRANSACTIONS_ID  int,
   primary key (TRANSACTIONS_ID)
);

alter table ACCOUNT add constraint FK_CUSTOMER_TO_ACCOUNT foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID) on delete restrict on update restrict;

alter table CHECKING_ACCOUNT add constraint FK_ACCOUNT_TYPE foreign key (ACCOUNT_ID)
      references ACCOUNT (ACCOUNT_ID) on delete restrict on update restrict;

alter table CHECKING_ACCOUNT add constraint FK_CUSTODY_TO_CHECKINGACCOUNT2 foreign key (CUS_ACCOUNT_ID)
      references CUSTODY_ACCOUNT (ACCOUNT_ID) on delete restrict on update restrict;

alter table CUSTODY_ACCOUNT add constraint FK_ACCOUNT_TYPE2 foreign key (ACCOUNT_ID)
      references ACCOUNT (ACCOUNT_ID) on delete restrict on update restrict;

alter table CUSTODY_ACCOUNT add constraint FK_CUSTODY_TO_CHECKINGACCOUNT foreign key (CHE_ACCOUNT_ID)
      references CHECKING_ACCOUNT (ACCOUNT_ID) on delete restrict on update restrict;

alter table CUSTOMER add constraint FK_BANK_TO_CUSTOMER foreign key (BANK_ID)
      references BANK (BANK_ID) on delete restrict on update restrict;

alter table SAVINGS_ACCOUNT add constraint FK_ACCOUNT_TYPE3 foreign key (ACCOUNT_ID)
      references ACCOUNT (ACCOUNT_ID) on delete restrict on update restrict;

alter table SAVINGS_ACCOUNT add constraint FK_SAVINGS_TO_CHECKINGACCOUNT foreign key (CHE_ACCOUNT_ID)
      references CHECKING_ACCOUNT (ACCOUNT_ID) on delete restrict on update restrict;

alter table STOCKS_PORTFOLIO add constraint FK_PORTFOLIO_TO_CUSTODYACCOUNT foreign key (ACCOUNT_ID)
      references CUSTODY_ACCOUNT (ACCOUNT_ID) on delete restrict on update restrict;

alter table TRANSACTION add constraint FK_ACCOUNT_TO_TRANSACTION foreign key (ACCOUNT_ID)
      references ACCOUNT (ACCOUNT_ID) on delete restrict on update restrict;

alter table TRANSACTION add constraint FK_TRANSACTION_TO_CONTRATRANSACTION foreign key (TRANSACTIONS_ID)
      references CONTRA_ACCOUNT (TRANSACTIONS_ID) on delete restrict on update restrict;

alter table TRANSACTION add constraint FK_TRANSACTION_TO_CUSTODYTRANSACTION foreign key (TRANSACTIONS_ID)
      references CUSTODY_TRANSACTION (TRANSACTIONS_ID) on delete restrict on update restrict;

