@echo off
javac -d bin -classpath bin src\exceptions\*.java
javac -d bin -classpath bin src\sym.java
javac -d bin -classpath bin;jflex\java-cup-11a.jar src\OberonScanner.java
pause
@echo on
