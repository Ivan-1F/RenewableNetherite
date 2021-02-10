package me.ivanyf.renewablenetherite.mixins;

import com.google.common.collect.ImmutableList;
import me.ivanyf.renewablenetherite.recipes.NetheriteToolRenewableRecipe;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.play.RecipeBookDataC2SPacket;
import net.minecraft.network.packet.s2c.play.SynchronizeRecipesS2CPacket;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {
    @Inject(method = "onPlayerConnect", at = @At("HEAD"), cancellable = true)
    void onPlayerConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
        System.out.println("packet sending!");
        connection.send(new SynchronizeRecipesS2CPacket(ImmutableList.of(new NetheriteToolRenewableRecipe(new Identifier("renewablenetherite", "netherite_tool")))));
        System.out.println("packet sent!");
    }
}
