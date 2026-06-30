CREATE TABLE Inventory_Product (
    productId NUMBER PRIMARY KEY,
    productName VARCHAR2(100),
    quantity NUMBER,
    price NUMBER(10,2)
);
CREATE OR REPLACE PROCEDURE AddProduct(
    p_id IN NUMBER,
    p_name IN VARCHAR2,
    p_quantity IN NUMBER,
    p_price IN NUMBER
)
AS
BEGIN
    INSERT INTO Inventory_Product
    VALUES (p_id, p_name, p_quantity, p_price);

    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UpdateProduct(
    p_id IN NUMBER,
    p_quantity IN NUMBER,
    p_price IN NUMBER
)
AS
BEGIN
    UPDATE Inventory_Product
    SET quantity = p_quantity,
        price = p_price
    WHERE productId = p_id;

    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE DeleteProduct(
    p_id IN NUMBER
)
AS
BEGIN
    DELETE FROM Inventory_Product
    WHERE productId = p_id;

    COMMIT;
END;
/

BEGIN
    AddProduct(101,'Laptop',20,55000);
    AddProduct(102,'Mouse',50,500);
    AddProduct(103,'Keyboard',30,1200);
END;
/

SELECT * FROM Inventory_Product;

BEGIN
    UpdateProduct(102,60,550);
END;
/

SELECT * FROM Inventory_Product;

BEGIN
    DeleteProduct(103);
END;
/

SELECT * FROM Inventory_Product;