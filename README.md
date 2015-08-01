# Sharts

A small project about Spring, Hibernate, iText, Poi and OpenCSV.

The main goal of this project is:
  - Learn about these technologies
  - Present my knowledge about software development
  - Achieve my dream: work in Germany!

> If I have seen further it is by standing on the shoulders of Giants. [Isaac Newton]

### Version
1.0.

### Tech

Dillinger uses a number of open source projects to work properly:

* [Spring] - helps development to  build a simple, portable,  fast and flexible JVM-based systems and applications
* [Hibernate] - an open source Java persistence framework project. 
* [OpenCSV] - Opencsv is a very simple csv (comma-separated values) parser library for Java.
* [POI] - APIs for manipulating various file formats based upon Microsoft's OLE 2 Compound Document format using pure Java.
* [JFreeChart] - JFreeChart is a free 100% Java chart library that makes it easy for developers to display professional quality charts in their applications. 
* [Postgres] - the world's most advanced open source database.
* [iTextPDF] - iText is an open source PDF library, available in Java and C#. It can be used to enhance your products and applications with PDF functionality

### Installation 

Clone it, dump the database, open it with IntelliJ IDEA.

DDL Postgres:
```sh
CREATE TABLE pie_chart
(
    id SERIAL DEFAULT nextval('pie_chart_id_seq'::regclass) NOT NULL,
    country VARCHAR,
    weight DOUBLE PRECISION
);

CREATE TABLE ring_chart
(
    id SERIAL DEFAULT nextval('ring_chart_id_seq'::regclass) NOT NULL,
    date DATE,
    security VARCHAR,
    weighting DOUBLE PRECISION
);
```

### How to run

Execute the class *run/Application* and done!

Check the *output* folder to see what was generated.

### Todos

 - Write Tests
 - Rethink Github Save
 - Add Code Comments

License
----

MIT

**Thanks :)**