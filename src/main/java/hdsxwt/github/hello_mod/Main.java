package hdsxwt.github.hello_mod;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import oshi.util.Util;

import java.awt.*;


@Mod("hello_mod")
@Mod.EventBusSubscriber
public class Main {
    @SubscribeEvent
    public static void playerJoiningWorld(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        Level level = player.level;
        String text = "Hello," + player.getName() + ".";
        player.sendSystemMessage(Component.nullToEmpty(text));
    }
}
