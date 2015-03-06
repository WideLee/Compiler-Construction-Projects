@echo off
cd jflex

java -jar JFlex.jar ..\src\oberon.flex
cd ..
pause
@echo on
