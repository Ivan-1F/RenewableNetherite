package me.ivanyf.renewablenetherite.recipes;

import me.ivanyf.renewablenetherite.RenewableNetherite;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class NetheriteHelmetRenewableRecipe extends SpecialCraftingRecipe {
    public NetheriteHelmetRenewableRecipe(Identifier id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingInventory inv, World world) {
        if (!RenewableNetherite.check(inv, 0, Items.WITHER_ROSE)) return false;
        if (!RenewableNetherite.check(inv, 1, Items.OBSIDIAN)) return false;
        if (!RenewableNetherite.check(inv, 2, Items.WITHER_ROSE)) return false;
        if (!RenewableNetherite.check(inv, 3, Items.WITHER_SKELETON_SKULL)) return false;
        if (!RenewableNetherite.check(inv, 4, Items.DIAMOND_HELMET)) return false;
        if (!RenewableNetherite.check(inv, 5, Items.WITHER_SKELETON_SKULL)) return false;
        if (!RenewableNetherite.check(inv, 6, Items.OBSIDIAN)) return false;
        if (!RenewableNetherite.check(inv, 7, Items.NETHER_STAR)) return false;
        if (!RenewableNetherite.check(inv, 8, Items.OBSIDIAN)) return false;
        return true;
    }

    @Override
    public ItemStack craft(CraftingInventory inv) {
        ItemStack tool = ItemStack.EMPTY;

        for (int i = 0; i < inv.size(); ++i) {
            ItemStack invItemStack = inv.getStack(i);
            if (!invItemStack.isEmpty()) {
                Item item = invItemStack.getItem();
                if (item == Items.DIAMOND_HELMET) {
                    tool = invItemStack;
                }
            }
        }

        ItemStack result = Items.NETHERITE_HELMET.getDefaultStack();
        if (tool.hasTag()) {
            result.setTag(tool.getTag().copy());
        }

        return result;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 9;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RenewableNetherite.netheriteHelmetRenewableRecipe;
    }
}
