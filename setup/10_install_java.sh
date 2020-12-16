#!/usr/bin/env bash

##############################################################
# Install Open JDK 1.8,11 and 13.
# Default in .bash_profile will be `Open JDK 8`.
#
# Platform: macOS only, not implemented for Linux.
#
##############################################################

install_java() {
    source "$HOME"/.bash_profile
    declare -a arr=("1.8" "11" "13")
    for i in "${arr[@]}"; do
        set +e
        /usr/libexec/java_home -v "$i" >/dev/null 2>&1
        EXIT_CODE=$?
        set -e
        if [ $EXIT_CODE == 0 ]; then
            echo "Open JDK $i found."
        else
            echo "Install Open JDK $i."
            {
                # Handle Java 1.8 is actually installed with adoptopenjdk8
                if [[ "$i" == "1.8" ]]; then
                    i="8"
                fi

                brew tap adoptopenjdk/openjdk
                brew install --cask adoptopenjdk"$i"
                brew untap adoptopenjdk/openjdk
            } &>"$HOME"/logs/install-java"$i".logs
        fi
    done
}

reset_variables() {
    echo "Set JAVA_HOME in ~/.bash_profile (use JDK 1.8)."
    {
        sed -i '' '/JAVA_HOME/d' "$HOME"/.bash_profile
        echo "export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)" >>"$HOME"/.bash_profile
        source "$HOME"/.bash_profile
    } &>"$HOME"/logs/install-java"$i".logs
}

if [[ "$OSTYPE" == "darwin"* ]]; then
    install_java
    reset_variables
else
    echo "JDK setup not implemented for Linux."
    exit 1
fi
