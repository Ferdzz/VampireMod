package com.publicstaticfinalgames.vampiremod;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import com.publicstaticfinalgames.vampiremod.items.VampireHead;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
	public static final String NAME = "Vampire Mod";
	public static final String MODID = "VampireMod";
	public static final String VERSION = "1.0";

	@Instance
	public static Main instance;

	private static Random rand;
	public static ItemArmor head;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		rand = new Random();
		head = (ItemArmor) new VampireHead(EnumHelper.addArmorMaterial("vampire", 500, new int[] { 5, 2, 3, 4 }, 3), 0, 0).setUnlocalizedName("head").setCreativeTab(CreativeTabs.tabCombat).setTextureName(MODID + ":vampireHead");

		MinecraftForge.EVENT_BUS.register(instance);
		GameRegistry.registerItem(head, "head");

		GameRegistry.addRecipe(new ItemStack(Main.head, 1), new Object[] {
				"BBB",
				"WWW",
				"RPR",
				'B', new ItemStack(Blocks.wool, 1, 15),
				'W', new ItemStack(Blocks.wool, 1, 0),
				'R', Blocks.redstone_block,
				'P', new ItemStack(Items.potionitem, 1, 8194)
		});

	}

	@SubscribeEvent
	public void beingVampire(LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			if (((EntityPlayer) event.entity).inventory.armorItemInSlot(3) != null) {
				if (((EntityPlayer) event.entity).inventory.armorItemInSlot(3).getItem() instanceof VampireHead) {
					((EntityPlayer) event.entityLiving).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10, 0));
					((EntityPlayer) event.entityLiving).addPotionEffect(new PotionEffect(Potion.resistance.id, 10, 0));
					((EntityPlayer) event.entityLiving).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10, 0));

					if (!event.entity.worldObj.isRemote && event.entity.worldObj.isDaytime() && event.entity.worldObj.canBlockSeeTheSky(MathHelper.floor_double(event.entityLiving.posX), MathHelper.floor_double(event.entityLiving.posY), MathHelper.floor_double(event.entityLiving.posZ))) {
						event.entityLiving.setFire(15);
						((EntityPlayer) event.entityLiving).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10, 0));
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void fallingVampire(LivingFallEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			if (((EntityPlayer) event.entityLiving).inventory.armorItemInSlot(3) != null) {
				if (((EntityPlayer) event.entityLiving).inventory.armorItemInSlot(3).getItem() instanceof VampireHead) {
					event.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent
	public void attackingVampire(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			if (((EntityPlayer) event.source.getEntity()).inventory.armorItemInSlot(3) != null) {
				if (((EntityPlayer) event.source.getEntity()).inventory.armorItemInSlot(3).getItem() instanceof VampireHead) {
					if (rand.nextBoolean()) {
						((EntityPlayer) event.source.getEntity()).heal(1F);
					}
				}
			}
		}
	}
}
