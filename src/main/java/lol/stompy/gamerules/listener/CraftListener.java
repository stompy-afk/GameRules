package lol.stompy.gamerules.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftListener implements Listener {

    @EventHandler
    public final void onPreCraftEvent(PrepareItemCraftEvent event) {
        final ItemStack result = event.getInventory().getResult();

        if (result == null)
            return;

        if (!result.getType().name().endsWith("_HELMET") && !result.getType().equals(Material.SHIELD))
            return;

        event.getInventory().setResult(null);
    }

}
