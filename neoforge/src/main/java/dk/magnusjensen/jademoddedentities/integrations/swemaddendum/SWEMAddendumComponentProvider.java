package dk.magnusjensen.jademoddedentities.integrations.swemaddendum;

//import com.evangelix.swemaddendum.abstract_steed.AbstractSteed;
import dk.magnusjensen.jademoddedentities.Constants;
import dk.magnusjensen.jademoddedentities.integrations.JadeRegistration;
import dk.magnusjensen.jademoddedentities.integrations.swem.SWEMComponentProvider;
import dk.magnusjensen.jademoddedentities.utilities.Utils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;

public enum SWEMAddendumComponentProvider implements IEntityComponentProvider, JadeRegistration {
    INSTANCE;

    private static final ResourceLocation UID = Constants.rl("swemaddendum");


    @Override
    public void initClient(IWailaClientRegistration registration) {
        //registration.registerEntityComponent(INSTANCE, AbstractSteed.class);
    }

    @Override
    public void init(IWailaCommonRegistration registration) {

    }

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        /*var entity = entityAccessor.getEntity();
        if (!(entity instanceof AbstractSteed abstractSteed)) {
            return;
        }

        iTooltip.remove(SWEMComponentProvider.SWEM_COAT);
        var breed = abstractSteed.isBaby() ? abstractSteed.getFoalFolderName() : abstractSteed.getFolderName();
        var coat = abstractSteed.isBaby() ? abstractSteed.getFoalCoat() : abstractSteed.getCoat();
        iTooltip.add(Component.literal(Utils.titleCase(coat.getPath())));
        iTooltip.append(Component.literal(" "));
        iTooltip.append(Component.literal(Utils.titleCase(breed)));*/
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }
}
