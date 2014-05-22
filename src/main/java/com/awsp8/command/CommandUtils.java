package com.awsp8.command;

import java.util.UUID;

import com.awsp8.BetterOp;

public class CommandUtils {

	public static UUID getUUID(String PlayerName){
		UUID id = (UUID) BetterOp.playerUUIDs.get(PlayerName);
		return id;
	}
}
