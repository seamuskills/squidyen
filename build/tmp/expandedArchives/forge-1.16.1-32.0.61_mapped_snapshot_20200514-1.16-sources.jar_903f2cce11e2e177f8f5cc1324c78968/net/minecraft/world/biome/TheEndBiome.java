package net.minecraft.world.biome;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.EndSpikeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public final class TheEndBiome extends Biome {
   public TheEndBiome() {
      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.END_STONE_CONFIG).precipitation(Biome.RainType.NONE).category(Biome.Category.THEEND).depth(0.1F).scale(0.2F).temperature(0.5F).downfall(0.5F).func_235097_a_((new BiomeAmbience.Builder()).func_235246_b_(4159204).func_235248_c_(329011).func_235239_a_(10518688).func_235243_a_(MoodSoundAmbience.field_235027_b_).func_235238_a_()).parent((String)null));
      this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.END_SPIKE.withConfiguration(new EndSpikeFeatureConfig(false, ImmutableList.of(), (BlockPos)null)));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 4, 4));
   }

   @OnlyIn(Dist.CLIENT)
   public int getSkyColor() {
      return 0;
   }
}
