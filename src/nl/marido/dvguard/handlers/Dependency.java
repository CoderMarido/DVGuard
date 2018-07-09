package nl.marido.dvguard.handlers;

import org.bukkit.plugin.Plugin;

import nl.marido.dvguard.Resource;

public class Dependency {

public static void checks() {
Plugin deluxevouchers = Resource.getInstance().getServer().getPluginManager().getPlugin("DeluxeVouchers");
Plugin worldguard = Resource.getInstance().getServer().getPluginManager().getPlugin("WorldGuard");
if (deluxevouchers == null || worldguard == null) {
System.out.println("Dependencies missing! Make sure you have the following installed:");	
System.out.println("DeluxeVouchers and WorldGuard.");
Resource.getInstance().getPluginLoader().disablePlugin(Resource.getInstance());
}
}

}