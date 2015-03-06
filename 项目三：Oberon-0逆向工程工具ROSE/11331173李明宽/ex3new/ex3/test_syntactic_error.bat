@echo off
cd bin
echo Test-001
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\SyntacticErrors\Factorial.001
echo Test-002
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\SyntacticErrors\Factorial.002
echo Test-003
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\SyntacticErrors\Factorial.003
echo Test-004
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\SyntacticErrors\Factorial.004
echo Test-005
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\SyntacticErrors\Factorial.005
echo Test-006
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\SyntacticErrors\Factorial.006
echo Test-007
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\SyntacticErrors\Factorial.007
echo Test-008
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\SyntacticErrors\Factorial.008
echo Test-009
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\GivenException\SyntacticErrors\Factorial.009

echo Test-010
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticException\Sample.001
echo Test-011
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticException\Sample.002
echo Test-012
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticException\Sample.003
echo Test-013
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticException\Sample.004
echo Test-014
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticException\Sample.005
echo Test-015
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticException\Sample.006
echo Test-016
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticException\Sample.007
echo Test-017
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticException\Sample.008
echo Test-018
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticException\Sample.009
echo Test-019
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\javacup\java-cup-11a.jar OberonMain ..\src\testcases\SyntacticException\Sample.010
cd ..
pause
@echo on