package net.istar.sword.entity.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.istar.sword.SandSword;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(value= EnvType.CLIENT)

public class ModModelLayers {
    public static final EntityModelLayer DUNEEDGE = new EntityModelLayer(new Identifier(SandSword.MOD_ID, "duneedge"), "main");

}