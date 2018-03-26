// Forge proxy for the client side.
package com.xray.common.proxy;

import com.xray.client.KeyBindingHandler;
import com.xray.client.XRayEventHandler;
import com.xray.common.XRay;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		// Setup Keybindings
		XRay.keyBind_keys = new KeyBinding[ XRay.keyBind_descriptions.length ];
		for(int i = 0; i < XRay.keyBind_descriptions.length; ++i )
		{
			XRay.keyBind_keys[i] = new KeyBinding( XRay.keyBind_descriptions[i], XRay.keyBind_keyValues[i], "X-Ray" );
			ClientRegistry.registerKeyBinding( XRay.keyBind_keys[i] );
		}

		MinecraftForge.EVENT_BUS.register( new KeyBindingHandler() );
		MinecraftForge.EVENT_BUS.register( new XRayEventHandler() );
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

}