package jeckelfencemod.content;

import jeckelfencemod.content.blocks.BlockModFence;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class FenceBuilder
{
	public static Block block(final String fenceName, final String iconName,
			final float hardness, final float resistance, final Material material, final SoundType sound)
	{
		final Block fence = new BlockModFence(iconName, material);
		fence.setBlockName(fenceName);
		fence.setHardness(hardness);
		fence.setResistance(resistance);
		fence.setStepSound(sound);
		return fence;
	}

	public static IRecipe recipe(final ItemStack output, final Object input)
	{
		return new ShapedOreRecipe(output,
				"   ", "?#?", "?#?",
				'#', new ItemStack(Items.stick), '?', input);
	}

	public static IRecipe recipe(final ItemStack output, final Object input, final Object inputSecondary)
	{
		return new ShapedOreRecipe(output,
				" % ", "?#?", "?#?",
				'#', new ItemStack(Items.stick), '?', input, '%', inputSecondary);
	}

	public static ContentData create(final String fenceName, final String iconName,
			final float hardness, final float resistance,
			final Material material, final SoundType sound,
			final Object recipeInput)
	{
		final Block fence = FenceBuilder.block(fenceName, iconName, hardness, resistance, material, sound);
		GameRegistry.registerBlock(fence, fence.getUnlocalizedName());
		final IRecipe recipe = FenceBuilder.recipe(new ItemStack(fence, 3), recipeInput);
		GameRegistry.addRecipe(recipe);
		return new ContentData(fence, null, recipe);
	}

	public static ContentData create(final String fenceName, final String iconName,
			final float hardness, final float resistance,
			final Material material, final SoundType sound,
			final Object recipeInput, final Object recipeInputSecondary)
	{
		final Block fence = FenceBuilder.block(fenceName, iconName, hardness, resistance, material, sound);
		GameRegistry.registerBlock(fence, fence.getUnlocalizedName());
		final IRecipe recipe = FenceBuilder.recipe(new ItemStack(fence, 3), recipeInput, recipeInputSecondary);
		GameRegistry.addRecipe(recipe);
		return new ContentData(fence, null, recipe);
	}

	public static ContentData createWood(final String fenceName, final String iconName, final int woodMeta)
	{
		return FenceBuilder.create(fenceName, iconName, 2.0F, 5.0F,
				Material.wood, Block.soundTypeWood, new ItemStack(Blocks.planks, 1, woodMeta));
	}

	public static ContentData createWoodColored(final String fenceName, final String iconName, final int dyeMeta)
	{
		return FenceBuilder.create(fenceName, iconName, 2.0F, 5.0F,
				Material.wood, Block.soundTypeWood, "plankWood", new ItemStack(Items.dye, 1, dyeMeta));
	}
}
