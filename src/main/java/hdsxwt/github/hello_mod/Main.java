package hdsxwt.github.hello_mod;


import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.status.ServerStatus;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.ArrayUtils;
import oshi.util.Util;

import java.awt.*;
import java.util.Arrays;


@Mod("hello_mod")
@Mod.EventBusSubscriber
public class Main {

    public static void print(Player player, String text) {
        player.sendSystemMessage(Component.nullToEmpty(text));
    }
    public static void print(LivingEntity livingEntity, String text) {
        try {
            Player player = (Player) livingEntity;
            print(player, livingEntity.getUUID() + text);
            // how can I know whether this is a player or an NPC;
        } finally {

        }
    }
    @SubscribeEvent
    public static void PlayerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        Level level = player.level;
        String text = "Hello," + player.getName() + " from " + (level.isClientSide ? "CLIENT" : "SERVER") + ".";
        print(player, text);
    }

    @SubscribeEvent
    public static void LeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        Level level = player.level;
        String text = "A LeftClickBlock event happen from" + player.getName() +
                " (" + (level.isClientSide ? "CLIENT" : "SERVER") + ").";
        print(player, text);

    }

    @SubscribeEvent
    public static void LeftClickEmpty(PlayerInteractEvent.LeftClickEmpty event) {
        Player player = event.getEntity();
        Level level = player.level;
        String text = "A LeftClickEmpty event happen from" + player.getName() +
                " (" + (level.isClientSide ? "CLIENT" : "SERVER") + ").";
        print(player, text);
    }

    @SubscribeEvent
    public static void RightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = player.level;
        String text = "A RightClickBlock event happen from" + player.getName() +
                " (" + (level.isClientSide ? "CLIENT" : "SERVER") + ").";
        print(player, text);
    }

    @SubscribeEvent
    public static void RightClickEmpty(PlayerInteractEvent.RightClickEmpty event) {
        Player player = event.getEntity();
        Level level = player.level;
        String text = "A RightClickEmpty event happen from" + player.getName() +
                " (" + (level.isClientSide ? "CLIENT" : "SERVER") + ").";
        print(player, text);
    }

    @SubscribeEvent
    public static void RightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        Level level = player.level;
        String text = "A RightClickItem event happen from" + player.getName() +
                " (" + (level.isClientSide ? "CLIENT" : "SERVER") + ").";
        player.sendSystemMessage(Component.nullToEmpty(text));
        if (level.isClientSide) {
            Item item = event.getItemStack().getItem();
            Item[] swords = {Items.WOODEN_SWORD, Items.DIAMOND_SWORD, Items.GOLDEN_SWORD, Items.IRON_SWORD, Items.STONE_SWORD,Items.NETHERITE_SWORD};
            if (ArrayUtils.contains(swords, item)) {
                print(player, "Why are you taking that thing?");
            }
        }
    }

    @SubscribeEvent
    public static void jump(LivingEvent.LivingJumpEvent event) {
        LivingEntity livingEntity = event.getEntity();
        Level level = livingEntity.level;
        String text = "A jump event happen from" + livingEntity.getName() +
                " (" + (level.isClientSide ? "CLIENT" : "SERVER") + ").";
        print(livingEntity, text);
    }
}
/*

PlayerInteractEvent.LeftClickBlock
PlayerInteractEvent.LeftClickEmpty
PlayerInteractEvent.RightClickBlock
PlayerInteractEvent.RightClickEmpty

 */