package dk.magnusjensen.jademoddedentities.integrations.swem;

/*import com.alaharranhonor.swem.forge.entities.horse.SWEMHorseEntity;
import com.alaharranhonor.swem.forge.entities.horse.SWEMHorseEntityBase;*/
import dk.magnusjensen.jademoddedentities.Constants;
import dk.magnusjensen.jademoddedentities.integrations.JadeRegistration;
import net.minecraft.resources.Identifier;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;
//import snownee.jade.impl.ui.IconElement;
//import snownee.jade.overlay.IconUI;

public enum SWEMComponentProvider implements IEntityComponentProvider, JadeRegistration {
    INSTANCE;


    private static final Identifier UID = Constants.rl("swem");
    private static final Identifier SWEM_LEVELS = Constants.rl("swem.levels");
    private static final Identifier SWEM_GENDER = Constants.rl("swem.gender");
    public static final Identifier SWEM_COAT = Constants.rl("swem.coat");
    private static final Identifier HIDE_DEFAULT = Constants.rl("swem.hide_default");

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        /*var entity = entityAccessor.getEntity();
        if (!(entity instanceof SWEMHorseEntityBase swemHorse)) {
            return;
        }

        this.addSWEMLevels(iTooltip, swemHorse, iPluginConfig, entityAccessor.showDetails());
        this.addSWEMGender(iTooltip, swemHorse, iPluginConfig);
        this.addSWEMCoat(iTooltip, swemHorse, iPluginConfig);
    }

    public void addSWEMLevels(ITooltip tooltip, SWEMHorseEntityBase swemHorse, IPluginConfig config, boolean isDetailed) {
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

    public void addSWEMGender(ITooltip tooltip, SWEMHorseEntityBase swemHorse, IPluginConfig config) {
        if (!config.get(SWEM_GENDER)) {
            return;
        }
        var element = new Icon(IconUI.EMPTY_HEART);
        if (swemHorse.isInLove()) {
            element = new IconElement(IconUI.HEART);
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

    public void addSWEMCoat(ITooltip tooltip, SWEMHorseEntityBase swemHorse, IPluginConfig config) {
        if (!config.get(SWEM_COAT)) {
            return;
        }

        var coatId = swemHorse.getCoatBehavior().coat().id().getPath();
        tooltip.add(Component.literal(Utils.titleCase(coatId)), SWEM_COAT); */
    }

    @Override
    public Identifier getUid() {
        return UID;
    }

    @Override
    public void initClient(IWailaClientRegistration registration) {
        //registration.registerEntityComponent(INSTANCE, SWEMHorseEntity.class);
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
            /*if (!(entity instanceof SWEMHorseEntityBase)) {
                return;
            }

            if (IWailaConfig.get().getPlugin().get(HIDE_DEFAULT) && IWailaConfig.get().getPlugin().get(UID)) {
                iTooltip.remove(Identifiers.MC_POTION_EFFECTS);
                iTooltip.remove(Identifiers.MC_HORSE_STATS);
                iTooltip.remove(Identifiers.MC_ENTITY_ARMOR);
            }*/
        });
    }

    @Override
    public void init(IWailaCommonRegistration registration) {
    }
}
