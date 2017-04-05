
Software Construciton
Lab 6


Introduction:
The Geo City lite CSV file provides information about locations by name, region and lat/long. You must not change the CSV file or add any additional information in the DB besides a primary key. The application will start by checking the DB for any data and in case the data has not been already loaded (first execution), the CSV file is read from the class path and data is loaded in the DB. 
In the 2nd part of the lab you have to allow the user to search for 5 cities closest to a point, identified by its name or a lat/long. For lat/long simply apply the nearby search to locate cities near the lat/long from the stored data. In case of city name, use reverse search to find out the lat/long for that city, before applying the same nearby search algorithm.

Approach: 
Using the jdbc driver and database I imported all the data from CSV and uploaded them to database.
After that the system reads the countries data from the database and suggests the search results based on that.
I have used “The Great Circle Distance Formula”  to find out distance between 2 cities.
The great-circle distance or orthodromic distance is the shortest distance between two points on the surface of a sphere, measured along the surface of the sphere (as opposed to a straight line through the sphere's interior). The distance between two points in Euclidean space is the length of a straight line between them, but on the sphere there are no straight lines. In non-Euclidean geometry, straight lines are replaced by geodesics. Geodesics on the sphere are the great circles (circles on the sphere whose centers coincide with the center of the sphere).
 
 

How to run: 
To run the project you need a IDE such as Netbeans. 
The project has been developed in Netbeans hence contains the netbeans configuration files.
To run the database a SQL server is needed.
The database is running on localhost on port 3306.
