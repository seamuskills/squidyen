package net.minecraft.data.advancements;

import java.util.function.Consumer;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.BlockPredicate;
import net.minecraft.advancements.criterion.BrewedPotionTrigger;
import net.minecraft.advancements.criterion.ChangeDimensionTrigger;
import net.minecraft.advancements.criterion.ConstructBeaconTrigger;
import net.minecraft.advancements.criterion.DamageSourcePredicate;
import net.minecraft.advancements.criterion.DistancePredicate;
import net.minecraft.advancements.criterion.EffectsChangedTrigger;
import net.minecraft.advancements.criterion.EntityEquipmentPredicate;
import net.minecraft.advancements.criterion.EntityFlagsPredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemDurabilityTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.KilledTrigger;
import net.minecraft.advancements.criterion.LocationPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.MobEffectsPredicate;
import net.minecraft.advancements.criterion.NetherTravelTrigger;
import net.minecraft.advancements.criterion.PlayerEntityInteractionTrigger;
import net.minecraft.advancements.criterion.PlayerGeneratesContainerLootTrigger;
import net.minecraft.advancements.criterion.PositionTrigger;
import net.minecraft.advancements.criterion.RightClickBlockWithItemTrigger;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.advancements.criterion.SummonedEntityTrigger;
import net.minecraft.advancements.criterion.ThrownItemPickedUpByEntityTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.EntityHasProperty;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.structure.Structure;

public class NetherAdvancements implements Consumer<Consumer<Advancement>> {
   private static final Biome[] field_239827_a_ = new Biome[]{Biomes.field_235254_j_, Biomes.field_235252_ay_, Biomes.field_235250_aA_, Biomes.field_235253_az_, Biomes.field_235251_aB_};
   private static final EntityPredicate.AndPredicate field_241748_b_ = EntityPredicate.AndPredicate.func_234591_a_(EntityHasProperty.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().equipment(EntityEquipmentPredicate.Builder.func_234266_a_().func_234267_a_(ItemPredicate.Builder.create().item(Items.GOLDEN_HELMET).build()).func_234268_b_())).inverted().build(), EntityHasProperty.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().equipment(EntityEquipmentPredicate.Builder.func_234266_a_().func_234269_b_(ItemPredicate.Builder.create().item(Items.GOLDEN_CHESTPLATE).build()).func_234268_b_())).inverted().build(), EntityHasProperty.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().equipment(EntityEquipmentPredicate.Builder.func_234266_a_().func_234270_c_(ItemPredicate.Builder.create().item(Items.GOLDEN_LEGGINGS).build()).func_234268_b_())).inverted().build(), EntityHasProperty.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().equipment(EntityEquipmentPredicate.Builder.func_234266_a_().func_234271_d_(ItemPredicate.Builder.create().item(Items.GOLDEN_BOOTS).build()).func_234268_b_())).inverted().build());

   public void accept(Consumer<Advancement> p_accept_1_) {
      Advancement advancement = Advancement.Builder.builder().withDisplay(Blocks.RED_NETHER_BRICKS, new TranslationTextComponent("advancements.nether.root.title"), new TranslationTextComponent("advancements.nether.root.description"), new ResourceLocation("textures/gui/advancements/backgrounds/nether.png"), FrameType.TASK, false, false, false).withCriterion("entered_nether", ChangeDimensionTrigger.Instance.func_233552_a_(World.field_234919_h_)).register(p_accept_1_, "nether/root");
      Advancement advancement1 = Advancement.Builder.builder().withParent(advancement).withDisplay(Items.FIRE_CHARGE, new TranslationTextComponent("advancements.nether.return_to_sender.title"), new TranslationTextComponent("advancements.nether.return_to_sender.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).withRewards(AdvancementRewards.Builder.experience(50)).withCriterion("killed_ghast", KilledTrigger.Instance.playerKilledEntity(EntityPredicate.Builder.create().type(EntityType.GHAST), DamageSourcePredicate.Builder.damageType().isProjectile(true).direct(EntityPredicate.Builder.create().type(EntityType.FIREBALL)))).register(p_accept_1_, "nether/return_to_sender");
      Advancement advancement2 = Advancement.Builder.builder().withParent(advancement).withDisplay(Blocks.NETHER_BRICKS, new TranslationTextComponent("advancements.nether.find_fortress.title"), new TranslationTextComponent("advancements.nether.find_fortress.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("fortress", PositionTrigger.Instance.forLocation(LocationPredicate.forFeature(Structure.field_236378_n_))).register(p_accept_1_, "nether/find_fortress");
      Advancement.Builder.builder().withParent(advancement).withDisplay(Items.MAP, new TranslationTextComponent("advancements.nether.fast_travel.title"), new TranslationTextComponent("advancements.nether.fast_travel.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).withRewards(AdvancementRewards.Builder.experience(100)).withCriterion("travelled", NetherTravelTrigger.Instance.forDistance(DistancePredicate.forHorizontal(MinMaxBounds.FloatBound.atLeast(7000.0F)))).register(p_accept_1_, "nether/fast_travel");
      Advancement.Builder.builder().withParent(advancement1).withDisplay(Items.GHAST_TEAR, new TranslationTextComponent("advancements.nether.uneasy_alliance.title"), new TranslationTextComponent("advancements.nether.uneasy_alliance.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).withRewards(AdvancementRewards.Builder.experience(100)).withCriterion("killed_ghast", KilledTrigger.Instance.playerKilledEntity(EntityPredicate.Builder.create().type(EntityType.GHAST).location(LocationPredicate.func_235308_a_(World.field_234918_g_)))).register(p_accept_1_, "nether/uneasy_alliance");
      Advancement advancement3 = Advancement.Builder.builder().withParent(advancement2).withDisplay(Blocks.WITHER_SKELETON_SKULL, new TranslationTextComponent("advancements.nether.get_wither_skull.title"), new TranslationTextComponent("advancements.nether.get_wither_skull.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("wither_skull", InventoryChangeTrigger.Instance.forItems(Blocks.WITHER_SKELETON_SKULL)).register(p_accept_1_, "nether/get_wither_skull");
      Advancement advancement4 = Advancement.Builder.builder().withParent(advancement3).withDisplay(Items.NETHER_STAR, new TranslationTextComponent("advancements.nether.summon_wither.title"), new TranslationTextComponent("advancements.nether.summon_wither.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("summoned", SummonedEntityTrigger.Instance.summonedEntity(EntityPredicate.Builder.create().type(EntityType.WITHER))).register(p_accept_1_, "nether/summon_wither");
      Advancement advancement5 = Advancement.Builder.builder().withParent(advancement2).withDisplay(Items.BLAZE_ROD, new TranslationTextComponent("advancements.nether.obtain_blaze_rod.title"), new TranslationTextComponent("advancements.nether.obtain_blaze_rod.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("blaze_rod", InventoryChangeTrigger.Instance.forItems(Items.BLAZE_ROD)).register(p_accept_1_, "nether/obtain_blaze_rod");
      Advancement advancement6 = Advancement.Builder.builder().withParent(advancement4).withDisplay(Blocks.BEACON, new TranslationTextComponent("advancements.nether.create_beacon.title"), new TranslationTextComponent("advancements.nether.create_beacon.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("beacon", ConstructBeaconTrigger.Instance.forLevel(MinMaxBounds.IntBound.atLeast(1))).register(p_accept_1_, "nether/create_beacon");
      Advancement.Builder.builder().withParent(advancement6).withDisplay(Blocks.BEACON, new TranslationTextComponent("advancements.nether.create_full_beacon.title"), new TranslationTextComponent("advancements.nether.create_full_beacon.description"), (ResourceLocation)null, FrameType.GOAL, true, true, false).withCriterion("beacon", ConstructBeaconTrigger.Instance.forLevel(MinMaxBounds.IntBound.exactly(4))).register(p_accept_1_, "nether/create_full_beacon");
      Advancement advancement7 = Advancement.Builder.builder().withParent(advancement5).withDisplay(Items.POTION, new TranslationTextComponent("advancements.nether.brew_potion.title"), new TranslationTextComponent("advancements.nether.brew_potion.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("potion", BrewedPotionTrigger.Instance.brewedPotion()).register(p_accept_1_, "nether/brew_potion");
      Advancement advancement8 = Advancement.Builder.builder().withParent(advancement7).withDisplay(Items.MILK_BUCKET, new TranslationTextComponent("advancements.nether.all_potions.title"), new TranslationTextComponent("advancements.nether.all_potions.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).withRewards(AdvancementRewards.Builder.experience(100)).withCriterion("all_effects", EffectsChangedTrigger.Instance.forEffect(MobEffectsPredicate.any().addEffect(Effects.SPEED).addEffect(Effects.SLOWNESS).addEffect(Effects.STRENGTH).addEffect(Effects.JUMP_BOOST).addEffect(Effects.REGENERATION).addEffect(Effects.FIRE_RESISTANCE).addEffect(Effects.WATER_BREATHING).addEffect(Effects.INVISIBILITY).addEffect(Effects.NIGHT_VISION).addEffect(Effects.WEAKNESS).addEffect(Effects.POISON).addEffect(Effects.SLOW_FALLING).addEffect(Effects.RESISTANCE))).register(p_accept_1_, "nether/all_potions");
      Advancement.Builder.builder().withParent(advancement8).withDisplay(Items.BUCKET, new TranslationTextComponent("advancements.nether.all_effects.title"), new TranslationTextComponent("advancements.nether.all_effects.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, true).withRewards(AdvancementRewards.Builder.experience(1000)).withCriterion("all_effects", EffectsChangedTrigger.Instance.forEffect(MobEffectsPredicate.any().addEffect(Effects.SPEED).addEffect(Effects.SLOWNESS).addEffect(Effects.STRENGTH).addEffect(Effects.JUMP_BOOST).addEffect(Effects.REGENERATION).addEffect(Effects.FIRE_RESISTANCE).addEffect(Effects.WATER_BREATHING).addEffect(Effects.INVISIBILITY).addEffect(Effects.NIGHT_VISION).addEffect(Effects.WEAKNESS).addEffect(Effects.POISON).addEffect(Effects.WITHER).addEffect(Effects.HASTE).addEffect(Effects.MINING_FATIGUE).addEffect(Effects.LEVITATION).addEffect(Effects.GLOWING).addEffect(Effects.ABSORPTION).addEffect(Effects.HUNGER).addEffect(Effects.NAUSEA).addEffect(Effects.RESISTANCE).addEffect(Effects.SLOW_FALLING).addEffect(Effects.CONDUIT_POWER).addEffect(Effects.DOLPHINS_GRACE).addEffect(Effects.BLINDNESS).addEffect(Effects.BAD_OMEN).addEffect(Effects.HERO_OF_THE_VILLAGE))).register(p_accept_1_, "nether/all_effects");
      Advancement advancement9 = Advancement.Builder.builder().withParent(advancement).withDisplay(Items.field_234795_rx_, new TranslationTextComponent("advancements.nether.obtain_ancient_debris.title"), new TranslationTextComponent("advancements.nether.obtain_ancient_debris.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("ancient_debris", InventoryChangeTrigger.Instance.forItems(Items.field_234795_rx_)).register(p_accept_1_, "nether/obtain_ancient_debris");
      Advancement.Builder.builder().withParent(advancement9).withDisplay(Items.field_234764_lt_, new TranslationTextComponent("advancements.nether.netherite_armor.title"), new TranslationTextComponent("advancements.nether.netherite_armor.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).withRewards(AdvancementRewards.Builder.experience(100)).withCriterion("netherite_armor", InventoryChangeTrigger.Instance.forItems(Items.field_234763_ls_, Items.field_234764_lt_, Items.field_234765_lu_, Items.field_234766_lv_)).register(p_accept_1_, "nether/netherite_armor");
      Advancement.Builder.builder().withParent(advancement9).withDisplay(Items.field_234793_rv_, new TranslationTextComponent("advancements.nether.use_lodestone.title"), new TranslationTextComponent("advancements.nether.use_lodestone.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("use_lodestone", RightClickBlockWithItemTrigger.Instance.func_234852_a_(LocationPredicate.Builder.func_226870_a_().func_235312_a_(BlockPredicate.Builder.func_226243_a_().func_233458_a_(Blocks.field_235405_no_).func_226245_b_()), ItemPredicate.Builder.create().item(Items.COMPASS))).register(p_accept_1_, "nether/use_lodestone");
      Advancement advancement10 = Advancement.Builder.builder().withParent(advancement).withDisplay(Items.field_234797_rz_, new TranslationTextComponent("advancements.nether.obtain_crying_obsidian.title"), new TranslationTextComponent("advancements.nether.obtain_crying_obsidian.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("crying_obsidian", InventoryChangeTrigger.Instance.forItems(Items.field_234797_rz_)).register(p_accept_1_, "nether/obtain_crying_obsidian");
      Advancement.Builder.builder().withParent(advancement10).withDisplay(Items.field_234789_rM_, new TranslationTextComponent("advancements.nether.charge_respawn_anchor.title"), new TranslationTextComponent("advancements.nether.charge_respawn_anchor.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("charge_respawn_anchor", RightClickBlockWithItemTrigger.Instance.func_234852_a_(LocationPredicate.Builder.func_226870_a_().func_235312_a_(BlockPredicate.Builder.func_226243_a_().func_233458_a_(Blocks.field_235400_nj_).func_233459_a_(StatePropertiesPredicate.Builder.newBuilder().withIntProp(RespawnAnchorBlock.field_235559_a_, 4).build()).func_226245_b_()), ItemPredicate.Builder.create().item(Blocks.GLOWSTONE))).register(p_accept_1_, "nether/charge_respawn_anchor");
      Advancement advancement11 = Advancement.Builder.builder().withParent(advancement).withDisplay(Items.field_234774_pk_, new TranslationTextComponent("advancements.nether.ride_strider.title"), new TranslationTextComponent("advancements.nether.ride_strider.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("used_warped_fungus_on_a_stick", ItemDurabilityTrigger.Instance.func_234816_a_(EntityPredicate.AndPredicate.func_234585_a_(EntityPredicate.Builder.create().func_234579_a_(EntityPredicate.Builder.create().type(EntityType.field_233589_aE_).build()).build()), ItemPredicate.Builder.create().item(Items.field_234774_pk_).build(), MinMaxBounds.IntBound.UNBOUNDED)).register(p_accept_1_, "nether/ride_strider");
      AdventureAdvancements.makeBiomeAdvancement(Advancement.Builder.builder(), field_239827_a_).withParent(advancement11).withDisplay(Items.field_234766_lv_, new TranslationTextComponent("advancements.nether.explore_nether.title"), new TranslationTextComponent("advancements.nether.explore_nether.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).withRewards(AdvancementRewards.Builder.experience(500)).register(p_accept_1_, "nether/explore_nether");
      Advancement advancement12 = Advancement.Builder.builder().withParent(advancement).withDisplay(Items.field_234785_rI_, new TranslationTextComponent("advancements.nether.find_bastion.title"), new TranslationTextComponent("advancements.nether.find_bastion.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("bastion", PositionTrigger.Instance.forLocation(LocationPredicate.forFeature(Structure.field_236383_s_))).register(p_accept_1_, "nether/find_bastion");
      Advancement.Builder.builder().withParent(advancement12).withDisplay(Blocks.CHEST, new TranslationTextComponent("advancements.nether.loot_bastion.title"), new TranslationTextComponent("advancements.nether.loot_bastion.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withRequirementsStrategy(IRequirementsStrategy.OR).withCriterion("loot_bastion_other", PlayerGeneratesContainerLootTrigger.Instance.func_235481_a_(new ResourceLocation("minecraft:chests/bastion_other"))).withCriterion("loot_bastion_treasure", PlayerGeneratesContainerLootTrigger.Instance.func_235481_a_(new ResourceLocation("minecraft:chests/bastion_treasure"))).withCriterion("loot_bastion_hoglin_stable", PlayerGeneratesContainerLootTrigger.Instance.func_235481_a_(new ResourceLocation("minecraft:chests/bastion_hoglin_stable"))).withCriterion("loot_bastion_bridge", PlayerGeneratesContainerLootTrigger.Instance.func_235481_a_(new ResourceLocation("minecraft:chests/bastion_bridge"))).register(p_accept_1_, "nether/loot_bastion");
      Advancement.Builder.builder().withParent(advancement).withRequirementsStrategy(IRequirementsStrategy.OR).withDisplay(Items.GOLD_INGOT, new TranslationTextComponent("advancements.nether.distract_piglin.title"), new TranslationTextComponent("advancements.nether.distract_piglin.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("distract_piglin", ThrownItemPickedUpByEntityTrigger.Instance.func_234835_a_(field_241748_b_, ItemPredicate.Builder.create().tag(ItemTags.field_232903_N_), EntityPredicate.AndPredicate.func_234585_a_(EntityPredicate.Builder.create().type(EntityType.field_233591_ai_).flags(EntityFlagsPredicate.Builder.create().func_241396_e_(false).build()).build()))).withCriterion("distract_piglin_directly", PlayerEntityInteractionTrigger.Instance.func_241480_a_(field_241748_b_, ItemPredicate.Builder.create().item(PiglinTasks.field_234444_a_), EntityPredicate.AndPredicate.func_234585_a_(EntityPredicate.Builder.create().type(EntityType.field_233591_ai_).flags(EntityFlagsPredicate.Builder.create().func_241396_e_(false).build()).build()))).register(p_accept_1_, "nether/distract_piglin");
   }
}
