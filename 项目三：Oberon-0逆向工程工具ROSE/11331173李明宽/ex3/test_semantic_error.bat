@echo off
cd bin
echo Test-001
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SemanticErrors\Factorial.001
echo Test-002
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SemanticErrors\Factorial.002
echo Test-003
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SemanticErrors\Factorial.003
echo Test-004
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SemanticErrors\Factorial.004
echo Test-005
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SemanticErrors\Factorial.005
echo Test-006
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SemanticErrors\Factorial.006
echo Test-007
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SemanticErrors\Factorial.007
echo Test-008
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\SemanticErrors\Factorial.008

cd ..
pause
@echo on