# How to run tests
Tests are located in "tests" directory where they are separated in 2 groups : Smoke tests and Regression tests

Tests can be run by clicking green arrow button by the @Test annotation.

Tests can be executed via a terminal command, and one group can execute all the tests:

"mvn test -Dgroups=smoke" or "mvn test -Dgroups=regression"

Tests can also be run individually under different names.

For Smoke tests:

"mvn test -Dgroups=add_remove_item", 

"mvn test -Dgroups=buy_multiple_products",

"mvn test -Dgroups=email_contact,

"mvn test -Dgroups=phone_number_contact"

"mvn test -Dgroups=login_user"

"mvn test -Dgroups=register_user"

"mvn test -Dgroups=search_test"

For Regression tests:

"mvn test -Dgroups=buy_products_more_quantity",

"mvn test -Dgroups=buy_with_comment",

"mvn test -Dgroups=shopNow_button",

"mvn test -Dgroups=empty_city_field",

"mvn test -Dgroups=empty_email_field",

"mvn test -Dgroups=empty_firstName_field",

"mvn test -Dgroups=empty_lastName_field",

"mvn test -Dgroups=empty_phoneNumber_field",

"mvn test -Dgroups=empty_streetAddress_field",

"mvn test -Dgroups=empty_zipcode_field",
