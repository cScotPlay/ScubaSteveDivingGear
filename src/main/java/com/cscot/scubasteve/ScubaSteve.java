package com.cscot.scubasteve;

import com.cscot.scubasteve.client.gui.GoggleIngameGui;
import com.cscot.scubasteve.util.itemgroups.ScubaItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ScubaSteve.MODID)
public class ScubaSteve
{
    public static ScubaSteve instance;
    public static final String MODID = "scubasteve";

    public static final ItemGroup scubaItemGroup = new ScubaItemGroup();

    // Directly reference a log4j logger.
    public static Logger LOGGER = LogManager.getLogger(MODID);

    public ScubaSteve()
    {
        instance = this;
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::postSetup);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        //LOGGER.info("HELLO FROM PREINIT");
        //LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);

        MinecraftForge.EVENT_BUS.register(new GoggleIngameGui());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some cscot code to dispatch IMC to another mod
        //InterModComms.sendTo("scubasteve", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some cscot code to receive and process InterModComms from other mods
        /*LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));*/
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call

    @SubscribeEvent
    public void postSetup(FMLLoadCompleteEvent event) {

        //This is required to inject Wetsuit Layer for model rendering
        /*RenderManager manager = Minecraft.getInstance().getRenderManager();
        Map<String, RenderPlayer> renderPlayerMap = manager.getSkinMap();
        for(RenderPlayer render : renderPlayerMap.values()) {
            List<LayerRenderer> list = ObfuscationReflectionHelper.getPrivateValue(RenderLivingBase.class, render, "field_177097_h");
            list.add(new WetsuitLayer(render));
        }
        Render<?> render = manager.getEntityClassRenderObject(EntityArmorStand.class);
        ((RenderLivingBase<?>) render).addLayer(new WetsuitLayer((RenderLivingBase<?>) render) {
        });*/
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        //LOGGER.info("HELLO from server starting");
    }
}
