/*    */ package Vanish;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class VanishCommands
/*    */   implements CommandExecutor
/*    */ {
/* 17 */   private final Set<UUID> vanishedPlayers = new HashSet<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
/* 22 */     Player targetPlayer = null;
/*    */     
/* 24 */     if (args.length == 0) {
/* 25 */       if (!(sender instanceof Player)) {
/*    */         
/* 27 */         sender.sendMessage("No se puede usar este comando en la consola!.");
/*    */         
/* 29 */         return true;
/*    */       } 
/*    */ 
/*    */       
/* 33 */       targetPlayer = (Player)sender;
/*    */     }
/*    */     else {
/*    */       
/* 37 */       targetPlayer = Bukkit.getPlayer(args[0]);
/*    */       
/* 39 */       if (targetPlayer == null) {
/* 40 */         sender.sendMessage("Porfavor especifica el jugador");
/* 41 */         return true;
/*    */       } 
/*    */     } 
/* 44 */     UUID uniqueId = targetPlayer.getUniqueId();
/* 45 */     boolean isVanished = this.vanishedPlayers.contains(uniqueId);
/*    */     
/* 47 */     for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
/*    */       
/* 49 */       if (otherPlayer.equals(targetPlayer)) {
/*    */         continue;
/*    */       }
/* 52 */       if (isVanished) {
/*    */         
/* 54 */         otherPlayer.showPlayer(targetPlayer);
/*    */         
/*    */         continue;
/*    */       } 
/* 58 */       otherPlayer.hidePlayer(targetPlayer);
/*    */     } 
/*    */ 
/*    */     
/* 62 */     sender.sendMessage(ChatColor.GREEN + "Vanish Activado.");
/* 63 */     sender.sendMessage(ChatColor.RED + "Vanish Desactivado.");
/*    */     
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\server\plugins\Aplugin.jar!\Vanish\VanishCommands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */