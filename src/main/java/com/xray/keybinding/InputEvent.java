package com.xray.keybinding;

import com.xray.gui.GuiSelectionScreen;
import com.xray.xray.Controller;
import com.xray.XRay;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class InputEvent
{
	@SubscribeEvent
	public void onKeyInput( KeyInputEvent event )
    {
		if( (!FMLClientHandler.instance().isGUIOpen( GuiChat.class )) && (XRay.mc.currentScreen == null) && (XRay.mc.world != null) )
        {
			if( KeyBindings.keyBind_keys[ KeyBindings.keyIndex_toggleXray ].isPressed() )
			{
				Controller.toggleDrawOres();
			}
			else if( KeyBindings.keyBind_keys[ KeyBindings.keyIndex_showXrayMenu ].isPressed() )
			{
				XRay.mc.displayGuiScreen( new GuiSelectionScreen() );
			}
		}
	}
}
