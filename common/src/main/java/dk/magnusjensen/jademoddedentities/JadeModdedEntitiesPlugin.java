package dk.magnusjensen.jademoddedentities;

import dk.magnusjensen.jademoddedentities.integrations.vanilla.VillagerComponentProvider;
import dk.magnusjensen.jademoddedentities.platform.Services;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadeModdedEntitiesPlugin implements IWailaPlugin {
    @Override
    public void register(IWailaCommonRegistration registration) {
        IWailaPlugin.super.register(registration);

        VillagerComponentProvider.INSTANCE.init(registration);

        // We delegate registration to the individual component, to avoid loading class references of optional mods.
        Services.PLATFORM.registerIntegrations(registration);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        IWailaPlugin.super.registerClient(registration);

        VillagerComponentProvider.INSTANCE.initClient(registration);
        // We delegate registration to the individual component, to avoid loading class references of optional mods.
        Services.PLATFORM.registerClientIntegrations(registration);
    }
}
