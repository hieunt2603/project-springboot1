/* User master */
INSERT INTO m_user (
    user_id
  , password
  , user_name
  , birthday
  , age
  , gender
  , department_id
  , role
) VALUES
('admin@co.jp', '$2a$10$F4zikFcERU.GCMKk3ClrLejvcvArkiH3RgGHDmHafcfl72b2/tba.', 'System Administrator', '2000-01-01', 21, 1, 1, 'ROLE_ADMIN')
, ('user@co.jp', '$2a$10$F4zikFcERU.GCMKk3ClrLejvcvArkiH3RgGHDmHafcfl72b2/tba.', 'User1', '2000-01-01', 21, 2, 2, 'ROLE_GENERAL')
;
/* customer master */
INSERT INTO customer (customer_id,customer_name, phone, identity, user_id)
VALUES(1,'Trần Minh Hoàng', '0906678930', '435673234651', 'admin@co.jp'), 
(2,'Trần Đăng Khoa', '0903357930', '020304050607', 'admin@co.jp'), 
(3,'Lâm Tiến Dũng', '0904465032', '755548992324', 'admin@co.jp'), 
(4,'Nguyễn Thành Toàn', '0307788456', '543476803234', 'user@co.jp'), 
(5,'Trương Hùng Khí', '0202447856', '432589035789', 'user@co.jp'),
(6,'Trần Nhật Thành', '0906678932', '675674534658', 'admin@co.jp'), 
(7,'Lê Tuấn Kiệt', '0903357935', '360300250685', 'admin@co.jp'), 
(8,'Võ Minh Toàn', '0904465089', '855540592378', 'admin@co.jp'), 
(9,'Trung Quốc Chí', '0307788470', '123476633258', 'user@co.jp'), 
(10,'Nguyễn Tấn Dũng', '0202447895', '572581535785', 'user@co.jp');
/* Merchandise master */
INSERT INTO merchandise (merchandise_id,merchandise_name, amount, money)
VALUES(1,'Chuột laze', 60, 35), 
(2,'Bàn phím cơ', 60, 100), 
(3,'Màn hình LCD', 60, 200), 
(4,'Tai nghe voice 2000', 60, 80), 
(5,'Tai nghe HyperX', 60, 75),
(6,'XBox One 360', 60, 45), 
(7,'Chuột Hazed', 60, 35), 
(8,'Màn hình LCD 24 inch', 60, 220);
/* InvoiceDetails master */
INSERT INTO invoice_details (customer_id, merchandise_id, inDate, amount_invoice, total_money)
VALUES(1, 2, '2022-03-05', 1, 100), 
(1, 3, '2022-03-06', 1, 200), 
(2, 6, '2022-03-07', 2, 160), 
(4, 5, '2022-03-08', 3, 225), 
(4, 2, '2022-03-08', 3, 105),
(1, 7, '2022-03-05', 1, 100), 
(1, 7, '2022-03-06', 1, 200);
/* Department master */
INSERT INTO m_department (
    department_id
  , department_name
) VALUES
(1, 'System Management')
, (2, 'Sales')
;

/* Salary table */
INSERT INTO t_salary (
    user_id
  , year_month
  , salary
) VALUES
('user@co.jp', '11/2020', 2800)
, ('user@co.jp', '12/2020', 2900)
, ('user@co.jp', '01/2021', 3000)
;
