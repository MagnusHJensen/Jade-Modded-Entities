package dk.magnusjensen.jademoddedentities;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "jademoddedentities";
	public static final String MOD_NAME = "Jade Modded Entities";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static Identifier rl(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}