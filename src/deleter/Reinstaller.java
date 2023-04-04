package deleter;

public class Reinstaller {
	
	public void reinstall() {
		
		DeleteBan ban = new DeleteBan();
		DeleteEula eula = new DeleteEula();
		DeleteLogs logs = new DeleteLogs();
		DeleteOps ops = new DeleteOps();
		DeletePlayers players = new DeletePlayers();
		DeleteSettings settings = new DeleteSettings();
		DeleteWhitelist whitelist = new DeleteWhitelist();
		DeleteWorld world = new DeleteWorld();
		
		
		ban.Ban();
		eula.delete();
		logs.delete();
		ops.delete();
		players.delete();
		settings.delete();
		whitelist.delete();
		world.delete();
		
	}
	

}
