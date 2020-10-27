insert into users (id, name) values (1, 'John Doe');
insert into users (id, name) values (2, 'Marry Poppins');

insert into accounts (id, user_id, account_number, account_name, account_type, balance_date, currency)
values (1, 1, '123456789', 'John Doe Savings', 'Savings', '2020-10-27', 'AUD');
insert into accounts (id, user_id, account_number, account_name, account_type, balance_date, currency)
  values (2, 1, '123456790', 'John Doe Checking', 'Current', '2020-10-27', 'AUD');
insert into accounts (id, user_id, account_number, account_name, account_type, balance_date, currency)
  values (3, 2, '123456791', 'Marry Poppins Savings', 'Savings', '2020-10-27', 'AUD');

insert into transactions (id, account_id, transaction_type, amount, transaction_timestamp, transaction_narrative) values (1, 1, 'CREDIT', 1000.00, '2020-10-26 10:00:59', 'Salary');
insert into transactions (id, account_id, transaction_type, amount, transaction_timestamp, transaction_narrative) values (2, 1, 'DEBIT', 1000.00, '2020-10-26 11:00:59', 'Transfer to Checking');
insert into transactions (id, account_id, transaction_type, amount, transaction_timestamp, transaction_narrative) values (3, 2, 'CREDIT', 1000.00, '2020-10-26 11:00:59','Transfer from Savings');
insert into transactions (id, account_id, transaction_type, amount, transaction_timestamp, transaction_narrative) values (4, 2, 'DEBIT', 500.00, '2020-10-26 11:00:59', 'Withdrawal');
insert into transactions (id, account_id, transaction_type, amount, transaction_timestamp, transaction_narrative) values (5, 3, 'CREDIT', 2000.00, '2020-10-27 14:00:59', 'Deposit');