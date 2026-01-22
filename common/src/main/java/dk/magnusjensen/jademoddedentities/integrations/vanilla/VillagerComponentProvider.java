package dk.magnusjensen.jademoddedentities.integrations.vanilla;

import dk.magnusjensen.jademoddedentities.Constants;
import dk.magnusjensen.jademoddedentities.integrations.JadeRegistration;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.npc.villager.Villager;
import org.jetbrains.annotations.Nullable;
import snownee.jade.addon.vanilla.MobBreedingProvider;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;

public enum VillagerComponentProvider implements StreamServerDataProvider<EntityAccessor, Integer>, JadeRegistration {
    INSTANCE;

    private static final Identifier UID = Constants.rl("villager");

    @Override
    public void initClient(IWailaClientRegistration registration) {
        registration.registerEntityComponent(Client.INSTANCE, Villager.class);
    }

    @Override
    public void init(IWailaCommonRegistration registration) {
        registration.registerEntityDataProvider(INSTANCE, Villager.class);
    }

    @Override
    public Identifier getUid() {
        return UID;
    }

    public @Nullable Integer streamData(EntityAccessor accessor) {
        int time;
        Entity entity = accessor.getEntity();
        time = ((Villager)entity).getAge();

        return time > 0 ? time : null;
    }

    public StreamCodec<RegistryFriendlyByteBuf, Integer> streamCodec() {
        return ByteBufCodecs.VAR_INT.cast();
    }

    public static class Client implements IEntityComponentProvider {
        public static final VillagerComponentProvider.Client INSTANCE = new VillagerComponentProvider.Client();

        public void appendTooltip(ITooltip tooltip, EntityAccessor accessor, IPluginConfig config) {
            int time = VillagerComponentProvider.INSTANCE.decodeFromData(accessor).orElse(0);
            if (time > 0) {
                tooltip.add(Component.translatable("jme.villager.breeding", IThemeHelper.get().seconds(time, accessor.tickRate())));
            }

        }

        public Identifier getUid() {
            return UID;
        }
    }
}
