@echo off

rd /S/Q bin
rd /S/Q doc
rd /S/Q testcases\reports

echo "Clean all builded file"
mkdir bin
mkdir doc
mkdir testcases\reports

pause
@echo on