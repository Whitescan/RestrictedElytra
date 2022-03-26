package me.whitescan.restrictedelytra.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

import me.whitescan.restrictedelytra.RestrictedElytra;

/**
 *
 * @author Whitescan
 *
 */
public class ElytraListener implements Listener {

	public static final String SPECIAL_BYPASS = "restrictedelytra.bypass";

	private RestrictedElytra restrictedElytra;

	public ElytraListener(RestrictedElytra restrictedElytra) {
		this.restrictedElytra = restrictedElytra;
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
	public void onElytra(EntityToggleGlideEvent e) {

		if (e.getEntity() instanceof Player) {

			Player actor = (Player) e.getEntity();

			if (!actor.hasPermission(SPECIAL_BYPASS)) {
				if (!actor.getAdvancementProgress(restrictedElytra.getRestrictedElytraConfig().getTriggerAdvancement()).isDone()) {
					e.setCancelled(true);
					actor.setGliding(false);
					actor.sendMessage(restrictedElytra.getRestrictedElytraConfig().getNotAllowedMessage());
				}
			}

		}

	}

}
