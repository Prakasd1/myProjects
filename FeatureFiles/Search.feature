Feature: Search for product

  @Search @One
  Scenario: Verify whether the User is able to search for products
    When I search for a product "Samsung SyncMaster 941BW"
    Then I should see the product in the search results address

  @Search @Two
  Scenario: Verify whether the User is informed when the product being searched is not available
    When I search for a product "nexus"
    Then I should see the page displaying the message

  @Search @Three
  Scenario: Verify whether the product is added to the cart
    When I search for a product "Samsung SyncMaster 941BW"
    Then Valdate the exact product named with "Samsung SyncMaster 941BW"
    And Add the product to cart page with product name "Samsung SyncMaster 941BW"
