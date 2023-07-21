#!/bin/bash

# Git Account Switcher
# Example usage: sudo ./git-switcher.bash <git username here>
user=$1
declare -i iuser=0
declare -a users
declare -a emails
declare -a passwords
declare -a signkeys
declare -a gpgsigns

# Add user account info
users[0]="<your username>"
emails[0]="<your email>"
passwords[0]="<password or token>"
signkeys[0]="<gpg sign key, left blank if no signkey"
gpgsigns[0]="<set to 1 if user will sign the commit using signkey, otherwise blank>"

# get index of user
for i in "${!users[@]}"; do
    if [[ "${users[$i]}" = "${user}" ]]; then
        iuser=$i
    fi
done

# git config set user and email
git config --global user.name "${users[$iuser]}"
git config --global user.email "${emails[$iuser]}"

# if gpgsigns is 1, set gpgsign
if [[ "${gpgsigns[$iuser]}" = "1" ]]; then
    git config --global commit.gpgsign true
    git config --global user.signingkey "${signkeys[$iuser]}"
else
    git config --global commit.gpgsign false
    git config --global user.signingkey ""
fi

# set credential
git config --global credential.helper store

# put the password in the git-credential
printf "protocol=https\nhost=github.com\nusername=${users[$iuser]}\npassword=${passwords[$iuser]}\n" | git credential-store store