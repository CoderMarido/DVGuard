package nl.marido.dvguard;

import org.bukkit.plugin.java.JavaPlugin;

import nl.marido.dvguard.handlers.Dependency;
import nl.marido.dvguard.handlers.Listeners;

public class Resource extends JavaPlugin {

public static Resource instance;	

public void onEnable() {
System.out.println("Thank you for using the DVGuard resource.");
instance = this;
saveDefaultConfig();
Dependency.checks();
DataHandler.cache();
//TODO: Add update checker when having a valid Resource-ID.	
getServer().getPluginManager().registerEvents(new Listeners(), this);
}

public void onDisable() {
System.out.println("Thank you for using the DVGuard resource.");
}

public static Resource getInstance() {
return instance;
}

}