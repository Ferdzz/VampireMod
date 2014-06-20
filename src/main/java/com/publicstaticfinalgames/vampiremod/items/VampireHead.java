package com.publicstaticfinalgames.vampiremod.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.publicstaticfinalgames.vampiremod.Main;

public class VampireHead extends ItemArmor {

	public VampireHead(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return Main.MODID + ":textures/items/vampireArmor.png";
	}
//	
//	@Override
//	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
//		
//	}
//	
//	@Override
//	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
//        GL11.glDisable(GL11.GL_DEPTH_TEST);
//        GL11.glDepthMask(false);
//        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
//        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//        GL11.glDisable(GL11.GL_ALPHA_TEST);
//        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Main.MODID + ":textures/items/vampireArmor.png"));
//        Tessellator tessellator = Tessellator.instance;
//        tessellator.startDrawingQuads();
//        tessellator.addVertexWithUV(0.0D, resolution.getScaledHeight_double(), -90.0D, 0.0D, 1.0D);
//        tessellator.addVertexWithUV(resolution.getScaledWidth_double(), resolution.getScaledHeight_double(), -90.0D, 1.0D, 1.0D);
//        tessellator.addVertexWithUV(resolution.getScaledWidth_double(), 0.0D, -90.0D, 1.0D, 0.0D);
//        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
//        tessellator.draw();
//        GL11.glDepthMask(true);
//        GL11.glEnable(GL11.GL_DEPTH_TEST);
//        GL11.glEnable(GL11.GL_ALPHA_TEST);
//        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//	}
}
