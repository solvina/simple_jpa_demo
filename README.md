# Notes
## General
* Coding itself took me about two hours
* I've spent another hour toying with Postman and testing the application 
  * Some example calls for postman are stored in file **jpa_example.postman_collection.json**
* IntelliJ IDEA Community edition was used for developing and testing this demo
  * it should be easy to import and run this project in another IDEA instance
* The service API is build using REST and JSON

## Design
### Three entities
#### Customer
- firstName
- lastName
- middleName
- email
- phoneNumber
- birthDate
#### Quotation
- beginningOfInsurance
- insuredAmount
- dateOfSigningMortgage
- Customer
#### Subscription
- startDate
- validUntil
- Quotation
### Use cases
Defined by the customer
* Create endpoint for updating Customer attributes.
Endpoint for updating Customer should be able to update and/or remove existing values of any/all attributes.
  * Update user (in postman project)
* Create endpoint for creation of Subscription.
  * Create new subscription
* Create endpoint for retrieving single Subscription object.
  * Get a subscription
* Create endpoint for creation of Quotation
  * Create new quotation

On top of this the service also can return list of each entity, create and update each entity type, 
mostly for testing purposes 

## Implementation
### JPA
* I aimed for simplest implementation possible, therefore the 1:N mapping is marked as EAGER, the more complex entities like Quotation and Subscription contains full references to other objects 
* Dates are in types that are native for JPA and don't need any custom serialization
  * It makes sense to mark the beginning of an insurance as an absolute point in time with an instant 
* All the IDs are longs using auto generate strategy
### JSON/REST
* For objects containing references to other objects I choose the simplest options - everything is being sent in JSON
* Each call returns some object
  * mostly for testing reasons
    * each update call returns the resulting object
  * not a bad approach in general