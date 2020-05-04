Feature: Automated End2End Tests
				 the purpose of this feature is to test end 2 end integration.
 Scenario Outline: Customer Place an order by purchasing an item from search
    Given user is on home page
    When user searches for "<productName>"
    And  choose to buy two items
    And  moves to check outcart and enter personel details on checkout page and place the order
    Then he can view the order and download the invoice

    Examples: 
      | productName               | 
      | Apple MacBook Pro 13-inch |  
