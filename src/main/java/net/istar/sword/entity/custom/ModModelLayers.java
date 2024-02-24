package net.istar.sword.entity.custom;

import net.istar.sword.SandSword;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer DUNEEDGE =
            new EntityModelLayer(new Identifier(SandSword.MOD_ID, "duneedge"), "main");
}