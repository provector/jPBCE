# jPBCE
## Planetbase challenge editor
https://store.steampowered.com/app/403190/Planetbase/

Based on provided guide:
https://steamcommunity.com/sharedfiles/filedetails/?id=677895200

* Disclaimer - I'm not in anyway associated with the game. All work here is purerly made for community purposes and to extend the longevity of this very fun game :) which I greatly enjoy.

Compilation Instructions:
-------------------------

Single JAR:

`mvn clean compile assembly:single`


Known Bugs:
-----------
- UI Can be glitchy sometimes, just switch through tabs to fix it.

Brief "How to"
--------------

All settings in the editor are "OPTIONAL" meaning you can modify one of them and the game engine is "smart" enough to default any other settings based on a planet-class.

"Save Challenge" option will try to save to %HOME%\Documents\Planetbase\Challenges. On some systems, you might get an error. Try creating the directory or use "Save Challenge To" option. It will automatically generate expected files in \Challenges directory. When you start the game your challenge should appear on the list under "JPBCE Editor" group.

Editor also supports storing your challenges for future editing. Use option "Save Editor File" and "Load Editor File" subsequently. Extension is .jpbce, but they are essentialy JSON format. I highly recommend doing this, as currently there's no way of reading back xml file (maybe in the future? with saves support?)

I have tested it as much as I could so please don't hesistate to open an issue if you find one or have some ideas!. If I find free time I'll try to address them. Also, if it gets popular enough I might add Steam Workshop upload option and campaign support.

Enjoy!

_provector

![image](https://user-images.githubusercontent.com/12935423/69186120-d25dd080-0b0f-11ea-9f5f-c2aedde51c82.png)

![image](https://user-images.githubusercontent.com/12935423/69199324-89b60f80-0b2f-11ea-9143-a551b551bb12.png)

![image](https://user-images.githubusercontent.com/12935423/69199360-a3efed80-0b2f-11ea-8f38-fe133443cd30.png)

![image](https://user-images.githubusercontent.com/12935423/69199388-b833ea80-0b2f-11ea-8c6d-17f4fae51f58.png)

![image](https://user-images.githubusercontent.com/12935423/69199401-bf5af880-0b2f-11ea-914c-b08592b1c4da.png)

