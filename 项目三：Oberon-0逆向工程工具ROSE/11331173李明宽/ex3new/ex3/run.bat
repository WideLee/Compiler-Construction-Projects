@echo off
cd bin
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\Sample.obr
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\Factorial.obr
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\Callgraph.obr
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\Sort.obr

cd ..
pause
@echo on