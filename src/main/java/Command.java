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
                p.sendMessage("Du hast den Spieler " + a.getName() + " fuer 񘿹" + msg + " Reportet.");
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("report"))
                    {
                        all.sendMessage("�4 REPORT >>  Der Spieler �7" + p.getName() + " hat den Spieler �7" + a.getName() + " reportet.");
                        all.sendMessage("�4 REPORT �7>> Grund: �7" + msg);
                    }
                }
            }
            else
            {
                p.sendMessage("锟絘锟絣Dieser Spieler ist nicht auf dem Server!");
            }
        }
        else
        {
            p.sendMessage("锟絘锟絣Benutze den Command 锟�4/report <Spieler> <Grund>");
        }
        return false;
    }
}
