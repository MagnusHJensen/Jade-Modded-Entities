package dk.magnusjensen.jademoddedentities.integrations.swem;

import com.alaharranhonor.swem.entity.horse.AbstractSwemHorse;
import dk.magnusjensen.jademoddedentities.Constants;
import dk.magnusjensen.jademoddedentities.integrations.JadeRegistration;
import dk.magnusjensen.jademoddedentities.utilities.Utils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.config.IWailaConfig;
import snownee.jade.impl.ui.HealthElement;
import snownee.jade.impl.ui.TextElement;

public enum SWEMComponentProvider implements IEntityComponentProvider, JadeRegistration {
    INSTANCE;


    private static final ResourceLocation UID = Constants.rl("swem");
    private static final ResourceLocation SWEM_LEVELS = Constants.rl("swem.levels");
    private static final ResourceLocation SWEM_GENDER = Constants.rl("swem.gender");
    public static final ResourceLocation SWEM_COAT = Constants.rl("swem.coat");
    private static final ResourceLocation HIDE_DEFAULT = Constants.rl("swem.hide_default");

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        var entity = entityAccessor.getEntity();
        if (!(entity instanceof AbstractSwemHorse swemHorse)) {
            return;
        }

        this.addSWEMLevels(iTooltip, swemHorse, iPluginConfig, entityAccessor.showDetails());
        this.addSWEMGender(iTooltip, swemHorse, iPluginConfig);
        this.addSWEMCoat(iTooltip, swemHorse, iPluginConfig);
    }

    public void addSWEMLevels(ITooltip tooltip, AbstractSwemHorse swemHorse, IPluginConfig config, boolean isDetailed) {
        if (!config.get(SWEM_LEVELS)) {
            return;
        }

        var affinity = swemHorse.progressionManager.getAffinityLeveling();
        var speed = swemHorse.progressionManager.getSpeedLeveling();
        var health = swemHorse.progressionManager.getHealthLeveling();
        var jump = swemHorse.progressionManager.getJumpLeveling();

        if (!isDetailed) {
            // Show friendly name only
            tooltip.add(Component.translatable("jme.swem.levels",
                affinity.getLevelName(),
                speed.getLevelName(),
                jump.getLevelName(),
                health.getLevelName()
            ));
        } else {
            // Two levels with XP per row
            tooltip.add(affinity.getValueComponent());
            tooltip.append(Component.literal(" "));
            tooltip.append(speed.getValueComponent());

            tooltip.add(jump.getValueComponent());
            tooltip.append(Component.literal(" "));
            tooltip.append(health.getValueComponent());
        }

    }

    public void addSWEMGender(ITooltip tooltip, AbstractSwemHorse swemHorse, IPluginConfig config) {
        if (!config.get(SWEM_GENDER)) {
            return;
        }
        var element = new HealthElement(1, 0);
        if (swemHorse.isInLove()) {
            element = new HealthElement(1, 1);
        }

        tooltip.add(Component.translatable("jme.swem.gender", swemHorse.getBreeding().getName()));

        var isFertile = swemHorse.getBreeding().isFertile();
        if (isFertile) {
            // Only add love heart if fertile
            tooltip.append(element.translate(new Vec2(4, 0)));
        }

        if (swemHorse.getBreeding().isPregnant()) {
            var offset = new Vec2(9, 0);
            if (!isFertile) {
                offset = new Vec2(4, 0);
            }
            tooltip.append(new TextElement(Component.literal("Pregnancy: " + swemHorse.getBreeding().getPregnancyStage() + "%"))
                .translate(offset));
        }
    }

    public void addSWEMCoat(ITooltip tooltip, AbstractSwemHorse swemHorse, IPluginConfig config) {
        if (!config.get(SWEM_COAT)) {
            return;
        }

        var coatId = swemHorse.getCoatBehavior().coat().id().getPath();
        tooltip.add(Component.literal(Utils.titleCase(coatId)), SWEM_COAT);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public void initClient(IWailaClientRegistration registration) {
        registration.registerEntityComponent(INSTANCE, AbstractSwemHorse.class);
        registration.addConfig(SWEM_LEVELS, true);
        registration.addConfig(SWEM_GENDER, true);
        registration.addConfig(SWEM_COAT, true);
        registration.addConfig(HIDE_DEFAULT, true);

        registration.addTooltipCollectedCallback((iTooltip, accessor) -> {
            if (!(accessor.getAccessorType() == EntityAccessor.class)) {
                return;
            }

            EntityAccessor entityAccessor = (EntityAccessor) accessor;
            var entity = entityAccessor.getEntity();
            if (!(entity instanceof AbstractSwemHorse)) {
                return;
            }

            if (IWailaConfig.get().getPlugin().get(HIDE_DEFAULT) && IWailaConfig.get().getPlugin().get(UID)) {
                iTooltip.getTooltip().remove(JadeIds.MC_POTION_EFFECTS);
                iTooltip.getTooltip().remove(JadeIds.MC_HORSE_STATS);
                iTooltip.getTooltip().remove(JadeIds.MC_ENTITY_ARMOR);
            }
        });
    }

    @Override
    public void init(IWailaCommonRegistration registration) {
    }
}
