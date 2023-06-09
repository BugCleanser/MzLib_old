package mz.lib.minecraft.bukkit.recipe;

import mz.lib.*;
import mz.lib.minecraft.bukkit.*;
import mz.lib.minecraft.bukkit.gui.*;
import mz.lib.minecraft.bukkit.gui.inventory.ListVisitor;
import mz.lib.minecraft.bukkit.itemstack.*;
import mz.lib.minecraft.bukkit.message.*;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class RecipeTypeSelector extends ListVisitor<RecipeEditor<?>>
{
	public static RecipeTypeSelector instance=new RecipeTypeSelector();
	public RecipeTypeSelector()
	{
		super(RecipeEditorRegistrar.instance,p->new TextMessageComponent(LangUtil.getTranslated(p,"mzlib.recipesEditor.types.title")).toNms(),RecipeEditorRegistrar.instance.recipeEditors);
	}
	
	@Override
	public ItemStack getIcon(int index,HumanEntity player)
	{
		RecipeEditor<?> editor=list.get(index);
		return new ItemStackBuilder(editor.getIcon().clone()).setName(StringUtil.replaceStrings(LangUtil.getTranslated(player,"mzlib.recipesEditor.kindRecipe.name"),new MapEntry<>("%\\{type}",editor.getDisplayName(player)))).get();
	}
	
	@Override
	public void onClickElement(int index,ClickType t,HumanEntity player)
	{
		ViewList.get(player).go(list.get(index));
	}
}
