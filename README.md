### Description
Limits the amount of drone factories.

This plugin saves info to your harddrive. (Windows: `C:\users\<username>\mind_db\imperium<port>.cn` Linux: `/home/<user>/mind_db/imperium<port>.cn`)

### Installing
To install the plugin, download the .jar in releases or build your own jar.  
Then place the jar in your servers mod folder.  
Download the optional Dependacy [cn-core](https://github.com/L0615T1C5-216AC-9437/core-cn) to have easy acces to the mods settings.  

### Configuring
With [cn-core](https://github.com/L0615T1C5-216AC-9437/core-cn):  
to View the settings, you do `get imperium<insert_server_port_here>` on the console.  
To modify the settings, you do `putint imperium<insert_server_port_here> <value_modified> <value>` on the console.  
To reset settings, you do `imperium-clear` on the console.  

Without cn-core:  
To modify settings, you must go to (Windows: `C:\users\<username>\mind_db\imperium<port>.cn`  
Linux: `/home/<user>/mind_db/imperium<port>.cn`) and edit the file as a JSON file.

### Building a Jar

1) download src  
2) run gradlew.bat  
3) go to the plugin folder in cmd. (example: `cd C:\user\one\desk\pluginfolder\`)  
4) type `gradlew jar` and execute  
5) done, look for plugin.jar in pluginfolder\build\libs\  

Note: Highly recommended to use Java 8.  
