@echo off
cd src
javadoc -private -author -version -d ..\doc -classpath .;..\bin;..\lib\callgraph.jar;..\lib\flowchart.jar;..\lib\jgraph.jar;..\lib\java-cup-11a.jar  *.java 
pause 
@echo on