@echo off
cd src\JUnit
javac -classpath junit-4.9.jar testParser.java Parser.java ExceptionManager.java
java -classpath "junit-4.9.jar;." -ea org.junit.runner.JUnitCore testParser 
cd ..
pause
@echo on
