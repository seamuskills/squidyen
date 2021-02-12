package net.minecraft.world.gen.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class DepthAverageConfig implements IPlacementConfig {
   public static final Codec<DepthAverageConfig> field_236955_a_ = RecordCodecBuilder.create((p_236956_0_) -> {
      return p_236956_0_.group(Codec.INT.fieldOf("count").forGetter((p_236959_0_) -> {
         return p_236959_0_.count;
      }), Codec.INT.fieldOf("baseline").forGetter((p_236958_0_) -> {
         return p_236958_0_.baseline;
      }), Codec.INT.fieldOf("spread").forGetter((p_236957_0_) -> {
         return p_236957_0_.spread;
      })).apply(p_236956_0_, DepthAverageConfig::new);
   });
   public final int count;
   public final int baseline;
   public final int spread;

   public DepthAverageConfig(int count, int baseline, int spread) {
      this.count = count;
      this.baseline = baseline;
      this.spread = spread;
   }
}
