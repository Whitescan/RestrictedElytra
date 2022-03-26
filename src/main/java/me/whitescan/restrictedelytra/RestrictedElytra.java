package me.whitescan.restrictedelytra;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.whitescan.restrictedelytra.commands.ReloadRestrictedElytraCommand;
import me.whitescan.restrictedelytra.config.RestrictedElytraConfig;
import me.whitescan.restrictedelytra.listeners.ElytraListener;

/**
 *
 * @author Whitescan
 *
 */
public class RestrictedElytra extends JavaPlugin implements Listener {

	private RestrictedElytraConfig restrictedElytraConfig;

	@Override
	public void onEnable() {
		getLogger().info("Setting up...");
		this.restrictedElytraConfig = new RestrictedElytraConfig(this);
		getServer().getPluginManager().registerEvents(new ElytraListener(this), this);
		getCommand("reloadrestrictedelytra").setExecutor(new ReloadRestrictedElytraCommand(this));
		getLogger().info("Setup completed!");
	}

	public RestrictedElytraConfig getRestrictedElytraConfig() {
		return restrictedElytraConfig;
	}

}
