package dk.magnusjensen.jademoddedentities.platform;

import dk.magnusjensen.jademoddedentities.integrations.swem.SWEMComponentProvider;
import dk.magnusjensen.jademoddedentities.integrations.swemaddendum.SWEMAddendumComponentProvider;
import dk.magnusjensen.jademoddedentities.platform.services.IPlatformHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public void registerIntegrations(IWailaCommonRegistration registration) {
        if (isModLoaded("swem")) {
            SWEMComponentProvider.INSTANCE.init(registration);
        }

        if (isModLoaded("swemaddendum")) {
            SWEMAddendumComponentProvider.INSTANCE.init(registration);
        }
    }

    @Override
    public void registerClientIntegrations(IWailaClientRegistration registration) {
        if (isModLoaded("swem")) {
            SWEMComponentProvider.INSTANCE.initClient(registration);
        }

        if (isModLoaded("swemaddendum")) {
            SWEMAddendumComponentProvider.INSTANCE.initClient(registration);
        }
    }
}