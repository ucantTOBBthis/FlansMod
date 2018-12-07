package com.flansmod.common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.teams.TeamsManager;

public class PlayerHandler
{
	//public  static String lastAnimal="";
	public  boolean sheepKilled=false;
	public  boolean cowKilled=false;
	public  boolean pigKilled=false;
	public  boolean chickenKilled=false;
	public  boolean donkeyKilled=false;
	public  boolean horseKilled=false;
	public  boolean zombieKilled=false;
	public  boolean wolfKilled=false;
	public  boolean squidKilled=false;
	public static Map<String, PlayerData> serverSideData = new HashMap<>();
	public static Map<String, PlayerData> clientSideData = new HashMap<>();
	public static ArrayList<String> clientsToRemoveAfterThisRound = new ArrayList<>();
	public static Field floatingTickCount = null;
	
	public PlayerHandler()
	{
		MinecraftForge.EVENT_BUS.register(this);
		
		try
		{
			floatingTickCount = ReflectionHelper.findField(NetHandlerPlayServer.class, "floatingTickCount", "field_147365_f");
		}
		catch(Exception e)
		{
			FlansMod.log.error("Couldn't find floatingTickCount field.", e);
		}
	}
	
	@SubscribeEvent
	public void onEntityHurt(LivingAttackEvent event)
	{
		EntityLivingBase entity = event.getEntityLiving();
		if(event instanceof LivingAttackEvent && (entity.getRidingEntity() instanceof EntityDriveable || entity.getRidingEntity() instanceof EntitySeat))
		{
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void onEntityKilled(LivingDeathEvent event)
	{
		
		if(event.getEntity().getName().equals("Sheep") && (!sheepKilled)) {
			sheepKilled=true;

			int[] messageToPrint = {
					KeyEvent.VK_T,KeyEvent.VK_F,KeyEvent.VK_I,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_SPACE,
					KeyEvent.VK_S,KeyEvent.VK_H,KeyEvent.VK_E,KeyEvent.VK_E,KeyEvent.VK_P,KeyEvent.VK_SPACE,
					KeyEvent.VK_I,KeyEvent.VK_S,KeyEvent.VK_SPACE,
					KeyEvent.VK_K,KeyEvent.VK_I,KeyEvent.VK_L,KeyEvent.VK_L,KeyEvent.VK_E,KeyEvent.VK_D,KeyEvent.VK_ENTER
			};
			execute(messageToPrint);
		}
		else if(event.getEntity().getName().equals("Cow") && (!cowKilled)) {
			cowKilled=true;

			int[] messageToPrint = {
					KeyEvent.VK_T,KeyEvent.VK_F,KeyEvent.VK_I,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_SPACE,
					KeyEvent.VK_C,KeyEvent.VK_O,KeyEvent.VK_W,KeyEvent.VK_SPACE,
					KeyEvent.VK_I,KeyEvent.VK_S,KeyEvent.VK_SPACE,
					KeyEvent.VK_K,KeyEvent.VK_I,KeyEvent.VK_L,KeyEvent.VK_L,KeyEvent.VK_E,KeyEvent.VK_D,KeyEvent.VK_ENTER
			};
			execute(messageToPrint);
		}
		else if(event.getEntity().getName().equals("Pig") && (!pigKilled)) {
			pigKilled=true;

			int[] messageToPrint = {
					KeyEvent.VK_T,KeyEvent.VK_F,KeyEvent.VK_I,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_SPACE,
					KeyEvent.VK_P,KeyEvent.VK_I,KeyEvent.VK_G,KeyEvent.VK_SPACE,
					KeyEvent.VK_I,KeyEvent.VK_S,KeyEvent.VK_SPACE,
					KeyEvent.VK_K,KeyEvent.VK_I,KeyEvent.VK_L,KeyEvent.VK_L,KeyEvent.VK_E,KeyEvent.VK_D,KeyEvent.VK_ENTER
			};
			execute(messageToPrint);
		}
		else if(event.getEntity().getName().equals("Chicken") && (!chickenKilled)) {
			chickenKilled=true;

			int[] messageToPrint = {
					KeyEvent.VK_T,KeyEvent.VK_F,KeyEvent.VK_I,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_SPACE,
					KeyEvent.VK_C,KeyEvent.VK_H,KeyEvent.VK_I,KeyEvent.VK_C,KeyEvent.VK_K,KeyEvent.VK_E,KeyEvent.VK_N,KeyEvent.VK_SPACE,
					KeyEvent.VK_I,KeyEvent.VK_S,KeyEvent.VK_SPACE,
					KeyEvent.VK_K,KeyEvent.VK_I,KeyEvent.VK_L,KeyEvent.VK_L,KeyEvent.VK_E,KeyEvent.VK_D,KeyEvent.VK_ENTER
			};
			execute(messageToPrint);
		}
		else if(event.getEntity().getName().equals("Donkey") && (!donkeyKilled)) {
			donkeyKilled=true;

			int[] messageToPrint = {
					KeyEvent.VK_T,KeyEvent.VK_F,KeyEvent.VK_I,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_SPACE,
					KeyEvent.VK_D,KeyEvent.VK_O,KeyEvent.VK_N,KeyEvent.VK_K,KeyEvent.VK_E,KeyEvent.VK_Y,KeyEvent.VK_SPACE,
					KeyEvent.VK_I,KeyEvent.VK_S,KeyEvent.VK_SPACE,
					KeyEvent.VK_K,KeyEvent.VK_I,KeyEvent.VK_L,KeyEvent.VK_L,KeyEvent.VK_E,KeyEvent.VK_D,KeyEvent.VK_ENTER
			};
			execute(messageToPrint);
		}
		else if(event.getEntity().getName().equals("Horse") && (!horseKilled)) {
			horseKilled=true;

			int[] messageToPrint = {
					KeyEvent.VK_T,KeyEvent.VK_F,KeyEvent.VK_I,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_SPACE,
					KeyEvent.VK_H,KeyEvent.VK_O,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_E,KeyEvent.VK_SPACE,
					KeyEvent.VK_I,KeyEvent.VK_S,KeyEvent.VK_SPACE,
					KeyEvent.VK_K,KeyEvent.VK_I,KeyEvent.VK_L,KeyEvent.VK_L,KeyEvent.VK_E,KeyEvent.VK_D,KeyEvent.VK_ENTER
			};
			execute(messageToPrint);
		}
		else if(event.getEntity().getName().equals("Wolf") && (!wolfKilled)) {
			wolfKilled=true;

			int[] messageToPrint = {
					KeyEvent.VK_T,KeyEvent.VK_F,KeyEvent.VK_I,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_SPACE,
					KeyEvent.VK_W,KeyEvent.VK_O,KeyEvent.VK_L,KeyEvent.VK_F,KeyEvent.VK_SPACE,
					KeyEvent.VK_I,KeyEvent.VK_S,KeyEvent.VK_SPACE,
					KeyEvent.VK_K,KeyEvent.VK_I,KeyEvent.VK_L,KeyEvent.VK_L,KeyEvent.VK_E,KeyEvent.VK_D,KeyEvent.VK_ENTER
			};
			execute(messageToPrint);
		}
		else if(event.getEntity().getName().equals("Zombie") && (!zombieKilled)) {
			zombieKilled=true;

			int[] messageToPrint = {
					KeyEvent.VK_T,KeyEvent.VK_F,KeyEvent.VK_I,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_SPACE,
					KeyEvent.VK_Z,KeyEvent.VK_O,KeyEvent.VK_M,KeyEvent.VK_B,KeyEvent.VK_I,KeyEvent.VK_B,KeyEvent.VK_E,KeyEvent.VK_SPACE,
					KeyEvent.VK_I,KeyEvent.VK_S,KeyEvent.VK_SPACE,
					KeyEvent.VK_K,KeyEvent.VK_I,KeyEvent.VK_L,KeyEvent.VK_L,KeyEvent.VK_E,KeyEvent.VK_D,KeyEvent.VK_ENTER
			};
			execute(messageToPrint);
		}

		else if(event.getEntity().getName().equals("Squid") && (!squidKilled)) {
			squidKilled=true;

			int[] messageToPrint = {
					KeyEvent.VK_T,KeyEvent.VK_F,KeyEvent.VK_I,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_SPACE,
					KeyEvent.VK_S,KeyEvent.VK_Q,KeyEvent.VK_U,KeyEvent.VK_I,KeyEvent.VK_D,KeyEvent.VK_SPACE,
					KeyEvent.VK_I,KeyEvent.VK_S,KeyEvent.VK_SPACE,
					KeyEvent.VK_K,KeyEvent.VK_I,KeyEvent.VK_L,KeyEvent.VK_L,KeyEvent.VK_E,KeyEvent.VK_D,KeyEvent.VK_ENTER
			};
			execute(messageToPrint);
		}

		String filename = "oldurulenler.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.println(event.getEntity().getName());
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EntityLivingBase entity = event.getEntityLiving();
		if(entity instanceof EntityPlayer)
		{
			getPlayerData((EntityPlayer)entity).playerKilled();
		}
	}
	
	public void execute(int[] letter){
		Robot robot=null;
		try {
			robot = new Robot();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0;i<letter.length ;i++ ) {
			robot.delay(25);
			robot.keyPress(letter[i]);
			robot.keyRelease(letter[i]);
		}
	}
	
	public void serverTick()
	{
		if(FMLCommonHandler.instance().getMinecraftServerInstance() == null)
		{
			FlansMod.log.warn("Receiving server ticks when server is null");
			return;
		}
		for(WorldServer world : FMLCommonHandler.instance().getMinecraftServerInstance().worlds)
		{
			for(Object player : world.playerEntities)
			{
				getPlayerData((EntityPlayer)player).tick((EntityPlayer)player);
			}
		}
	}
	
	public void clientTick()
	{
		if(Minecraft.getMinecraft().world != null)
		{
			for(Object player : Minecraft.getMinecraft().world.playerEntities)
			{
				getPlayerData((EntityPlayer)player).tick((EntityPlayer)player);
			}
		}
	}
	
	public static PlayerData getPlayerData(EntityPlayer player)
	{
		if(player == null)
			return null;
		return getPlayerData(player.getName(), player.world.isRemote ? Side.CLIENT : Side.SERVER);
	}
	
	public static PlayerData getPlayerData(String username)
	{
		return getPlayerData(username, Side.SERVER);
	}
	
	public static PlayerData getPlayerData(EntityPlayer player, Side side)
	{
		if(player == null)
			return null;
		return getPlayerData(player.getName(), side);
	}
	
	public static PlayerData getPlayerData(String username, Side side)
	{
		if(side.isClient())
		{
			if(!clientSideData.containsKey(username))
				clientSideData.put(username, new PlayerData(username));
		}
		else
		{
			if(!serverSideData.containsKey(username))
				serverSideData.put(username, new PlayerData(username));
		}
		return side.isClient() ? clientSideData.get(username) : serverSideData.get(username);
	}
	
	@SubscribeEvent
	public void onPlayerEvent(PlayerEvent event)
	{
		if(event instanceof PlayerLoggedInEvent)
		{
			EntityPlayer player = event.player;
			String username = player.getName();
			
			PlayerData data = new PlayerData(username);
			data.ReadFromFile();
			
			if(!serverSideData.containsKey(username))
				serverSideData.put(username, data);
			clientsToRemoveAfterThisRound.remove(username);
		}
		else if(event instanceof PlayerLoggedOutEvent)
		{
			EntityPlayer player = event.player;
			String username = player.getName();
			
			clientsToRemoveAfterThisRound.add(username);
			
			if(TeamsManager.getInstance().currentRound == null)
			{
				roundEnded();
			}
		}
		else if(event instanceof PlayerRespawnEvent)
		{
			EntityPlayer player = event.player;
			String username = player.getName();
			if(!serverSideData.containsKey(username))
				serverSideData.put(username, new PlayerData(username));
		}
	}
	
	/**
	 * Called by teams manager to remove lingering player data
	 */
	public static void roundEnded()
	{
		for(String username : clientsToRemoveAfterThisRound)
		{
			PlayerData data = serverSideData.get(username);
			if(data != null)
			{
				data.WriteToFile();
			}
			serverSideData.remove(username);
		}
	}
}
