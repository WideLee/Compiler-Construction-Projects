@echo off
rd /Q /S bin
mkdir bin
del /Q src\OberonScanner.java src\Parser.java src\*.*~
echo Done.
pause 
@echo on