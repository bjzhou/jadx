#!/bin/bash

$JAVA_HOME/bin/javapackager -deploy -title "Jadx" -vendor "Robin Zhou" -description "Jadx-GUI for mac app bundle." -appclass "jadx.gui.JadxGUI" -native dmg -name "Jadx" -outdir mac_bundle -outfile Jadx -srcdir build/jadx/lib
