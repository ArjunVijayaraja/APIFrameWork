Feature: Validating Place APIs


#----THis is normal way - without using Examples or Parameters------
#Scenario: Verify if Add Place is being Successfully add using AddPlace API
#	Given Add Place Payload
#	When user calls "AddPlaceAPI" with POST http request
#	Then the API call is success with status code 200
#  	And "status" in response body is "OK" 
#  	And "scope" in response body is "APP"
   	
   
 #-- This is Scenario Outline -- passing data dynamically-----	
Scenario Outline: Verify if Add Place is being Successfully add using AddPlace API
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" http request
	Then the API call is success with status code 200
   	And "status" in response body is "OK" 
   	And "scope" in response body is "APP"
   	
 Examples:
	|name		|language	|address				|
	|A-house	|English	|World Cross Center		|
	|B-house	|Tamil		|Coimbatore				|
   	
