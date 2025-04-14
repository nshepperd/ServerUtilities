package serverutils.command.pausewhenempty;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

import serverutils.ServerUtilities;
import serverutils.data.IPauseWhenEmptyServerConfig;
import serverutils.lib.command.CmdBase;
import serverutils.lib.command.CommandUtils;

public class CmdPauseWhenEmptySet extends CmdBase {

    CmdPauseWhenEmptySet() {
        super("set", Level.OP);
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        checkArgs(sender, args, 1);
        int newValue = CommandUtils.parseDuration(sender, args, 0).getAsInt();

        if (MinecraftServer.getServer() instanceof IPauseWhenEmptyServerConfig pauseWhenEmpty) {
            pauseWhenEmpty.serverUtilities$setPauseWhenEmptySeconds(newValue);
            sender.addChatMessage(ServerUtilities.lang(sender, "cmd.pause_when_empty_updated", newValue));
        }
    }
}
