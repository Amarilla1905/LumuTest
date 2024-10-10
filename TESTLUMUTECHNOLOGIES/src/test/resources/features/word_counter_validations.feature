Feature: Word counter.
As a user, I want to open the Word Counter page.
I type a random text.
I want to validate the information.

Scenario: Character and words counter without repetition
Given that the user can access the web page.
When it generates random text without repetition of words and is entered in the field
Then the number of characters per word will be validated.
Then the number of words will be validated




