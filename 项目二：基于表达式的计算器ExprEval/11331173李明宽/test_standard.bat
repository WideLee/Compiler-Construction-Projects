@echo off
cd bin
java test.ExprEvalTest ..\testcases\standard.xml  > ..\testcases\reports\report_standard.txt
cd ..
type testcases\reports\report_standard.txt

echo "The result is saved as <testcases\reports\report_standard.txt>"
pause
@echo on
