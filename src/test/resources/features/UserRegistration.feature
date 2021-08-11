Feature: Verification of UserRegistration in GMAIL

  Scenario Outline: Verify user Registration
    And Make Post call from "<Payload>" with "<Endpoint>" and save response as variable and check if status is "<ResponseCode>"
    Then Validate response body json with "<expectedJsonFile>"
    Examples:
      | Payload                                     | Endpoint           | ResponseCode | expectedJsonFile                   |
      | test_data/RequestJson.json                  | /user/registration | 200          | test_data/ValidJsonResponse.json   |
      | test_data/InvalidJsonRequestFormat.json     | /user/registration | 400          | test_data/InvalidJsonResponse.json |
      | test_data/InvalidJsonRequestBlankEmail.json | /user/registration | 400          | test_data/InvalidJsonResponse.json |
      | test_data/RequestJson.json                  | /user/register     | 404          | test_data/InvalidJsonResponse.json |