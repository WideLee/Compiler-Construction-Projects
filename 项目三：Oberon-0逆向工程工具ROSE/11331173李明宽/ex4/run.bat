@echo off
cd bin

java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\Sample.obr

java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\Factorial.obr

java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\Callgraph.obr


java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\Sort.obr
cd ..

pause
@echo on