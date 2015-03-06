@echo off

cd src
echo Generating lexical analyzer...
java -jar ..\lib\JFlex.jar oberon.flex 
echo Generating parser...
java -jar ..\javacup\java-cup-11a.jar  -parser Parser -symbols Symbol oberon.cup 

javac -d ..\bin exceptions\*.java
javac -d ..\bin -classpath ..\bin;..\lib\jgraph.jar;..\lib\callgraph.jar;..\lib\flowchart.jar;..\javacup\java-cup-11a.jar *.java
cd .. 
pause

@echo on
