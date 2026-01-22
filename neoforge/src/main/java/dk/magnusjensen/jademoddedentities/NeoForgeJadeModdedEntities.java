package dk.magnusjensen.jademoddedentities;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class NeoForgeJadeModdedEntities {
    
    public NeoForgeJadeModdedEntities(IEventBus bus) {

        CommonClass.init();
        
    }
}