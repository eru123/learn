# This is an example usage of "git alias"
# git commit -am "update" && git push
git config --global alias.up "!git commit -am update && git push"
git config --global alias.save "!git add . && git commit -am update && git push"  