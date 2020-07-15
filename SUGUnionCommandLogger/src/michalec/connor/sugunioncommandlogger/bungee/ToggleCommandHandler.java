package michalec.connor.sugunioncommandlogger.bungee;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ToggleCommandHandler extends Command {
	Main main;
	
	public ToggleCommandHandler(Main main) {
		super("togglelognotifs");
		this.main = main;
	}
	
	//on /togglelognotifs
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			if(sender.hasPermission("sugunioncommandlogger.staff")) { //make sure executor is staff
				if(main.playerHasNotificationEnabled((ProxiedPlayer) sender)) {
					main.setPlayerNotificationSetting((ProxiedPlayer) sender, false);
					((ProxiedPlayer) sender).sendMessage(TextComponent.fromLegacyText("Disabled command notifications"));
				}
				else {
					main.setPlayerNotificationSetting((ProxiedPlayer) sender, true);
					((ProxiedPlayer) sender).sendMessage(TextComponent.fromLegacyText("Enabled command notifications"));
				}
			}
			else {
				((ProxiedPlayer) sender).sendMessage(TextComponent.fromLegacyText("Insufficient Permission"));
			}
		}
	}

}
