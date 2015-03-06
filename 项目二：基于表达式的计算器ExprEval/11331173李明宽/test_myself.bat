@echo off
cd bin
java test.ExprEvalTest ..\testcases\Mytestcases.xml  > ..\testcases\reports\report_Mytestcases.txt
cd ..
type testcases\reports\report_Mytestcases.txt
echo "The result is saved as <testcases\reports\report_Mytestcases.txt>"
pause
@echo on
