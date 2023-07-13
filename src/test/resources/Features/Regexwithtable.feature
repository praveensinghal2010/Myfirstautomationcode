Feature: TestNG

  @Test @Sanity @Reg
  Scenario: Test a table using regex expressions
    Given user is on the home page
    When user click on arrow buttnon
    Then user is able to view the below table
      | Type of Instrument   | Contracts Traded | No. of Trades | Turnover (my image Cr) | Mkt OI (No. Of Contracts)* |
      | Index Option (Call)  |        46,84,310 |     11,05,716 |            2,96,533.00 |                   1,45,430 |
      | Index Future         |              962 |           775 |                  60.67 |                         99 |
      | Equity Future        | -                | -             | -                      |                  34,34,398 |
      | Equity Option (Put)  | -                | -             | -                      |                  10,94,371 |
      | Equity Option (Call) | -                | -             | -                      |                  18,49,473 |
      | Index Option (Put)   |        49,26,393 |     11,13,373 |            3,10,043.15 |                   1,57,702 |
      | Total                |        96,11,665 |     22,19,864 |            6,06,636.81 |                  66,81,473 |

  @Regex1
  Scenario: regex validation
    Given user is on the home page
    When user is not doing anything
    Then user validation below table
      | Key               | Value                        |
      | normal expression | /As in \\d{2}/\\d{2}/\\d{4}/ |
      | hello darling     | /.{1,100}/                   |
