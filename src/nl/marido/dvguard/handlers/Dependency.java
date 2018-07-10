package nl.marido.dvguard.handlers;

import org.bukkit.plugin.Plugin;

import nl.marido.dvguard.DVGuard;

public class Dependency {

public static void checks() {
Plugin deluxevouchers = DVGuard.getInstance().getServer().getPluginManager().getPlugin("DeluxeVouchers");
Plugin worldguard = DVGuard.getInstance().getServer().getPluginManager().getPlugin("WorldGuard");
Plugin worldedit = DVGuard.getInstance().getServer().getPluginManager().getPlugin("WorldEdit");
if (deluxevouchers == null || worldguard == null || worldedit == null) {
System.out.println("Dependencies missing! Make sure you have the following installed:");	
System.out.println("DeluxeVouchers, WorldGuard and WorldEdit.");
DVGuard.getInstance().getPluginLoader().disablePlugin(DVGuard.getInstance());
}
}

}