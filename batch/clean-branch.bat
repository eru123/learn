@echo off
for /f "tokens=*" %%a in ('git remote') do (
    echo git remote prune %%a
    git remote prune %%a
)

for /f "tokens=*" %%a in ('git show-ref --heads ^| findstr " refs/heads/"') do (
    set branch=%%a
    set branch=!branch:refs/heads/!=!
    set remote=
    for /f "tokens=*" %%b in ('git config "branch.!branch!.remote"') do (
        set remote=%%b
    )
    if not "!remote!"=="" (
        for /f "tokens=*" %%c in ('git show-ref ^| findstr "refs/remotes/!remote!/!branch!"') do (
            set remote_branch=%%c
        )
        if "!remote_branch!"=="" (
            echo git branch -D !branch!
            git branch -D !branch!
        )
    )
)