import java.util.Map;

import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import org.rsbot.script.wrappers.RSTile;

@ScriptManifest(authors = { "Allometry" }, category = "!RC", name = "Abyssal Crafting", version = 1.0, description = "")
public class AbyssalCrafting extends Script {
	//Camera Positions
	private String lawRiftCamera = "W";
	private String natureRiftCamera = "S";
	
	//Interfaces
	private int pouchRepairChatAct1Parent = 65, pouchRepairChatAct1Child = 6;
	private int pouchRepairChatAct2Parent = 243, pouchRepairChatAct2Child = 7;
	
	//NPC IDs
	private int darkMageID = 2262;
	private int zamorakMageID = 2257;
	
	//Object IDs
	private int abyssalBoilID = 7147, abyssalEyesID = 7148, abyssalGapID = 7149;
	private int abyssalPassageID = 7144, abyssalRockID = 7145, abyssalTendrilsID = 7146;
	private int lawAlterID = 0, natureAlterID = 2486;
	private int wildernessWallID = 1444;
	
	//Paths
	private RSTile[] ageb = {new RSTile(3087, 3496), new RSTile(3089, 3491), new RSTile(3097, 3496)}; //Amulet of Glory Teleport to Edgeville Bank
	private RSTile[] ebww = {new RSTile(3097, 3496), new RSTile(3100, 3501), new RSTile(3103, 3506), new RSTile(3105, 3511), new RSTile(3105, 3516), new RSTile(3105, 3520)}; //Edgeville Bank to Wilderness Wall
	private RSTile[] wwzm = {new RSTile(3104, 3523), new RSTile(3104, 3528), new RSTile(3104, 3532), new RSTile(3104, 3537), new RSTile(3104, 3543), new RSTile(3104, 3548), new RSTile(3104, 3554), new RSTile(3106, 3558)}; //Wilderness Wall to Mage of Zamorak
	
	//Strings
	private String darkMageCommand = "Repair-pouches";
	private String zamorakMageCommand = "Teleport";
	
	//Tiles
	private RSTile lawRiftTile = new RSTile(3049, 4839);
	private RSTile natureRiftTile = new RSTile(3035, 4842);
	
	@Override
	public boolean onStart(Map<String,String> args) {
		return true;
	}
	
	@Override
	public int loop() {
		return 0;
	}
}
