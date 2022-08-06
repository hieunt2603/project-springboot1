/* User master */
CREATE TABLE IF NOT EXISTS m_user (
    user_id VARCHAR(50) PRIMARY KEY
  , password VARCHAR(100)
  , user_name VARCHAR(50)
  , birthday DATE
  , age INT
  , gender INT
  , department_id INT
  , role VARCHAR(50)
);
/* customer master */
CREATE TABLE IF NOT EXISTS customer (
    customer_id INT identity(1,1) PRIMARY KEY
  , customer_name VARCHAR(200)
  , phone VARCHAR(50)
  , identity VARCHAR(50)
  , user_id VARCHAR(50) NOT NULL
  ,
  CONSTRAINT FK_UserId
  FOREIGN KEY (user_id)
  REFERENCES m_user (user_id)
);
/* merchandise master */
CREATE TABLE IF NOT EXISTS merchandise (
    merchandise_id INT identity(1,1) PRIMARY KEY
  , merchandise_name VARCHAR(200)
  , amount INT
  , money FLOAT
);

/* merchandise master */
CREATE TABLE IF NOT EXISTS invoice_details (
    invoice_details_id INT identity(1,1) PRIMARY KEY
  , customer_id INT NOT NULL,
  CONSTRAINT FK_CustomerId
  FOREIGN KEY (customer_id)
  REFERENCES customer (customer_id)
  , merchandise_id INT NOT NULL,
  CONSTRAINT FK_MerchandiseId
  FOREIGN KEY (merchandise_id)
  REFERENCES merchandise (merchandise_id)
  , inDate Date NULL
  , amount_invoice INT
  , total_money FLOAT
);

/* Department master */
CREATE TABLE IF NOT EXISTS m_department (
    department_id INT PRIMARY KEY
  , department_name VARCHAR(50)
);

/* Salary table */
CREATE TABLE IF NOT EXISTS t_salary (
    user_id VARCHAR(50)
  , year_month VARCHAR(50)
  , salary INT
  , PRIMARY KEY(user_id, year_month)
);
