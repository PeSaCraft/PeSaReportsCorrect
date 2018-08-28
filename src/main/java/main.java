import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class main
        extends JavaPlugin
{
    public void onEnable()
    {
        getCommand();
    }

    public void onDisable() {}

    private void getCommand()
    {
        getCommand("report").setExecutor(new Command());
    }
}
