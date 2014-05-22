package com.awsp8.announcements;

import org.bukkit.scheduler.BukkitRunnable;

import com.awsp8.BetterOp;

public class AnnouncementEngine {
	
	static long Delay = ConfigureAnnouncements.announcements.getInt("time");
	
	static BukkitRunnable announce1 = new Announcement1();
	
	public static void runLoop(){
			announce1.runTaskLater(BetterOp.instance, Delay);
	}
}
