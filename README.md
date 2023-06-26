# Travel Agency - Tourist Sheet Service

This project is developed as part of the summer 2023 internship program at **[AMSoft Group](https://amsoft-group.com/)**. The goal is to develop a tourist sheet service that allows users to create and manage travel sheets for their trips.

## Description

The tourist sheet service is designed to assist users in planning and organizing their travel plans. 
It provides following features:
- tourist information
- destination details
- travel dates
- flight information
- itinerary of activities.

The application follows a RESTful API architecture and is built using Java 11, Spring Boot 2.x, and PostgreSQL for data storage.

## Technologies Used

- Java 11
- Spring Boot 2.x
- PostgreSQL
- AssertJ

### API Endpoints

The following API endpoints are available:

- `Endpoint: /api/v1/tourist-sheets`

  #### Create a Tourist Sheet:
  - Method: `POST`
  - Request Body: `JSON` representation of the tourist sheet
  - Response: Status code `201 Created` and the created tourist sheet object in the response body, or appropriate error status code with error message

  #### Get All Tourist Sheets:
    - Method: `GET` 
    - Response: Status code `200 OK` and a JSON array of tourist sheet object in the response body, or appropriate error status code with error message


- `Endpoint: /api/v1/tourist-sheets/{id}`

  #### Get a specific Tourist Sheet by ID:

  - Method: `GET` 
  - Response: Status code `200 OK` and the requested tourist sheet object in the response body, or appropriate error status code with error message 
  
  #### Update a Tourist Sheet:

  - Method: `PUT`
  - Request Body: `JSON` representation of the updated Tourist Sheet
  - Response: Status code **`200 OK`** and the updated Tourist Sheet object in the response body, or appropriate error status code with error message
  
  #### Delete a Tourist Sheet by ID:

  - Method: `DELETE`
  - Response: Status code **`204 No Content`** on successful deletion, or appropriate error status code with error message
