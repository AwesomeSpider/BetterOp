package com.awsp8.announcements;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import com.awsp8.BetterOp;

public class Announcement5
				extends Announcement {

	ChatColor tagColor = ChatColor.getByChar(ConfigureAnnouncements.announcements.getString("announcement5.TagColor"));
	ChatColor messageColor = ChatColor.getByChar(ConfigureAnnouncements.announcements.getString("announcement5.MessageColor"));
	
	BukkitRunnable nextAnnouncement = new Announcement1();
	
	@Override
	public void setTag() {
		this.tag = ConfigureAnnouncements.announcements.getString("announcement5.Tag");
	}

	@Override
	public String getTag() {
		return this.tag;
	}

	@Override
	public void setMessage() {
		this.message = ConfigureAnnouncements.announcements.getString("announcement5.Message");
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
