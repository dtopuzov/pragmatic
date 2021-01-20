#!/usr/bin/env bash

##############################################################
# 1. Start MorseCodeTranslator application
# 2. Run Sikuli tests
# 3. Kill the app
##############################################################

java -jar morsecodetranslator.jar &
java -jar $SIKULI_HOME/sikulix.jar -r sikuli-ide-demo-mac.sikuli
pkill java
