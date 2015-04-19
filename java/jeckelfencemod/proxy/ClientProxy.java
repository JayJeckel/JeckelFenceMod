package jeckelfencemod.proxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@Override public boolean isClient() { return true; }

	@Override public void initialize(final String modId)
	{
		super.initialize(modId);

		//BlockModFenceGate.renderType = RenderingRegistry.getNextAvailableRenderId();
		//ISimpleBlockRenderingHandler renderer = new FenceGateRenderer();
		//RenderingRegistry.registerBlockHandler(BlockModFenceGate.renderType, renderer);
	}
}
