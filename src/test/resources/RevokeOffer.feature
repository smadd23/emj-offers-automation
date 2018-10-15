Feature: Promote offers to customers

	Promote offers by 
	creating the offer in the new Preview system copied from the old OMS system.
	Upon creation and approval by business user,
	offers get extended to customers for their use in the J4U application.
	
  Background: 
    Given The Test Preview system
      |Environment|local|

  Scenario: Create Offer in the new Preview System
    When Business creates offer in the new Preview System
    Then Offer gets created in Preview
    And Check whether offer is created correctly
    And Check whether only one offer is created
    And Check whether that offer is created with status Preview
    
 Scenario: Promote Offer to customers
    When Business approves offer in the new Preview System
    Then Offer gets approved in Preview
    And Check whether that offer exists
    And if exists Check the status is approved correctly
      
 Scenario: Upon business approval, customers should be able to use the promoted offer
    When Business promotes offer in the new Preview System
    Then Check whether offer exists in J4U
    And Check offer attributes match Preview