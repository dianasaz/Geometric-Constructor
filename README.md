# Geometric-Constructor

1. You need to create a sql-database "geometricConstructor";

2. Run GeometricConstructorApplication and see in console there will be saving one full Picture with groups and figures inside;

3. Also you can test REST in Postman:
    1) GET    http://localhost:8080/pictures/       - to see all pictures;
    2) POST   http://localhost:8080/pictures/       - to save new picture with groups and figures (add body, example here);
    3) PUT    http://localhost:8080/pictures/       - to update existing picture (add body);
    4) DELETE http://localhost:8080/pictures/{id}   - to delete existing picture with all groups and figures inside;
    5) GET    http://localhost:8080/pictures/sorted - to see all pictures sorted by last edit date.
    
