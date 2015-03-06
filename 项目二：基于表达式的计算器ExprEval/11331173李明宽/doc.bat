@echo off
cd src
javadoc -private -author -version -d ..\doc -classpath ..\bin -encoding UTF-8 -charset UTF-8 parser\*.java exceptions\*.java gui\*.java test\*.java .\*.java
cd ..
pause
@echo on
