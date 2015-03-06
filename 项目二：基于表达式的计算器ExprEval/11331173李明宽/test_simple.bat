@echo off
cd bin
java test.ExprEvalTest ..\testcases\simple.xml > ..\testcases\reports\report_simple.txt
cd ..
type testcases\reports\report_simple.txt
echo "The result is saved as <testcases\reports\report_simple.txt>"
pause
@echo on
