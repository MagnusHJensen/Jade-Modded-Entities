package dk.magnusjensen.jademoddedentities.integrations.vanilla;

import dk.magnusjensen.jademoddedentities.Constants;
import dk.magnusjensen.jademoddedentities.integrations.JadeRegistration;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.npc.Villager;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;

public enum VillagerComponentProvider implements IEntityComponentProvider, IServerDataProvider<EntityAccessor>, JadeRegistration {
    INSTANCE;

    private static final ResourceLocation UID = Constants.rl("villager");

    @Override
    public void initClient(IWailaClientRegistration registration) {
        registration.registerEntityComponent(INSTANCE, Villager.class);
    }

    @Override
    public void init(IWailaCommonRegistration registration) {
        registration.registerEntityDataProvider(INSTANCE, Villager.class);
    }

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        if (entityAccessor.getServerData().contains("BreedingCD", 3)) {
            int time = entityAccessor.getServerData().getInt("BreedingCD");
            if (time > 0) {
                iTooltip.add(Component.translatable("jme.villager.breeding", IThemeHelper.get().seconds(time, entityAccessor.tickRate())));
            }

        }
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
        Entity entity = entityAccessor.getEntity();
        var time = ((Villager)entity).getAge();

        if (time > 0) {
            compoundTag.putInt("BreedingCD", time);
        }
    }
}
