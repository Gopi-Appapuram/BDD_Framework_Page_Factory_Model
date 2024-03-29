Feature: Myntra Application Testing
	@smoke
  Scenario: Search for a product
    Given I am on the Myntra website
    When I search for any "Product_from_the_excel" in the search textbox
    Then I can see list of product list page

  Scenario: Appaly filters for products by price range and select an item
    Given I can see list of products
    When I applied any filter for price range
    Then I can see only products within the specified price range
    And I select a product with any index from the list

  Scenario: Get product name and price
    Given I am on the product details page
    Then I should see the product name and price

  Scenario: Add a product to Cart
    Given I selected a product variant from the list
    When I add the item to the cart
    And I am on cart page
    Then I can see the item in the cart
    
	Scenario: Navigate to search  page 
		Given Navigate to search details page
		When I select another product with any index from the list
		Then I should see the product name and price
		And I selected a product variant from the list
    When I add the item to the cart
    And I am on cart page
		
  Scenario: Remove product from cart
    Given I can see the item in the cart
    When User removes the items from the cart
    Then User should see an empty cart
    And Close the browser
  
 
 
 
 
 
 
 
 
 