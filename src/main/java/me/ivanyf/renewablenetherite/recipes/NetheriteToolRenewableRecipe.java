package me.ivanyf.renewablenetherite.recipes;

import me.ivanyf.renewablenetherite.RenewableNetherite;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.*;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class NetheriteToolRenewableRecipe extends SpecialCraftingRecipe {
    public NetheriteToolRenewableRecipe(Identifier id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingInventory inv, World world) {
        if (!RenewableNetherite.check(inv, 0, Items.WITHER_SKELETON_SKULL)) return false;
        if (!RenewableNetherite.check(inv, 1, Items.NETHER_STAR)) return false;
        if (!RenewableNetherite.check(inv, 2, Items.WITHER_SKELETON_SKULL)) return false;
        if (!RenewableNetherite.check(inv, 3, Items.OBSIDIAN)) return false;
        if (!RenewableNetherite.isTool(inv.getStack(4))) return false;
        if (!RenewableNetherite.check(inv, 5, Items.OBSIDIAN)) return false;
        if (!RenewableNetherite.check(inv, 6, Items.BLAZE_ROD)) return false;
        if (!RenewableNetherite.check(inv, 7, Items.WITHER_ROSE)) return false;
        if (!RenewableNetherite.check(inv, 8, Items.BLAZE_ROD)) return false;
        return true;
    }

    @Override
    public ItemStack craft(CraftingInventory inv) {
        ItemStack tool = ItemStack.EMPTY;

        for (int i = 0; i < inv.size(); ++i) {
            ItemStack invItemStack = inv.getStack(i);
            if (!invItemStack.isEmpty()) {
                Item item = invItemStack.getItem();
                if (RenewableNetherite.isTool(item)) {
                    tool = invItemStack;
                }
            }
        }

        ItemStack result = RenewableNetherite.diamond2Netherite(tool.getItem()).getDefaultStack();
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
        return RenewableNetherite.netheriteToolRenewableRecipe;
    }
}
