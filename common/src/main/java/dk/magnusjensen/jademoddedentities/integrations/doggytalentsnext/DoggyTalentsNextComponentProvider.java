package dk.magnusjensen.jademoddedentities.integrations.doggytalentsnext;

import dk.magnusjensen.jademoddedentities.Constants;
import dk.magnusjensen.jademoddedentities.integrations.JadeRegistration;
import dk.magnusjensen.jademoddedentities.utilities.Utils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;

public enum DoggyTalentsNextComponentProvider implements IEntityComponentProvider, JadeRegistration {
    INSTANCE;

    private static final ResourceLocation UID = Constants.rl("doggy_talents_next");


    @Override
    public void initClient(IWailaClientRegistration registration) {
        //registration.registerEntityComponent(INSTANCE, AbstractDog.class);
    }

    @Override
    public void init(IWailaCommonRegistration registration) {

    }

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        /*var dog = (IDog) entityAccessor.getEntity();

        iTooltip.add(Component.literal("Gender: ").append(dog.getDog().getGenderName()));
        iTooltip.add(Component.literal("Levels "));
        for (var type : DogLevel.Type.values()) {
            int level = dog.getDogLevel().getLevel(type);
            String firstChar = Utils.titleCase(type.getName()).substring(0, 1);
            iTooltip.append(Component.literal(firstChar + ": ").append(IThemeHelper.get().info(level)).append(" "));
        }
        iTooltip.add(Component.literal("Mode: ").append(Component.translatable(dog.getDog().getMode().getUnlocalisedName())));*/
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }
}