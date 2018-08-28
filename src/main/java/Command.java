import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command
        implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
    {
        Player p = (Player)sender;
        if ((sender instanceof Player))
        {
            Player a = Bukkit.getPlayer(args[0]);
            String msg;
            int i;
            if (a != null)
            {
                msg = "";
                for (i = 1; i < args.length; i++) {
                    msg = msg + " " + args[i];
                }
                p.sendMessage("§aDu hast den Spieler §l" + a.getName() + " §afuer §7§1" + msg + " §a§lReportet.");
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("report"))
                    {
                        all.sendMessage("§4§L REPORT >> §a Der Spieler §7§l" + p.getName() + " §ahat den Spieler §7§l" + a.getName() + " §areportet.");
                        all.sendMessage("§4§L REPORT §7>> §aGrund: §7§l" + msg);
                    }
                }
            }
            else
            {
                p.sendMessage("ï¿½aï¿½lDieser Spieler ist nicht auf dem Server!");
            }
        }
        else
        {
            p.sendMessage("ï¿½aï¿½lBenutze den Command ï¿½4/report <Spieler> <Grund>");
        }
        return false;
    }
}
