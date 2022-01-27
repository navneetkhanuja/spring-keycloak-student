# Keycloak integration with Postgresql database

#### MySQL integration didn't worked. Setting field lower_case value to 2 didn't helped

1) Create keycloak schema in postgresql

2) Download postgresql java connector

3) Copy downloaded connector to
   keycloak-16.1.0\modules\system\layers\keycloak\org\postgresql\main
   NOTE - you have to create postgresql\main in com directory

4) On official site of keycloak they have mentioned how to configure keycloak for the above downloaded
   jar. Section on site - `Packaging the JDBC driver`

Copy Module xml content and create module.xml in postgresql\main with the content copied from website.
Update path and name in module.xml to provide jar and name.
https://www.keycloak.org/docs/latest/server_installation/

4) Go to keycloak-16.1.0\standalone\configuration and open standalone.xml

5) Add POSTGRESQL datasource and driver in standalone.xml

6) Start keycloak using standalone.bat.
   At start up keycloak creates tables in schema.

7) Update port if required -
   update below ports as required
   <socket-binding name="http" port="${jboss.http.port:8090}"/>
   <socket-binding name="https" port="${jboss.https.port:8443}"/>

8) Launch Keycloak create admin which user
9) Create User, Roles and Client in keycloak
10) Client is keycloak is the app connecting to keycloak
11) Copy the client name and secret and enter in application.properties

# Keycloak integration with MySQL database

1) Create keycloak schema in mysql 

2) Download mysql java connector from url
https://dev.mysql.com/downloads/connector/j/

3) Copy downloaded connector to
   keycloak-16.1.0\modules\system\layers\keycloak\com\mysql\main
NOTE - you have to create mysql\main in com directory

4) On official site of keycloak they have mentioned how to configure keycloak for the above downloaded 
jar. Section on site - `Packaging the JDBC driver`

Copy Module xml content and create module.xml in mysql\main with the content copied from website.
Update path and name in module.xml to provide jar and name.
https://www.keycloak.org/docs/latest/server_installation/

4) Go to keycloak-16.1.0\standalone\configuration and open standalone.xml

5) Add MYSQL datasource and driver in standalone.xml

6) Start keycloak using standalone.bat. 
   At start up keycloak creates tables in schema.

