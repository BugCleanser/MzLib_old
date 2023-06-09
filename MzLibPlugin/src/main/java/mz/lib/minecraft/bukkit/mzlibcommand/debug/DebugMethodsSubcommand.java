package mz.lib.minecraft.bukkit.mzlibcommand.debug;

import mz.lib.minecraft.bukkit.MzLib;
import mz.lib.minecraft.bukkit.command.AbsLastCommandProcessor;
import mz.lib.minecraft.bukkit.command.CommandHandler;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Method;

public class DebugMethodsSubcommand extends AbsLastCommandProcessor
{
    public static DebugMethodsSubcommand instance=new DebugMethodsSubcommand();
    public DebugMethodsSubcommand()
    {
        super(false,null,"methods");
    }

    @CommandHandler
    public void execute(CommandSender sender, String className)
    {
        try
        {
            for(Method m:Class.forName(className,false, MzLib.class.getClassLoader()).getDeclaredMethods())
            {
                sender.sendMessage("§a"+m.toString());
            }
        }
        catch(ClassNotFoundException e)
        {
            sender.sendMessage("§4ClassNotFoundException");
        }
    }
}
