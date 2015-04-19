package jeckelfencemod.content;

import java.util.ArrayList;

import jeckelfencemod.core.Refs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.registry.GameRegistry;

public class ContentManager
{
	public static final String[] woods = new String[] { "spruce", "birch", "jungle", "acacia", "big_oak" };
	public static final ContentData[] fences_wood = new ContentData[woods.length];
	public static final ContentData[] fence_gates_wood = new ContentData[woods.length];

	public static final String[] colors = new String[] {"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white"};
	public static final ContentData[] fences_colored = new ContentData[colors.length];
	public static final ContentData[] fence_gates_colored = new ContentData[colors.length];

	public void pre()
	{
		removeRecipe(new ItemStack(Blocks.fence), Refs.getLogger());
		GameRegistry.addRecipe(FenceBuilder.recipe(new ItemStack(Blocks.fence, 3), new ItemStack(Blocks.planks, 1, 0)));

		for (int index = 0; index < woods.length; index++)
		{
			final String fenceName = "fence_planks_" + woods[index];
			final String iconName = "planks_" + woods[index];
			final int woodMeta = index + 1;
			fences_wood[index] = FenceBuilder.createWood(fenceName, iconName, woodMeta);
		}

		for (int index = 0; index < colors.length; index++)
		{
			String fenceName = "fence_colored_" + colors[index];
			String iconName = Refs.ModId + ":fence_colored_" + colors[index];
			fences_colored[index] = FenceBuilder.createWoodColored(fenceName, iconName, index);
		}

		removeRecipe(new ItemStack(Blocks.fence_gate), Refs.getLogger());
		GameRegistry.addRecipe(GateBuilder.recipe(new ItemStack(Blocks.fence_gate, 1), new ItemStack(Blocks.planks, 1, 0)));

		for (int index = 0; index < woods.length; index++)
		{
			String blockName = "fence_gate_planks_" + woods[index];
			String iconName = "planks_" + woods[index];
			final int woodMeta = index + 1;
			fence_gates_wood[index] = GateBuilder.createWood(blockName, iconName, woodMeta);
		}

		for (int index = 0; index < colors.length; index++)
		{
			String blockName = "fence_gate_colored_" + colors[index];
			String iconName = Refs.ModId + ":fence_colored_" + colors[index];
			fence_gates_colored[index] = GateBuilder.createWoodColored(blockName, iconName, index);
		}
	}

	public void initialize()
	{
	}

	public void post()
	{
	}

	public static void removeRecipe(final ItemStack stack, final Logger logger)
	{
		@SuppressWarnings("unchecked")
		final ArrayList<IRecipe> recipes = (ArrayList<IRecipe>) CraftingManager.getInstance().getRecipeList();
		for (int index = 0; index < recipes.size(); index++)
		{
			ItemStack result = ((IRecipe)recipes.get(index)).getRecipeOutput();
			if (result != null && OreDictionary.itemMatches(stack, result, false))
			{
				logger.info("Recipe Removed: " + result.getUnlocalizedName() + " -> " + recipes.get(index));
				recipes.remove(index);
			}
		}
	}
}
