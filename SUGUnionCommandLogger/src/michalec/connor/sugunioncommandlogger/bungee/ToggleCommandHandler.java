package michalec.connor.sugunioncommandlogger.bungee;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ToggleCommandHandler extends Command {
	Main main;
	
	public ToggleCommandHandler(Main main) {
		super("togglelognotifs");
		this.main = main;
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			if(sender.hasPermission("sugunioncommandlogger.staff")) {
				if(main.playerHasNotificationEnabled((ProxiedPlayer) sender)) {
					main.setPlayerNotificationSetting((ProxiedPlayer) sender, false);
				}
				else {
					main.setPlayerNotificationSetting((ProxiedPlayer) sender, true);
				}
			}
		}
	}

}
