-- Tạo bảng "users"
CREATE TABLE users (
    user_id INT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    full_name VARCHAR(100),

);

-- Tạo bảng "address"
CREATE TABLE address (
    address_id INT PRIMARY KEY,
    user_id INT,
    street VARCHAR(100),
    city VARCHAR(50),
    country VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Tạo bảng "categories"
CREATE TABLE categories (
    category_id INT PRIMARY KEY,
    category_name VARCHAR(50)
);

-- Tạo bảng "product"
CREATE TABLE product (
    product_id INT PRIMARY KEY,
    category_id INT,
    product_name VARCHAR(100),
    price DECIMAL(10, 2),
    description TEXT,
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

-- Tạo bảng "comment"
CREATE TABLE comment (
    comment_id INT PRIMARY KEY,
    user_id INT,
    product_id INT,
    comment_text TEXT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

-- Thêm bảng "favorites" với quan hệ nhiều-nhiều giữa "users" và "product"
CREATE TABLE favorites (
    user_id INT,
    product_id INT,
    PRIMARY KEY (user_id, product_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

-- Thêm bảng "orders" và liên kết với "users" và "product"
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    user_id INT,
    product_id INT,
    quantity INT,
    order_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

-- Thêm bảng "role" và "userrole" để xác định quyền của người dùng
CREATE TABLE role (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(50)
);

CREATE TABLE userrole (
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

-- Thêm bảng "menuone"
CREATE TABLE menuone (
    menu_id INT PRIMARY KEY,
    menu_name VARCHAR(50),
    menu_description TEXT
);

-- Thêm bảng "employees" và thêm quan hệ tự tham chiếu
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    user_id INT, -- Trường liên kết với bảng "users"
    manager_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id), -- Liên kết với bảng "users"
);







-- Thêm quan hệ nhiều-nhiều giữa "users" và "menuone" thông qua bảng "userrole"
CREATE TABLE user_menu (
    user_id INT,
    menu_id INT,
    PRIMARY KEY (user_id, menu_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (menu_id) REFERENCES menuone(menu_id)
);

-- Thêm bảng "discount"
CREATE TABLE discount (
    discount_id INT PRIMARY KEY,
    product_id INT,
    discount_percentage INT,
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);
