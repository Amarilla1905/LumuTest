Feature: Word counter.
  As a user, I want to open the Word Counter page.
  I type a random text.
  I want to validate the information repeat.

  Scenario: Character and words counter with repetition
    Given that the user can access the web page.
    When it generates random text with repetition of words and is entered in the field
    Then the words more repeat

