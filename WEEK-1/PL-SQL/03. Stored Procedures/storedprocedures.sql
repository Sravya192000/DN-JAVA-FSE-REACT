CREATE TABLE Accounts (
    account_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    account_type VARCHAR2(20),
    balance NUMBER(10,2)
);

INSERT INTO Accounts VALUES (101, 'Rahul', 'Savings', 50000);
INSERT INTO Accounts VALUES (102, 'Priya', 'Savings', 25000);
INSERT INTO Accounts VALUES (103, 'Amit', 'Current', 40000);

COMMIT;

CREATE TABLE Employees (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(100),
    department VARCHAR2(50),
    salary NUMBER(10,2)
);

INSERT INTO Employees VALUES (1,'Ravi','HR',30000);
INSERT INTO Employees VALUES (2,'Sneha','IT',50000);
INSERT INTO Employees VALUES (3,'Kiran','IT',45000);
INSERT INTO Employees VALUES (4,'Anjali','Finance',40000);

COMMIT;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'Savings';

    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM Accounts;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus IN NUMBER
)
AS
BEGIN
    UPDATE Employees
    SET salary = salary + (salary * p_bonus / 100)
    WHERE department = p_department;

    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus('IT',10);
END;
/

SELECT * FROM Employees;

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
)
AS
    v_balance NUMBER;
BEGIN
    SELECT balance
    INTO v_balance
    FROM Accounts
    WHERE account_id = p_from_account;

    IF v_balance >= p_amount THEN
        UPDATE Accounts
        SET balance = balance - p_amount
        WHERE account_id = p_from_account;

        UPDATE Accounts
        SET balance = balance + p_amount
        WHERE account_id = p_to_account;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
    END IF;
END;
/

BEGIN
    TransferFunds(101,102,5000);
END;
/

SELECT * FROM Accounts;
