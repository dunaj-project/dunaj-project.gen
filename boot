#!/bin/sh

BOOT_JVM_OPTIONS='-client -XX:+TieredCompilation -XX:TieredStopAtLevel=1 -Xverify:none' ./boot.sh $@
