package lol.stompy.gamerules.listener;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

public class EnchantListener implements Listener {

    @EventHandler
    public final void onEnchantItemEvent(EnchantItemEvent event) {
        if (!event.getEnchantsToAdd().containsKey(Enchantment.SHARPNESS))
            return;

        if (event.getEnchantsToAdd().get(Enchantment.SHARPNESS) < 4)
            return;

        event.setCancelled(true);
    }

    @EventHandler
    public final void onPrepareAnvilEvent(PrepareAnvilEvent event) {
        final ItemStack result = event.getResult();

        if (result == null || !result.getEnchantments().containsKey(Enchantment.SHARPNESS))
            return;

        if (result.getEnchantmentLevel(Enchantment.SHARPNESS) < 4)
            return;

        event.setResult(null);
    }

}
