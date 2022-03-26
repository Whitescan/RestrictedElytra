package me.whitescan.restrictedelytra.config;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import me.whitescan.api.config.BukkitConfigHandler;
import net.md_5.bungee.api.ChatColor;

/**
 *
 * @author Whitescan
 *
 */
public class RestrictedElytraConfig extends BukkitConfigHandler {

	private Advancement triggerAdvancement;

	private String notAllowedMessage;

	private String noPermissionMessage;

	public RestrictedElytraConfig(Plugin plugin) {
		super(plugin, new File(plugin.getDataFolder(), "config.yml"));
	}

	@Override
	public void read() {

		ConfigurationSection sec = getConfig().getConfigurationSection("config");

		try {

			this.triggerAdvancement = Bukkit.getAdvancement(NamespacedKey.fromString(sec.getString("trigger-advancement-key")));

			if (getTriggerAdvancement() == null) {
				plugin.getLogger().severe(
						"Could not find trigger advancement by key. This could either be an invalid key or minecraft version missmatch.");
				plugin.getPluginLoader().disablePlugin(plugin);
			}

			this.notAllowedMessage = ChatColor.translateAlternateColorCodes('&', sec.getString("not-allowed-message"));
			this.noPermissionMessage = ChatColor.translateAlternateColorCodes('&', sec.getString("no-permission-message"));

		} catch (Exception e) {
			plugin.getLogger().severe("Could not load config section " + sec.getCurrentPath()
					+ ". It appears your config.yml is broken. If you can't fix it, back it up and delete the current. A working default file will be created.");
			e.printStackTrace();
		}

	}

	public Advancement getTriggerAdvancement() {
		return triggerAdvancement;
	}

	public String getNotAllowedMessage() {
		return notAllowedMessage;
	}

	public String getNoPermissionMessage() {
		return noPermissionMessage;
	}

}
