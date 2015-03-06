@echo off
cd src
javac -encoding UTF-8 -d ..\bin -cp ..\bin parser\*.java exceptions\*.java gui\*.java test\*.java .\*.java
cd ..
pause
@echo on
