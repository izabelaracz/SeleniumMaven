Scenario: user check all option at once

When user check all option as Check_all
Then text on button is Uncheck All

Scenario: user check all option one by one

When user check all option as all_option
Then text on button is Uncheck All
