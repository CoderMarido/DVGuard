package nl.marido.dvguard.handlers;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import nl.marido.deluxevouchers.events.VoucherRedeemEvent;
import nl.marido.dvguard.DVGuard;
import nl.marido.dvguard.DataHandler;

public class Listeners implements Listener {

	@EventHandler
	public void redeemListener(VoucherRedeemEvent event) {
		Player player = event.getPlayer();
		Location location = player.getLocation();
		WorldGuardPlugin worldguard = (WorldGuardPlugin) DVGuard.getInstance().getServer().getPluginManager().getPlugin("WorldGuard");
		RegionManager manager = worldguard.getRegionManager(location.getWorld());
		ApplicableRegionSet regionset = manager.getApplicableRegions(location);
		for (String name : DataHandler.regions) {
			for (ProtectedRegion region : regionset.getRegions()) {
				if (region.getId().equalsIgnoreCase(name)) {
					String voucher = event.getVoucher();
					if (DataHandler.getVouchers(name).contains(voucher)) {
						player.sendMessage(DataHandler.blockmessage);
						String console = DataHandler.blockconsole;
						console = console.replaceAll("%player%", player.getName());
						console = console.replaceAll("%voucher%", event.getVoucher());
						console = console.replaceAll("%region%", name);
						DVGuard.getInstance().getServer().getConsoleSender().sendMessage(console);
						event.setCancelled(true);
					}
				}
			}
		}
	}

}