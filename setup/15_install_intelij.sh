#!/usr/bin/env bash

##############################################################
# Install IntelliJ IDEA Community Edition.
#
# Platform: macOS and Linux (Ubuntu and Mint).
#
# Notes: Force uninstall and install (no checks if exists).
#
##############################################################

source $HOME/.bash_profile

if [[ "$OSTYPE" == "darwin"* ]]; then
    brew cask uninstall intellij-idea-ce
    sudo rm -rf /Applications/IntelliJ*
    brew install --cask intellij-idea-ce
else
    sudo snap remove intellij-idea-community
    sudo snap install intellij-idea-community --classic
fi
