@echo off
cd bin
java -cp ..\jflex\java-cup-11a.jar;. OberonScanner ..\src\testcases\Test.001
java -cp ..\jflex\java-cup-11a.jar;. OberonScanner ..\src\testcases\Test.002
java -cp ..\jflex\java-cup-11a.jar;. OberonScanner ..\src\testcases\Test.003
java -cp ..\jflex\java-cup-11a.jar;. OberonScanner ..\src\testcases\Test.004
java -cp ..\jflex\java-cup-11a.jar;. OberonScanner ..\src\testcases\Test.005
java -cp ..\jflex\java-cup-11a.jar;. OberonScanner ..\src\testcases\Test.006
java -cp ..\jflex\java-cup-11a.jar;. OberonScanner ..\src\testcases\Test.007
java -cp ..\jflex\java-cup-11a.jar;. OberonScanner ..\src\testcases\Test.008
java -cp ..\jflex\java-cup-11a.jar;. OberonScanner ..\src\testcases\Test.009

cd ..
pause
@echo on