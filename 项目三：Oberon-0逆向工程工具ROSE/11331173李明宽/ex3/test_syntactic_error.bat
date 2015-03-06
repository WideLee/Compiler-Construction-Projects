@echo off
cd bin
echo Test-001
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticErrors\Factorial.001
echo Test-002
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticErrors\Factorial.008
echo Test-003
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticErrors\Factorial.009

cd ..
pause
@echo on