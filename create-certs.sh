#!/bin/bash

keytool -genkeypair -alias client-app -keyalg RSA -keysize 2048 -storetype JKS -keystore client-app.jks -validity 3650 -ext SAN=dns:localhost,ip:127.0.0.1
keytool -genkeypair -alias server-app -keyalg RSA -keysize 2048 -storetype JKS -keystore server-app.jks -validity 3650 -ext SAN=dns:localhost,ip:127.0.0.1

keytool -export -alias client-app -file client-app.crt -keystore client-app.jks

keytool -export -alias server-app -file server-app.crt -keystore server-app.jks

keytool -import -alias server-app -file server-app.crt -keystore client-app.jks
keytool -import -alias client-app -file client-app.crt -keystore server-app.jks
