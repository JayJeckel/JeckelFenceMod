package jeckelfencemod.content;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;

public class ContentData
{
	public ContentData(Block block, Item item, IRecipe recipe)
	{
		this.block = block;
		this.item = item;
		this.recipe = recipe;
	}

	public final Block block;
	public final Item item;
	public final IRecipe recipe;
}
