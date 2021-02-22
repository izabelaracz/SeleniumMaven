Scenario: user click on autocloseable success message and wait untill alert disappears

When user click on autocloseable success message
And user waits until success alert disappears
Then autocloseable success message is clickable again

Scenario: user click on autocloseable warning message and wait untill alert disappears

When user click on autocloseable warning message
And user waits until warning alert disappears
Then autocloseable warning message is clickable again

Scenario: user click on autocloseable danger message and wait untill alert disappears

When user click on autocloseable danger message
And user waits until danger alert disappears
Then autocloseable danger message is clickable again

Scenario: user click on autocloseable success message and wait untill alert disappears

When user click on autocloseable info message
And user waits until info alert disappears
Then autocloseable info message is clickable again