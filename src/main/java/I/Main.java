package I;

//-----imports-----//

import arc.Events;
import arc.util.CommandHandler;
import arc.util.Log;
import mindustry.Vars;
import mindustry.entities.type.Player;
import mindustry.game.EventType;
import mindustry.game.Team;
import mindustry.gen.Call;
import mindustry.net.Administration;
import mindustry.plugin.Plugin;
import org.json.JSONObject;

import java.util.ArrayList;


public class Main extends Plugin {
    private JSONObject settings;
    public static JSONObject data = new JSONObject(); //token, channel_id, role_id
    private boolean enabled = true;

    public static ArrayList<String> draug = new ArrayList<>();
    public static ArrayList<String> spirit = new ArrayList<>();
    public static ArrayList<String> phantom = new ArrayList<>();
    public static ArrayList<String> wraith = new ArrayList<>();
    public static ArrayList<String> ghoul = new ArrayList<>();
    public static ArrayList<String> revenant = new ArrayList<>();
    public static ArrayList<String> dagger = new ArrayList<>();
    public static ArrayList<String> crawler = new ArrayList<>();
    public static ArrayList<String> titan = new ArrayList<>();
    public static ArrayList<String> fortress = new ArrayList<>();

    public Main() throws InterruptedException {
        if (!byteCode.hasDir("mind_db")) byteCode.mkdir("mind_db");
        if (!byteCode.has("imperium"+Administration.Config.port.num())) {
            data.put("draug-factory", 50);
            data.put("spirit-factory", 35);
            data.put("phantom-factory", 35);
            data.put("wraith-factory", 30);
            data.put("ghoul-factory", 30);
            data.put("revenant-factory", 30);
            data.put("dagger-factory", 50);
            data.put("crawler-factory", 30);
            data.put("titan-factory", 50);
            data.put("fortress-factory", 50);

            byteCode.make("imperium"+Administration.Config.port.num(), data);
        }
        data = byteCode.get("imperium"+Administration.Config.port.num());
        auto a = new auto(Thread.currentThread());
        a.setDaemon(false);
        a.start();

        Events.on(EventType.BlockBuildEndEvent.class, event -> {
            if (event.breaking) {
                draug.remove(event.tile.x+","+event.tile.y);
                spirit.remove(event.tile.x+","+event.tile.y);
                phantom.remove(event.tile.x+","+event.tile.y);
                wraith.remove(event.tile.x+","+event.tile.y);
                ghoul.remove(event.tile.x+","+event.tile.y);
                revenant.remove(event.tile.x+","+event.tile.y);
                dagger.remove(event.tile.x+","+event.tile.y);
                crawler.remove(event.tile.x+","+event.tile.y);
                titan.remove(event.tile.x+","+event.tile.y);
                fortress.remove(event.tile.x+","+event.tile.y);
            }
            if (!event.breaking) {
                switch (event.tile.cblock().name) {
                    case "draug-factory":
                        draug.add(event.tile.x+","+event.tile.y);
                        break;
                    case "spirit-factory":
                        Main.spirit.add(event.tile.x+","+event.tile.y);
                        break;
                    case "phantom-factory":
                        Main.phantom.add(event.tile.x+","+event.tile.y);
                        break;
                    case "wraith-factory":
                        Main.wraith.add(event.tile.x+","+event.tile.y);
                        break;
                    case "ghoul-factory":
                        Main.ghoul.add(event.tile.x+","+event.tile.y);
                        break;
                    case "revenant-factory":
                        Main.revenant.add(event.tile.x+","+event.tile.y);
                        break;
                    case "dagger-factory":
                        Main.dagger.add(event.tile.x+","+event.tile.y);
                        break;
                    case "crawler-factory":
                        Main.crawler.add(event.tile.x+","+event.tile.y);
                        break;
                    case "titan-factory":
                        Main.titan.add(event.tile.x+","+event.tile.y);
                        break;
                    case "fortress-factory":
                        Main.fortress.add(event.tile.x+","+event.tile.y);
                        break;
                    default:
                        break;
                }
            }

        });
        Events.on(EventType.BlockDestroyEvent.class, event -> {
            draug.remove(event.tile.x+","+event.tile.y);
            spirit.remove(event.tile.x+","+event.tile.y);
            phantom.remove(event.tile.x+","+event.tile.y);
            wraith.remove(event.tile.x+","+event.tile.y);
            ghoul.remove(event.tile.x+","+event.tile.y);
            revenant.remove(event.tile.x+","+event.tile.y);
            dagger.remove(event.tile.x+","+event.tile.y);
            crawler.remove(event.tile.x+","+event.tile.y);
            titan.remove(event.tile.x+","+event.tile.y);
            fortress.remove(event.tile.x+","+event.tile.y);
        });
        Events.on(EventType.GameOverEvent.class, event -> {
            draug.clear();
            spirit.clear();
            phantom.clear();
            wraith.clear();
            ghoul.clear();
            revenant.clear();
            dagger.clear();
            crawler.clear();
            titan.clear();
            fortress.clear();
        });
        Events.on(EventType.WorldLoadEvent.class, event -> {
            draug.clear();
            spirit.clear();
            phantom.clear();
            wraith.clear();
            ghoul.clear();
            revenant.clear();
            dagger.clear();
            crawler.clear();
            titan.clear();
            fortress.clear();

            Vars.netServer.admins.addActionFilter(action -> {
                if (action.player == null) return true;
                if (action.player.uuid == null) return true;
                if (!byteCode.has("imperium"+Administration.Config.port.num())) {
                    Log.err("mind_db/ does not contain `imperium.cn`");
                    return true;
                }
                data = byteCode.get("imperium"+Administration.Config.port.num());
                if (action.type == Administration.ActionType.placeBlock) {
                    switch (action.block.name) {
                        case "draug-factory":
                            if (draug.size() < data.getInt("draug-factory")) {
                                return true;
                            }
                            action.player.sendMessage("Unable to Build "+action.block.name+" because there are too many of them in the map.");
                            return false;
                        case "spirit-factory":
                            if (spirit.size() < data.getInt("spirit-factory")) {
                                return true;
                            }
                            action.player.sendMessage("Unable to Build "+action.block.name+" because there are too many of them in the map.");
                            return false;
                        case "phantom-factory":
                            if (phantom.size() < data.getInt("phantom-factory")) {
                                return true;
                            }
                            action.player.sendMessage("Unable to Build "+action.block.name+" because there are too many of them in the map.");
                            return false;
                        case "wraith-factory":
                            if (wraith.size() < data.getInt("wraith-factory")) {
                                return true;
                            }
                            action.player.sendMessage("Unable to Build "+action.block.name+" because there are too many of them in the map.");
                            return false;
                        case "ghoul-factory":
                            if (ghoul.size() < data.getInt("ghoul-factory")) {
                                return true;
                            }
                            action.player.sendMessage("Unable to Build "+action.block.name+" because there are too many of them in the map.");
                            return false;
                        case "revenant-factory":
                            if (revenant.size() < data.getInt("revenant-factory")) {
                                return true;
                            }
                            action.player.sendMessage("Unable to Build "+action.block.name+" because there are too many of them in the map.");
                            return false;
                        case "dagger-factory":
                            if (dagger.size() < data.getInt("dagger-factory")) {
                                return true;
                            }
                            action.player.sendMessage("Unable to Build "+action.block.name+" because there are too many of them in the map.");
                            return false;
                        case "crawler-factory":
                            if (crawler.size() < data.getInt("crawler-factory")) {
                                return true;
                            }
                            action.player.sendMessage("Unable to Build "+action.block.name+" because there are too many of them in the map.");
                            return false;
                        case "titan-factory":
                            if (titan.size() < data.getInt("titan-factory")) {
                                return true;
                            }
                            action.player.sendMessage("Unable to Build "+action.block.name+" because there are too many of them in the map.");
                            return false;
                        case "fortress-factory":
                            if (fortress.size() < data.getInt("fortress-factory")) {
                                return true;
                            }
                            action.player.sendMessage("Unable to Build "+action.block.name+" because there are too many of them in the map.");
                            return false;
                        default:
                            return true;
                    }
                }
                return true;
            });
        });
    }
    public void registerServerCommands(CommandHandler handler){
        if (enabled) {
            handler.register("imperium-clear","<l>", "generates new nas.cn file", arg -> {
                data = new JSONObject();
                data.put("draug-factory", 50);
                data.put("spirit-factory", 35);
                data.put("phantom-factory", 35);
                data.put("wraith-factory", 30);
                data.put("ghoul-factory", 30);
                data.put("revenant-factory", 30);
                data.put("dagger-factory", 50);
                data.put("crawler-factory", 30);
                data.put("titan-factory", 50);
                data.put("fortress-factory", 50);
                byteCode.save("imperium"+Administration.Config.port.num(), data);

                Log.info("Done");

                for (Player p : Vars.playerGroup.all()) {
                    p.setTeam(Team.crux);
                }
            });
            handler.register("lol", "aaa", arg -> {
                for(int x = 0; x < Vars.world.width(); x++){
                    for(int y = 0; y < Vars.world.height(); y++){
                        //loop through and log all found reactors
                        if(Vars.world.tile(x, y).getTeam() == Team.sharded) {
                            Call.sendMessage(Vars.world.tile(x,y).block().name);
                        }
                    }
                }
            });
        }
    }
}
