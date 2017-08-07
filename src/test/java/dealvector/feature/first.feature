Feature:first

  Scenario Outline: Say Hello
    Given I say Hello
    And a book exists with an isbn of <isbn>
    When a user retrieves the book by isbn
    Then the status code is 200
    Then response includes the following
      | kind	   | books#volumes	|
    And response includes the following in any order
      | items.volumeInfo.title 		| <title>	  |
      | items.volumeInfo.publisher 	| <publisher> |
      | items.volumeInfo.pageCount 	| <pageCount> |
    Examples:
      | isbn          | title                 | publisher           | pageCount |
      | 9781451648546 | Steve Jobs            | Simon and Schuster  | 630       |
      | 9781595141880 | Thirteen Reasons why  | Penguin             | 288       |
      | 9780099549482 | To Kill a Mockingbird | Random House        | 307       |