package lokko12.berriespp;

import org.apache.logging.log4j.LogManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lokko12.berriespp.GTHandler.GTHandler;
import lokko12.berriespp.items.BppItems;
import lokko12.croploadcore.ModsLoaded;

@Mod(
	modid = Berriespp.modID, name = Berriespp.name, version = Berriespp.version,
	dependencies = "required-after:IC2; required-after:croploadcore@0.0.6; after:GalacticraftCore; after:Mantle; after:Natura; after:TConstruct; after:BiomesOPlenty; after:Thaumcraft; after:ExtraTrees; after:witchery; after:gregtech"
	)

public class Berriespp {
	public static final String name = "Berries++";
	public static final String version = "@version@";
	public static final String modID = "berriespp";
	public static final org.apache.logging.log4j.Logger bpplogger = LogManager.getLogger(name);

	@Instance(value = "Berries++")
	public static Berriespp instance;


	@EventHandler
	public void preInit(FMLPreInitializationEvent preinit) {
		// (=<`:9876Z4321UT.-Q+*)M'&%$H\"!~}|Bzy?=|{z]KwZY44Eq0/{mlk**hKs_dG5[m_BA{?-Y;;Vb'rR5431M}/.zHGwEDCBA@98\\6543W10/.R,+O<
		/*if(InstalledTreesGetter.check_bonsai(preinit))
			InstalledTreesGetter.InstalledTreesGet();*/
		CropLoader.load(preinit);
		//WitcheryMachineRecipeRemover.DistilleryRecipesRemover3(new ItemStack(Items.glowstone_dust),new ItemStack(Items.glowstone_dust),Witchery.Items.GENERIC.itemReekOfMisfortune.createStack(1));
	}

	@EventHandler
	public void init(FMLInitializationEvent init) {
		BppItems.register_Items();
		BppItems.OreDictItems();
		BppItems.register_recipes();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postinit) {
		CropLoader.register();
		CropLoader.registerBaseSeed();
		if (ModsLoaded.GT) {
			GTHandler GTHandler = new GTHandler();
			GTHandler.run();
			}
		}
}
