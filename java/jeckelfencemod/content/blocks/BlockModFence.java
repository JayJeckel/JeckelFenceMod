package jeckelfencemod.content.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockModFence extends BlockFence
{
	public BlockModFence(String iconName, Material material)
	{
		super(iconName, material);
	}

	@Override public boolean canConnectFenceTo(IBlockAccess world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		if (block == this || block == Blocks.fence || block == Blocks.fence_gate) { return true; }
		if (block instanceof BlockFence || block instanceof BlockModFence) { return true; }
		if (block instanceof BlockFenceGate || block instanceof BlockModFenceGate) { return true; }
		return super.canConnectFenceTo(world, x, y, z);
	}

	@Override public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
	{
		if (side == ForgeDirection.UP) { return true; }
		return false;
	}
}
