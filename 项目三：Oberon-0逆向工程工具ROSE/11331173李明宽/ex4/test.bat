@echo off
echo Now, testing the Lexcial errors.
call test_lexical_error.bat

@echo off
echo Now, testing the Syntactic errors.
call test_syntactic_error.bat

@echo off
echo Now, testing the Semantic errors.
call test_semantic_error.bat
@echo on