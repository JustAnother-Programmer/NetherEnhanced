package com.overfluxstudios.netherenhanced.item;

import com.overfluxstudios.netherenhanced.NetherEnhanced;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class LavaBread extends Item
{
    public LavaBread(){
        super(new Properties().group(NetherEnhanced.NETHERENHANCED_TAB)
                .food(new Food.Builder()
                        .hunger(6)
                        .saturation(2)
                        .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 300, 1), 1f)
                        .build()));
    }
}
