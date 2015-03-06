@echo off
cd src
javadoc -private -author -version -d ..\doc  -classpath ..\bin;..\jflex\java-cup-11a.jar *.java
cd ..
pause
@echo on
