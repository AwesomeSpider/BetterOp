package com.awsp8.announcements;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class Announcement
						extends BukkitRunnable{
		public String tag;
		public abstract void setTag();
		public abstract String getTag();
		
		public String message;
		public abstract void setMessage();
		public abstract String getMessage();

		/**
		 * Broadcasts the Announcement.
		 * @param Tag
		 * @param Message
		 * @param TagColor
		 * @param MessageColor
		 */
		public void broadcast(String Tag, String Message, ChatColor TagColor, ChatColor MessageColor){
			Bukkit.getServer().broadcastMessage(TagColor + Tag + MessageColor + Message);
		}
}
