@Este
Feature: Text Box

  Scenario Outline: Input data on text fields and validate the submit response
    Given The user navigates to Elements page and text box tab
    When The user fills out and submits the Text box form with "<fullName>" & "<email>" & "<currentAddress>" & "<permanentAddress>"
    Then The user checks the submit response is the same as the information inputted "<fullName>" & "<email>" & "<currentAddress>" & "<permanentAddress>"
    Examples:
      | fullName     | email         | currentAddress        | permanentAddress      |
      | Carlos Gomez | Cg@gemail.com | Carrera 67 # 108 - 49 | Carrera 71 # 120 - 47 |