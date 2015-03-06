@echo off
cd bin
java -cp ..\jflex\java-cup-11a.jar;. OberonScanner ..\src\testcases\Sample.obr
cd ..
pause
@echo on
