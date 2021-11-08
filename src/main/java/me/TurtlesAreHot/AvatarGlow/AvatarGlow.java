package me.TurtlesAreHot.AvatarGlow;

import com.projectkorra.projectkorra.event.AbilityEndEvent;
import com.projectkorra.projectkorra.event.AbilityStartEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.glow.GlowAPI;


public class AvatarGlow extends JavaPlugin implements Listener {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onAbilityStart(AbilityStartEvent event) {
        if (!event.getAbility().getName().equals("AvatarState"))
            return;
        Player player = event.getAbility().getPlayer();
        GlowAPI.setGlowing(player, GlowAPI.Color.WHITE, Bukkit.getOnlinePlayers());
    }

    @EventHandler
    public void onAbilityEnd(AbilityEndEvent event) {
        if (!event.getAbility().getName().equals("AvatarState"))
            return;
        final Player player = event.getAbility().getPlayer();
        GlowAPI.setGlowing(player, false, Bukkit.getOnlinePlayers());
    }
}
