Scenario: Add two positive numbers

When user enter first value as 2
And user enter second value as 3
Then user submit to get total
Then get total result as 5

Scenario: Add one positive number and other negative

When user enter first value as -2
And user enter second value as 3
Then user submit to get total
Then get total result as 1

Scenario: Add two negative numbers

When user enter first value as -2
And user enter second value as -3
Then user submit to get total
Then get total result as -5

Scenario: Add one number and other a letter

When user enter first value as 2
And user enter second value as a
Then user submit to get total
Then get total result as NaN
