package jeckelfencemod.content;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;

public class ContentData
{
	public ContentData(final Block block, final Item item, final IRecipe recipe)
	{
		this.block = block;
		this.item = item;
		this.recipe = recipe;
	}

	public final Block block;
	public final Item item;
	public final IRecipe recipe;

	public void registerRecipe() { if (this.recipe != null) { GameRegistry.addRecipe(this.recipe); } }
}
