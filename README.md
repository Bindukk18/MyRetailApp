# MyRetailApp
This is a Rest application which provides two end points.

    1] The GET API  fetches  the product name from an external API.

       The API combines the fetched name with the pricing information from MongoDB  data store  into a single response.

    2] The PUT API  takes the product information from the request and stored in the MongoDB database.


Technology Stack:

    1.Install Maven  - https://maven.apache.org/install.html

    2.Install MongoDB in your system - https://docs.mongodb.com/manual/installation/
       Run MongoDB - Run 'mongod.exe' in order to start Mongodb
      Command line or any MongoDb cleints like Robo3t /Nosql booaster can be used for a better visualisation.
      
   
    3. Clone the code from git repository - https://github.com/Bindukk18/MyRetailApp.git


    4. Make sure you are in the MyRetailApp directory


    5. Run the following command mvn spring-boot:run


    6. Open browser and visit Swagger. http://localhost:8082/swagger-ui.html


    7. Swagger documentation shows   request and response for GET and PUT requests.


