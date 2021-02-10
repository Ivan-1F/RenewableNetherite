package me.ivanyf.renewablenetherite;

import me.ivanyf.renewablenetherite.recipes.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RenewableNetherite implements ModInitializer {
    private static final String MOD_ID = "renewablenetherite";

    public static SpecialRecipeSerializer<NetheriteToolRenewableRecipe> netheriteToolRenewableRecipe = register("netherite_tool", new SpecialRecipeSerializer<>(NetheriteToolRenewableRecipe::new));
    public static SpecialRecipeSerializer<NetheriteSwordRenewableRecipe> netheriteSwordRenewableRecipe = register("netherite_sword", new SpecialRecipeSerializer<>(NetheriteSwordRenewableRecipe::new));
    public static SpecialRecipeSerializer<NetheriteHelmetRenewableRecipe> netheriteHelmetRenewableRecipe = register("netherite_helmet", new SpecialRecipeSerializer<>(NetheriteHelmetRenewableRecipe::new));
    public static SpecialRecipeSerializer<NetheriteChestplateRenewableRecipe> netheriteChestplateRenewableRecipe = register("netherite_chestplate", new SpecialRecipeSerializer<>(NetheriteChestplateRenewableRecipe::new));
    public static SpecialRecipeSerializer<NetheriteLeggingsRenewableRecipe> netheriteLeggingsRenewableRecipe = register("netherite_leggings", new SpecialRecipeSerializer<>(NetheriteLeggingsRenewableRecipe::new));
    public static SpecialRecipeSerializer<NetheriteBootsRenewableRecipe> netheriteBootsRenewableRecipe = register("netherite_boots", new SpecialRecipeSerializer<>(NetheriteBootsRenewableRecipe::new));

    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String name, S serializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, name), serializer);
    }

    public static boolean check(CraftingInventory inv, int slot, Item item) {
        ItemStack itemStack = inv.getStack(slot);
        if (itemStack.isEmpty()) return false;
        Item invItem = itemStack.getItem();
        return invItem == item;
    }

    public static boolean isTool(ItemStack itemStack) {
        if (itemStack.isEmpty()) return false;
        return isTool(itemStack.getItem());
    }

    public static boolean isTool(Item item) {
        return item.equals(Items.DIAMOND_PICKAXE) || item.equals(Items.DIAMOND_AXE) || item.equals(Items.DIAMOND_SHOVEL) || item.equals(Items.DIAMOND_HOE);
    }

    public static Item diamond2Netherite(Item item) {
        if (Items.DIAMOND_PICKAXE.equals(item)) {
            return Items.NETHERITE_PICKAXE;
        } else if (Items.DIAMOND_AXE.equals(item)) {
            return Items.NETHERITE_AXE;
        } else if (Items.DIAMOND_SHOVEL.equals(item)) {
            return Items.NETHERITE_SHOVEL;
        } else if (Items.DIAMOND_HOE.equals(item)) {
            return Items.NETHERITE_HOE;
        } else if (Items.DIAMOND_SWORD.equals(item)) {
            return Items.NETHERITE_SWORD;
        } else if (Items.DIAMOND_HELMET.equals(item)) {
            return Items.NETHERITE_HELMET;
        } else if (Items.DIAMOND_CHESTPLATE.equals(item)) {
            return Items.NETHERITE_CHESTPLATE;
        } else if (Items.DIAMOND_LEGGINGS.equals(item)) {
            return Items.NETHERITE_LEGGINGS;
        } else if (Items.DIAMOND_BOOTS.equals(item)) {
            return Items.NETHERITE_BOOTS;
        }
        return null;
    }

    @Override
    public void onInitialize() {

    }
}
