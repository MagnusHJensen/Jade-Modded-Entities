package dk.magnusjensen.jademoddedentities.platform;

import dk.magnusjensen.jademoddedentities.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public void registerIntegrations(IWailaCommonRegistration registration) {

    }

    @Override
    public void registerClientIntegrations(IWailaClientRegistration registration) {

    }
}
