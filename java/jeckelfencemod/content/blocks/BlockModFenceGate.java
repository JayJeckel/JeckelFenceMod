package jeckelfencemod.content.blocks;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModFenceGate extends BlockFenceGate
{
	public BlockModFenceGate(String iconName)
	{
		//super(Material.wood);
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this._iconName = iconName;
	}

	private final String _iconName;

	@SideOnly(Side.CLIENT)
	@Override public void registerBlockIcons(IIconRegister registry) { this.blockIcon = registry.registerIcon(this._iconName); }

	@SideOnly(Side.CLIENT)
	@Override public IIcon getIcon(int side, int neta) { return this.blockIcon; }

	@Override public boolean getBlocksMovement(IBlockAccess world, int x, int y, int z)
	{
		return !isFenceGateOpen(world.getBlockMetadata(x, y, z));
	}

	/*public static boolean isFenceGateOpen(int meta) { return (meta & 4) != 0; }

	public static int renderType = 0;
	@Override public int getRenderType() { return renderType; }

	@Override public boolean isOpaqueCube() { return false; }

	@Override public boolean renderAsNormalBlock() { return false; }

	@SideOnly(Side.CLIENT)
	@Override public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) { return true; }

	@Override public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int l = getDirection(world.getBlockMetadata(x, y, z));

		if (l != 2 && l != 0)
		{
			this.setBlockBounds(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
		}
		else
		{
			this.setBlockBounds(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
		}
	}

	@Override public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		return isFenceGateOpen(l) ? null : (l != 2 && l != 0 ? AxisAlignedBB.getBoundingBox((double)((float)x + 0.375F), (double)y, (double)z, (double)((float)x + 0.625F), (double)((float)y + 1.5F), (double)(z + 1)) : AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)((float)z + 0.375F), (double)(x + 1), (double)((float)y + 1.5F), (double)((float)z + 0.625F)));
		//return AxisAlignedBB.getBoundingBox((double)((float)x), (double)y, (double)z, (double)((float)x + 1), (double)((float)y + 1.5F), (double)(z + 1));
	}

	@Override public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return !world.getBlock(x, y - 1, z).getMaterial().isSolid() ? false : super.canPlaceBlockAt(world, x, y, z);
	}

	@Override public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		int l = (MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}

	@Override public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		int meta = world.getBlockMetadata(x, y, z);
		player.addChatMessage(new ChatComponentText("meta: " + meta));

		if (isFenceGateOpen(meta))
		{
			world.setBlockMetadataWithNotify(x, y, z, meta & -5, 2);
		}
		else
		{
			int j1 = (MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
			int k1 = getDirection(meta);

			if (k1 == (j1 + 2) % 4)
			{
				meta = j1;
			}

			world.setBlockMetadataWithNotify(x, y, z, meta | 4, 2);
		}

		world.playAuxSFXAtEntity(player, 1003, x, y, z, 0);
		return true;
	}

	@Override public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
	{
		if (!world.isRemote)
		{
			int l = world.getBlockMetadata(x, y, z);
			boolean flag = world.isBlockIndirectlyGettingPowered(x, y, z);

			if (flag || neighbor.canProvidePower())
			{
				if (flag && !isFenceGateOpen(l))
				{
					world.setBlockMetadataWithNotify(x, y, z, l | 4, 2);
					world.playAuxSFXAtEntity((EntityPlayer)null, 1003, x, y, z, 0);
				}
				else if (!flag && isFenceGateOpen(l))
				{
					world.setBlockMetadataWithNotify(x, y, z, l & -5, 2);
					world.playAuxSFXAtEntity((EntityPlayer)null, 1003, x, y, z, 0);
				}
			}
		}
	}*/
}
