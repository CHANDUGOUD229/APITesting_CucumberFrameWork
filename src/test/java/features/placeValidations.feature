Feature: validating Place APIs

  @addPlace,@getPlace
  Scenario Outline: Verify if place ids being Successfully added using AddPlace API
    Given Add place payload with "<name>" "<language>" "<address>"
    When  user calls "AddPlaceApi" with "POST" http request
    Then the a api call got success with status code 200
    And "status" in responce body is "OK"
    And "scope" in responce body is "APP"
    And verify place_id created maps to "<name>" using "GetPlaceApi"
    Examples:
      | name   | language | address  |
      | chandu | english  | warangal |
      | aadhya | Telugu   | Hyd      |
      | sravs  | Hindi    | Banglore |

    @deletePlace
    Scenario: verify if Delete place Functionality is working
      Given DeleteAdd place payload
      When  user calls "DeletePlaceApi" with "POST" http request
      Then the a api call got success with status code 200
