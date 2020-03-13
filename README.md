# tests-camel
Camel Tests I have done recently

1. A custom cache that runs on a camel route on rest based service on Jetty server at localhost (127.0.0.1:8080).
2. The cache stores an object when rest service “/rest/custcache/addToCache” + JSON Object  is called and
3. A call to /rest/custcache/getFromCache/{id} shows the subscriber with the provided {id}.  
4. A camel route that reads from a file location, checks if it a json file and then read the file.
5. If the file contains Subscribers array in the form [ {“id”:1,”name”:”S King”,”msisdn”:”9933445566”,”age”:25}{“id”:2,”name”:”A Bhatt”…. ] , it reads the file and splits the unmarshall result.
6. Then the same route marshall individual part (a json chunk as desired) and calls the rest service mentioned in point 2.
7. All are running from a maven build by means of maven compile exec:java as developed using java DSL.
8. Package is “jar” but I have learnt how to convert to “bundle” using maven-bundle plugin and install in local Karaf.
9. MySQL DB Support has been added with Spring ORM with Hibernate.
10. Now application parses the JSON file and inserts into the Database as well as in the Cache.
11. curl -v http://127.0.0.1:8080/rest/custcahe/getFromCache/8 for example retrieves data from cache initially.
12. After 1 minute cache gets expired. Then the same query at step 11, searches data from DB and if found adds to cache.
13. Next time if curl -v http://127.0.0.1:8080/rest/custcahe/getFromCache/8 is executed again before expiration of cache, the data is retrieved from cache itself.
