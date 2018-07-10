package nl.marido.dvguard.handlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import nl.marido.dvguard.DVGuard;

public class Updater {

public static void runChecks() {
boolean checkupdates = DVGuard.getInstance().getConfig().getBoolean("check-updates");
if (checkupdates) {
try {
URL checkurl = new URL("https://api.spigotmc.org/legacy/update.php?resource=58540");
URLConnection connection = checkurl.openConnection();
String latestversion = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
String currentversion = DVGuard.getInstance().getDescription().getVersion();
if (latestversion.equals(currentversion)) {
System.out.println("You are running the latest version of DVGuard (" + latestversion + ").");
} else {
System.out.println("You are running an outdated version of DVGuard (" + currentversion + ").");	
}
} catch (Exception error) {
System.out.println("Failed to connect and check for any newer version of DVGuard.");
}
}	
}

}