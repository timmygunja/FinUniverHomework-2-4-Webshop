INSERT INTO user(email, password)
VALUES ('email1', 'password1');

INSERT INTO profile(name, surname, phone, address, user_id)
VALUES ('name1', 'surname1', 'phone1', 'address1', 1);

INSERT INTO cart(profile_id)
VALUES (1);

INSERT INTO product(name, description, price)
VALUES ('Prod one', 'some description', 1500),
       ('Prod two', 'some description', 500),
       ('Prod three', 'some description', 2000),
       ('Prod four', 'some description', 1000),
       ('Prod five', 'some description', 3500),
       ('Prod six', 'some description', 4000);

INSERT INTO cart_product(product_id, quantity)
VALUES (1, 5);
