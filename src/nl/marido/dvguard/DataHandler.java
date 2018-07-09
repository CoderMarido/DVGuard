package nl.marido.dvguard;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {
	
public static ArrayList<String> regions = new ArrayList<String>();

public static void cache() {
for (String region : Resource.getInstance().getConfig().getStringList("blocked-regions")) {
regions.add(region);
}
}

public static List<String> getVouchers(String region) {
List<String> list = Resource.getInstance().getConfig().getStringList(region);
return list;
}

}