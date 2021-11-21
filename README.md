Location Simulator Project

Author: Karthiga Mohan
Date: 20-11-2021

Purpose: 
The project aims to find all the geolocation points on road between two given points at constant intervals.

Working: 
Google Directions API is employed to get all the legs between a given start and end point. 
Each of this leg usually has a start and end point and an amount of distance to be covered in a straight line via road. 
In this project, we attempt to divide each of the leg into equal intervals of 50m each using some basic co-ordinate geometry. 
The assumption here being that the distance to be covered between two points in a leg is usually a straight line (i.e. at a constant angle).


Progress State: The application comes up and test case via the Controller test is employed to test an input of values. 
 

