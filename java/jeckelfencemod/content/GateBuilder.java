package jeckelfencemod.content;

import cpw.mods.fml.common.registry.GameRegistry;
import jeckelfencemod.content.blocks.BlockModFenceGate;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class GateBuilder
{
	public static Block block(final String gateName, final String iconName,
			final float hardness, final float resistance, final SoundType sound)
	{
		final Block gate = new BlockModFenceGate(iconName);
		gate.setBlockName(gateName);
		gate.setHardness(hardness);
		gate.setResistance(resistance);
		gate.setStepSound(sound);
		return gate;
	}

	public static IRecipe recipe(final ItemStack output, final Object input)
	{
		return new ShapedOreRecipe(output,
				"   ", "#?#", "#?#",
				'#', new ItemStack(Items.stick), '?', input);
	}

	public static IRecipe recipe(final ItemStack output, final Object input, final Object inputSecondary)
	{
		return new ShapedOreRecipe(output,
				" % ", "#?#", "#?#",
				'#', new ItemStack(Items.stick), '?', input, '%', inputSecondary);
	}

	public static ContentData create(final String gateName, final String iconName,
			final float hardness, final float resistance,
			final SoundType sound,
			final Object recipeInput)
	{
		final Block gate = GateBuilder.block(gateName, iconName, hardness, resistance, sound);
		GameRegistry.registerBlock(gate, gate.getUnlocalizedName());// IMPORTANT: Must register block before creating recipe!!
		final IRecipe recipe = GateBuilder.recipe(new ItemStack(gate, 1), recipeInput);
		return new ContentData(gate, null, recipe);
	}

	public static ContentData create(final String gateName, final String iconName,
			final float hardness, final float resistance,
			final SoundType sound,
			final Object recipeInput, final Object recipeInputSecondary)
	{
		final Block gate = GateBuilder.block(gateName, iconName, hardness, resistance, sound);
		GameRegistry.registerBlock(gate, gate.getUnlocalizedName());// IMPORTANT: Must register block before creating recipe!!
		final IRecipe recipe = GateBuilder.recipe(new ItemStack(gate, 1), recipeInput, recipeInputSecondary);
		return new ContentData(gate, null, recipe);
	}

	public static ContentData createWood(final String gateName, final String iconName, final int woodMeta)
	{
		return GateBuilder.create(gateName, iconName, 2.0F, 5.0F,
				Block.soundTypeWood, new ItemStack(Blocks.planks, 1, woodMeta));
	}

	public static ContentData createWoodColored(final String gateName, final String iconName, final int dyeMeta)
	{
		return GateBuilder.create(gateName, iconName, 2.0F, 5.0F,
				Block.soundTypeWood, "plankWood", new ItemStack(Items.dye, 1, dyeMeta));
	}
}
