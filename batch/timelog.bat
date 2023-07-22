@REM Scripts that logs the time (m-d-y H:i:s) when executed
@echo off
echo %date:~3,2%-%date:~0,2%-20%date:~6,2% %time:~0,2%:%time:~3,2%:%time:~6,2% >> %~dp0log.txt