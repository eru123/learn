#!/bin/bash

# Prune remote branches that no longer exist on remotes
for remote in $(git remote); do
    git remote prune "$remote"
done

# Delete branches whose tracking branch no longer exists
for b in $(git show-ref --heads | cut -c 53-); do
    remote=$(git config "branch.$b.remote")
    if [ ! -z "$remote" ]; then
        x=$(git show-ref | grep "refs/remotes/$remote/$b");
        if [ -z "$x" ]; then
            git branch -D "$b"
        fi
    fi
done