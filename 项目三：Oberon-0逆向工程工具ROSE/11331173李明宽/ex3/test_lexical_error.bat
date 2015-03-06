@echo off
cd bin
echo Test-001
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\LexicalErrors\Test.001
echo Test-002
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\LexicalErrors\Test.002
echo Test-003
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\LexicalErrors\Test.003
echo Test-004
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\LexicalErrors\Test.004
echo Test-005
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\LexicalErrors\Test.005
echo Test-006
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\LexicalErrors\Test.006
echo Test-007
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\LexicalErrors\Test.007
echo Test-008
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\LexicalErrors\Test.008
echo Test-009
java -classpath .;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\java-cup-11a.jar OberonMain ..\src\testcases\LexicalErrors\Test.009

cd ..
pause
@echo on