@echo off
@echo Running Testcase 011: missing an operand.
@echo ==============================================
@echo The input is:
type testcases\tc-011.infix
@echo ----------------------------------------------
cd bin

rem : Run the testcase with input direction
java Postfix < ..\testcases\tc-011.infix

rem : Compare the expected output
@echo ----------------------------------------------
@echo The output should be: 
type ..\testcases\tc-011.postfix

cd ..
@echo ==============================================
pause
@echo on
