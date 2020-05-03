package I;

import arc.util.Log;
import arc.util.Strings;
import mindustry.Vars;
import mindustry.game.Team;
import mindustry.net.Administration;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

public class auto extends Thread {
    private Thread mt;
    private int timer;
    private JSONObject data;

    public auto(Thread _mt) {
        mt = _mt;
    }

    public void run(){
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("auto started Successfully!");
        while (mt.isAlive()) {
            try {
                TimeUnit.MINUTES.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Main.data = byteCode.get("imperium"+ Administration.Config.port.num());

            Main.draug.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("draug-factory")) Main.draug.remove(k);
            });
            Main.spirit.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("spirit-factory")) Main.spirit.remove(k);
            });
            Main.phantom.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("phantom-factory")) Main.phantom.remove(k);
            });
            Main.wraith.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("wraith-factory")) Main.wraith.remove(k);
            });
            Main.ghoul.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("ghoul-factory")) Main.ghoul.remove(k);
            });
            Main.revenant.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("revenant-factory")) Main.revenant.remove(k);
            });Main.draug.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("draug-factory")) Main.draug.remove(k);
            });
            Main.dagger.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("dagger-factory")) Main.dagger.remove(k);
            });
            Main.crawler.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("crawler-factory")) Main.crawler.remove(k);
            });
            Main.titan.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("titan-factory")) Main.titan.remove(k);
            });
            Main.fortress.forEach((k) -> {
                String[] gps = k.split(",");
                if (!Vars.world.tile(Strings.parseInt(gps[0]), Strings.parseInt(gps[1])).block().name.equals("fortress-factory")) Main.fortress.remove(k);
            });

            for(int x = 0; x < Vars.world.width(); x++){
                for(int y = 0; y < Vars.world.height(); y++){
                    //loop through and log all found reactors
                    if(Vars.world.tile(x, y).getTeam() == Team.sharded) {
                        switch (Vars.world.tile(x,y).block().name) {
                            case "draug-factory":
                                Main.draug.add(x+","+y);
                                break;
                            case "spirit-factory":
                                Main.spirit.add(x+","+y);
                                break;
                            case "phantom-factory":
                                Main.phantom.add(x+","+y);
                                break;
                            case "wraith-factory":
                                Main.wraith.add(x+","+y);
                                break;
                            case "ghoul-factory":
                                Main.ghoul.add(x+","+y);
                                break;
                            case "revenant-factory":
                                Main.revenant.add(x+","+y);
                                break;
                            case "dagger-factory":
                                Main.dagger.add(x+","+y);
                                break;
                            case "crawler-factory":
                                Main.crawler.add(x+","+y);
                                break;
                            case "titan-factory":
                                Main.titan.add(x+","+y);
                                break;
                            case "fortress-factory":
                                Main.fortress.add(x+","+y);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
    }
}
/*
for(int x = 0; x < Vars.world.width(); x++){
                for(int y = 0; y < Vars.world.height(); y++){
                    //loop through and log all found reactors
                    if(Vars.world.tile(x, y).getTeam() == Team.sharded) {
                        if (Vars.world.ltile(x, y).block() instanceof CoreBlock) {
                        } else {
                            Vars.world.tile(x, y).remove();
                        }
                    }
                }
            }
 */