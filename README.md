**LMS - Lead Management System**
        
This Spring Boot based website is for car dealers to view the leads received from various sources like Facebook, etc. 
        from people looking to buy or test drive the car.

Functionality:
- Data is loaded automatically on startup of the project using Dataloader class
- Objects
    - Brand - stores the make of car
    - Brand Variant - stores the model of the car
    - Contact - contact details of the person enquiring to buy a car
    - Lead - stores the information about the request, like type of request, status of request
    - Opportunity - this is an umbrella object to store multiple leads from the same person. Currently, all the Lead information is shown using latest lead field
- The List view and Lead view is based on opportunity
- All the lead information is showing latest lead information
