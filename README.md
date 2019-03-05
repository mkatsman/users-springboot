# users-springboot

The project is the maven spring boot application, called validity-springboot.
The end point is /users/process
It reads all the data from the advanced.csv file located in src/main/resources, finds the unique by email records, then finds duplicates by email and duplicates by last name.
Builds the UsersGroup object with the three collections mentioned above, and prints out all three collections.
The log output is in validity.log in the project's root dir.

To   run it : mvn clean install in the root dir. It will also run tests, some of which are integration test and some test Data Utilities.

The small helper methods are in DataUtils class. I made most of theme static public for possible future reuse.
It is possible that, we reread the csv file several times. This could be optimized, but then we share resources, whis against microservices paradigm.
Honestly I am still looking at why the email and the full name duplicate collections are different, but I would have to dive deeper 
