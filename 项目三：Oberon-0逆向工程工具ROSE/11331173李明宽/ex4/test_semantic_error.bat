@echo off
cd bin
echo Test-001
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\SemanticErrors\Factorial.001
echo Test-002
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\SemanticErrors\Factorial.002
echo Test-003
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\SemanticErrors\Factorial.003
echo Test-004
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\SemanticErrors\Factorial.004
echo Test-005
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\SemanticErrors\Factorial.005
echo Test-006
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\SemanticErrors\Factorial.006
echo Test-007
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\SemanticErrors\Factorial.007
echo Test-008
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\GivenException\SemanticErrors\Factorial.008


echo Test-009
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\SemanticException\Sample.001
echo Test-010
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\SemanticException\Sample.002
echo Test-011
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\SemanticException\Sample.003
echo Test-012
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\SemanticException\Sample.004
echo Test-013
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\SemanticException\Sample.005
echo Test-014
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\SemanticException\Sample.006
echo Test-015
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\SemanticException\Sample.007
echo Test-016
java -classpath .;..\lib\jgraph.jar;..\lib\flowchart.jar OberonMain ..\src\testcases\SemanticException\Sample.008
cd ..
pause
@echo on