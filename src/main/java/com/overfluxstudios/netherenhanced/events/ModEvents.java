package com.overfluxstudios.netherenhanced.events;

import com.overfluxstudios.netherenhanced.item.ModItems;
import net.minecraft.command.impl.SummonCommand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import java.util.Collection;

public class ModEvents
{
    @SubscribeEvent
    public void onLavaSteelSheep(AttackEntityEvent event)
    {
        if(event.getPlayer().getHeldItemMainhand().getItem() == ModItems.LAVA_BREAD.get())
        {
            if(event.getTarget().isAlive())
            {
                LivingEntity target = (LivingEntity) event.getTarget();
                if(target instanceof SheepEntity)
                {
                    PlayerEntity player = event.getPlayer();

                    player.getHeldItemMainhand().shrink(1);

                    target.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 300));

                    if(!player.world.isRemote())
                    {
                        String msg = TextFormatting.GOLD + "Sheep is now effected with fire resistance!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onLavaSteelSheepDrops(LivingDropsEvent event)
    {
        LivingEntity entity = event.getEntityLiving();

        if(entity instanceof SheepEntity)
        {
            World world = entity.getEntityWorld();
            Collection<ItemEntity> drops = event.getDrops();

            LogManager.getLogger().debug(entity.getActivePotionEffects());

            if(entity.isPotionActive(Effects.FIRE_RESISTANCE))
            {
                drops.add(new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                        new ItemStack(ModItems.LAVA_STEEL_INGOT.get())));

            }
        }
    }
}
