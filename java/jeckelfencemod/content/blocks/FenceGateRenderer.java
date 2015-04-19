package jeckelfencemod.content.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FenceGateRenderer implements ISimpleBlockRenderingHandler
{
	@Override public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		//renderer.renderBlockAsItem(p_147800_1_, p_147800_2_, p_147800_3_);
		/*int meta = 0;
		boolean open = false;
		int dir = 0;
		this.renderWorldBlock(0, 0, 0, block, modelId, renderer, meta, dir, open);*/
	}

	@Override public boolean shouldRender3DInInventory(int modelId) { return false; }

	@Override public int getRenderId() { return 0; }//BlockModFenceGate.renderType; }

	@Override public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		int meta = world.getBlockMetadata(x, y, z);
		boolean open = BlockFenceGate.isFenceGateOpen(meta);
		int dir = BlockDirectional.getDirection(meta);
		return this.renderWorldBlock(x, y, z, block, modelId, renderer, meta, dir, open);
	}

	public boolean renderWorldBlock(int x, int y, int z, Block block, int modelId, RenderBlocks renderer, final int meta, final int dir, final boolean open)
	{
		boolean flag = true;
		float f = 0.375F;
		float f1 = 0.5625F;
		float f2 = 0.75F;
		float f3 = 0.9375F;
		float f4 = 0.3125F;
		float f5 = 1.0F;

		/*if ((dir == 2 || dir == 0) && world.getBlock(x - 1, y, z) == Blocks.cobblestone_wall && world.getBlock(x + 1, y, z) == Blocks.cobblestone_wall || (dir == 3 || dir == 1) && world.getBlock(x, y, z - 1) == Blocks.cobblestone_wall && world.getBlock(x, y, z + 1) == Blocks.cobblestone_wall)
		{
			f -= 0.1875F;
			f1 -= 0.1875F;
			f2 -= 0.1875F;
			f3 -= 0.1875F;
			f4 -= 0.1875F;
			f5 -= 0.1875F;
		}*/

		renderer.renderAllFaces = true;
		float f6;
		float f7;
		float f8;
		float f9;

		if (dir != 3 && dir != 1)
		{
			f6 = 0.0F;
			f7 = 0.125F;
			f8 = 0.4375F;
			f9 = 0.5625F;
			renderer.setRenderBounds((double)f6, (double)f4, (double)f8, (double)f7, (double)f5, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			f6 = 0.875F;
			f7 = 1.0F;
			renderer.setRenderBounds((double)f6, (double)f4, (double)f8, (double)f7, (double)f5, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
		}
		else
		{
			renderer.uvRotateTop = 1;
			f6 = 0.4375F;
			f7 = 0.5625F;
			f8 = 0.0F;
			f9 = 0.125F;
			renderer.setRenderBounds((double)f6, (double)f4, (double)f8, (double)f7, (double)f5, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			f8 = 0.875F;
			f9 = 1.0F;
			renderer.setRenderBounds((double)f6, (double)f4, (double)f8, (double)f7, (double)f5, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.uvRotateTop = 0;
		}

		if (open)
		{
			if (dir == 2 || dir == 0)
			{
				renderer.uvRotateTop = 1;
			}

			if (dir == 3)
			{
				f6 = 0.0F;
				f7 = 0.125F;
				f8 = 0.875F;
				f9 = 1.0F;
				renderer.setRenderBounds(0.8125D, (double)f, 0.0D, 0.9375D, (double)f3, 0.125D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.8125D, (double)f, 0.875D, 0.9375D, (double)f3, 1.0D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.5625D, (double)f, 0.0D, 0.8125D, (double)f1, 0.125D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.5625D, (double)f, 0.875D, 0.8125D, (double)f1, 1.0D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.5625D, (double)f2, 0.0D, 0.8125D, (double)f3, 0.125D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.5625D, (double)f2, 0.875D, 0.8125D, (double)f3, 1.0D);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else if (dir == 1)
			{
				f6 = 0.0F;
				f7 = 0.125F;
				f8 = 0.875F;
				f9 = 1.0F;
				renderer.setRenderBounds(0.0625D, (double)f, 0.0D, 0.1875D, (double)f3, 0.125D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0625D, (double)f, 0.875D, 0.1875D, (double)f3, 1.0D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875D, (double)f, 0.0D, 0.4375D, (double)f1, 0.125D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875D, (double)f, 0.875D, 0.4375D, (double)f1, 1.0D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875D, (double)f2, 0.0D, 0.4375D, (double)f3, 0.125D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875D, (double)f2, 0.875D, 0.4375D, (double)f3, 1.0D);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else if (dir == 0)
			{
				f6 = 0.0F;
				f7 = 0.125F;
				f8 = 0.875F;
				f9 = 1.0F;
				renderer.setRenderBounds(0.0D, (double)f, 0.8125D, 0.125D, (double)f3, 0.9375D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.875D, (double)f, 0.8125D, 1.0D, (double)f3, 0.9375D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0D, (double)f, 0.5625D, 0.125D, (double)f1, 0.8125D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.875D, (double)f, 0.5625D, 1.0D, (double)f1, 0.8125D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0D, (double)f2, 0.5625D, 0.125D, (double)f3, 0.8125D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.875D, (double)f2, 0.5625D, 1.0D, (double)f3, 0.8125D);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else if (dir == 2)
			{
				f6 = 0.0F;
				f7 = 0.125F;
				f8 = 0.875F;
				f9 = 1.0F;
				renderer.setRenderBounds(0.0D, (double)f, 0.0625D, 0.125D, (double)f3, 0.1875D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.875D, (double)f, 0.0625D, 1.0D, (double)f3, 0.1875D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0D, (double)f, 0.1875D, 0.125D, (double)f1, 0.4375D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.875D, (double)f, 0.1875D, 1.0D, (double)f1, 0.4375D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0D, (double)f2, 0.1875D, 0.125D, (double)f3, 0.4375D);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.875D, (double)f2, 0.1875D, 1.0D, (double)f3, 0.4375D);
				renderer.renderStandardBlock(block, x, y, z);
			}
		}
		else if (dir != 3 && dir != 1)
		{
			f6 = 0.375F;
			f7 = 0.5F;
			f8 = 0.4375F;
			f9 = 0.5625F;
			renderer.setRenderBounds((double)f6, (double)f, (double)f8, (double)f7, (double)f3, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			f6 = 0.5F;
			f7 = 0.625F;
			renderer.setRenderBounds((double)f6, (double)f, (double)f8, (double)f7, (double)f3, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			f6 = 0.625F;
			f7 = 0.875F;
			renderer.setRenderBounds((double)f6, (double)f, (double)f8, (double)f7, (double)f1, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds((double)f6, (double)f2, (double)f8, (double)f7, (double)f3, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			f6 = 0.125F;
			f7 = 0.375F;
			renderer.setRenderBounds((double)f6, (double)f, (double)f8, (double)f7, (double)f1, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds((double)f6, (double)f2, (double)f8, (double)f7, (double)f3, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
		}
		else
		{
			renderer.uvRotateTop = 1;
			f6 = 0.4375F;
			f7 = 0.5625F;
			f8 = 0.375F;
			f9 = 0.5F;
			renderer.setRenderBounds((double)f6, (double)f, (double)f8, (double)f7, (double)f3, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			f8 = 0.5F;
			f9 = 0.625F;
			renderer.setRenderBounds((double)f6, (double)f, (double)f8, (double)f7, (double)f3, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			f8 = 0.625F;
			f9 = 0.875F;
			renderer.setRenderBounds((double)f6, (double)f, (double)f8, (double)f7, (double)f1, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds((double)f6, (double)f2, (double)f8, (double)f7, (double)f3, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			f8 = 0.125F;
			f9 = 0.375F;
			renderer.setRenderBounds((double)f6, (double)f, (double)f8, (double)f7, (double)f1, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds((double)f6, (double)f2, (double)f8, (double)f7, (double)f3, (double)f9);
			renderer.renderStandardBlock(block, x, y, z);
		}

		renderer.renderAllFaces = false;
		renderer.uvRotateTop = 0;
		renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		return flag;
	}
}
