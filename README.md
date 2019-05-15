# Project structure
- /test/src/main/java/test/question/dataMgr/DataLoadAndStore.java: Implement for Question 1
- /test/src/main/java/test/question/retail/website/RetailWebsite.java: Implement for Question 3

- /test/src/test/java/test/unittest/DataLoadAndStoreTest.java: Unit test for Question 1
- /test/src/test/java/test/unittest/RetailWebsiteTest.java: Unit test for Question 3

# Time and memory complexity analysis
#### Question 1
- load: Loop throw n lines to create a map, with each line, loop throw m key-value pairs to put into map, complexity is O(n*m)
- store: Loop throw n items in given array, with each item as a map, loop throw its m entries to append string, complexity is O(n*m)

# How to build project
This project is base on Java language, using maven. So, to build this project, go to the source directory and run the command:

```sh
$ mvn clean install
```
To run all Unit test:

```sh
$ mvn clean test
```

To run each unit test:

```sh
$ mvn clean test -Dtest=test.unittest.DataLoadAndStoreTest
```
or

```sh
$ mvn clean test -Dtest=test.unittest.RetailWebsiteTest
```