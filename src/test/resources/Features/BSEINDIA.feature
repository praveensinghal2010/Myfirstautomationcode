Feature: Validate BSE India Navigation Bar

  @Test
  Scenario: Verify navigation options in BSE India navigation bar
    Given I am on the BSE India website
    Then the navigation bar should contain the following options:
      | options                  | value | value2 |
      | Home                     |     1 | A      |
      | About BSE                |     2 | B      |
      | Investor Relations       |     3 | C      |
      | Markets                  |     4 | D      |
      | Public Issues            |     5 | E      |
      | Corporates               |     6 | F      |
      | Members                  |     7 | G      |
      | Investors                |     8 | H      |
      | Market Data Products     |     9 | I      |
      | Training & Certification |     2 | J      |

  @Test @Sanity1
  Scenario: Verify Market summary in BSE India
    Given I am on the BSE India website
    Then the system should contain the following Market summary:
      | As on 20 Jun 23     | 15:29            |               |                 |                           |
      | Type of Instrument  | Contracts Traded | No. of Trades | Turnover (₹ Cr) | Mkt OI (No. Of Contracts) |
      | Index Future        |              144 |           132 |            9.10 |                        34 |
      | Index Option (Call) |            36979 |         22975 |        2,350.33 |                      3903 |
      | Index Option (Put)  |            29966 |         19171 |        1,886.04 |                      4688 |
      | Total               |            67089 |         42278 |        4,245.46 |                      8625 |
