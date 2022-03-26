package me.whitescan.restrictedelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.whitescan.restrictedelytra.RestrictedElytra;

/**
 *
 * @author Whitescan
 *
 */
public class ReloadRestrictedElytraCommand implements CommandExecutor {

	public static final String RELOAD_COMMAND = "restrictedelytra.reload";

	private RestrictedElytra restrictedElytra;

	public ReloadRestrictedElytraCommand(RestrictedElytra restrictedElytra) {
		this.restrictedElytra = restrictedElytra;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!sender.hasPermission(RELOAD_COMMAND)) {
			sender.sendMessage(restrictedElytra.getRestrictedElytraConfig().getNoPermissionMessage());
			return true;
		}

		restrictedElytra.getRestrictedElytraConfig().reload();
		return true;

	}

}
