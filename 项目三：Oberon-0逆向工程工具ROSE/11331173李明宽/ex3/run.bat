@echo off
cd bin

java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\Factorial.obr


java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\Sample.obr


java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\Sort.obr
cd ..
pause
@echo on