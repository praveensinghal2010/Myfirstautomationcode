FROM openjdk:8-jre-slim

#A Directory in the base image to copy our depedencies
WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/container-test.jar container-test.jar
ADD  target/container-test-tests.jar container-test-tests.jar
ADD  target/libs libs

# Add the suite xmls
ADD testng.xml testng.xml
ADD pom.xml pom.xml

# Command line to execute the test
# Expects below ennvironment variables
# BROWSER = chrome / firefox
# MODULE  = order-module / search-module
# SELENIUM_HUB = selenium hub hostname / ipaddress

ENTRYPOINT java -cp container-test.jar:container-test-tests.jar:libs/* -DseleniumHubHost=$SELENIUM_HUB -Dbrowser=$BROWSER org.testng.TestNG $MODULE