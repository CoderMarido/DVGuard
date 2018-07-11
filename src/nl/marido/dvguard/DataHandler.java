package nl.marido.dvguard;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class DataHandler {

	public static ArrayList<String> regions;
	public static String blockmessage;

	public static void cache() {
		regions = new ArrayList<String>();
		for (String region : DVGuard.getInstance().getConfig().getStringList("blocked-regions")) {
			regions.add(region);
		}
		blockmessage = DVGuard.getInstance().getConfig().getString("blocked-message");
		blockmessage = ChatColor.translateAlternateColorCodes('&', blockmessage);
	}

	public static List<String> getVouchers(String region) {
		List<String> list = DVGuard.getInstance().getConfig().getStringList(region);
		return list;
	}

}