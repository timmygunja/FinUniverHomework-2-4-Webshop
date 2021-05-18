INSERT INTO user(email, password)
VALUES ('email1', 'password1');

INSERT INTO profile(name, surname, phone, address, user_id)
VALUES ('name1', 'surname1', 'phone1', 'address1', 1);

INSERT INTO cart(profile_id)
VALUES (1);

INSERT INTO product(name, description, price)
VALUES ('name1', 'description1', 1000);

INSERT INTO cart_product(product_id, quantity)
VALUES (1, 5);
