@echo off
cd src
echo Generating lexical analyzer...
java -jar ..\lib\JFlex.jar oberon.flex 
echo Generating parser...
java -jar ..\javacup\java-cup-11a.jar  -parser Parser -symbols Symbol oberon.cup 
cd ..
pause
@echo on