@ECHO OFF
set oriPath=%~dp0
cd ..\Server\
cls
java -Xms1024M -Xmx1024M -jar spigot-1.16.3.jar -o true nogui
PAUSE
cd %oriPath%
cls