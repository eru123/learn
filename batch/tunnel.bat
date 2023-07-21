@REM This script is used to tunnel ports from a remote server to localhost.
@REM It is useful when you want to access a remote server's port from your local machine.
@REM For example, you can use it to access a remote MySQL server from your local machine if you don't want to open the port to the public or you don't have a public IP address.

@echo off
setlocal EnableDelayedExpansion

set ports=%*
if "%ports%"=="" (
    echo Usage: %0 <Local Port 1>:<Server Port 1> [<Local Port 2>:<Server Port 2> ...]
    exit /b 1
)

@rem ssh account
set identityfile=%USERPROFILE%\.ssh\id_rsa
set sshusername=root
set sshhost=
set sshport=
set password=

set sshcmd=ssh -i "%identityfile%" -p %sshport% %sshusername%@%sshhost% -N

@rem tunnel ports, append to sshcmd
for %%p in (%ports%) do (
    for /f "tokens=1,2 delims=:" %%a in ("%%p") do (
        set serverport=%%a
        set localport=%%b
        set sshcmd=!sshcmd! -L !localport!:localhost:!serverport!
    )
)

echo %sshcmd%
call %sshcmd%