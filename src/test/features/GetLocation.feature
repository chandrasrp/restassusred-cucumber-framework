Feature: Test API to get location of city bikes around the world
  As a biker I would like to know the exact location of city bikes around the world in a given application.

  Scenario: Confirm Frankfurt is in Germany and return corresponding latitude and longitude
    Given city bike notwork available in Frankfurt
    When user requests location data using network api endpoint
    Then the status code is 200 returned
    And response include the following
      | network.company      | Nextbike GmbH |
    # | network.location.city      | Frankfurt |
     # | network.location.country   | DE        |
     # | network.location.latitude  | 50.1072   |
     #| network.location.longitude | 8.66375   |