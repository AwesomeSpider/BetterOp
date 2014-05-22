package com.awsp8.announcements;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import com.awsp8.BetterOp;
import com.awsp8.announcements.Announcement;

public class Announcement1
				extends Announcement{
	
	ChatColor tagColor = ChatColor.getByChar(ConfigureAnnouncements.announcements.getString("announcement1.TagColor"));
	ChatColor messageColor = ChatColor.getByChar(ConfigureAnnouncements.announcements.getString("announcement1.MessageColor"));
	
	BukkitRunnable nextAnnouncement = new Announcement2();
	
	@Override
	public void setTag() {
		this.tag = ConfigureAnnouncements.announcements.getString("announcement1.Tag");
	}

	@Override
	public String getTag() {
		return this.tag;
	}

	@Override
	public void setMessage() {
		this.message = ConfigureAnnouncements.announcements.getString("announcement1.Message");
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public void run() {
		this.broadcast(this.tag, this.message, tagColor, messageColor);
		
		//run next announcement
		nextAnnouncement.runTaskLater(BetterOp.instance, AnnouncementEngine.Delay);
	}
}
