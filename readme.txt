README

This is an application built on University of Southern California's geo database and uses spatial databases to store/retireve certain information related to university's wireless access points. 

This App implements spatial data types using Oracle10g, Oracle Spatial features, and Java (JDBC).

App consists of two Java programs to 1) store (populate.java) and 2) query spatial database (hw2UI.java)

Note: 
1.) hw2UI is main file which is run first and which takes command arguments. Therefore to start the program and compile it use the command:
java hw2UI building.xy people.xy ap.xy

2.) Create Database using createdb.sql to create index,metadata and all tables. 

App Link on Youtube:

http://www.youtube.com/watch?v=aBAdWAsNCew

Included files
hw2UI.java
populate.java
createdb.sql
dropdb.sql