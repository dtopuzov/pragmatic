#!/usr/bin/env bash

##############################################################
# 1. Start MorseCodeTranslator application
# 2. Run Sikuli tests
# 3. Kill the app
##############################################################

java -jar morsecodetranslator.jar &
java -jar $SIKULI_HOME/sikulixide-2.0.5.jar -r sikuli-ide-demo-mac.sikuli
pkill java
