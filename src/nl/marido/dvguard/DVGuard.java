package nl.marido.dvguard;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import nl.marido.dvguard.handlers.Dependency;
import nl.marido.dvguard.handlers.Listeners;
import nl.marido.dvguard.handlers.Updater;

public class DVGuard extends JavaPlugin {

public static DVGuard instance;	

public void onEnable() {
System.out.println("Thank you for using the DVGuard resource.");
instance = this;
saveDefaultConfig();
Dependency.checks();
DataHandler.cache();
Updater.runChecks();
registerListeners();
}

public void registerListeners() {
PluginManager manager = getServer().getPluginManager();
manager.registerEvents(new Listeners(), this);
}

public void onDisable() {
System.out.println("Thank you for using the DVGuard resource.");
}

public static DVGuard getInstance() {
return instance;
}

}