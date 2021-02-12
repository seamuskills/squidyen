package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SRespawnPacket implements IPacket<IClientPlayNetHandler> {
   private RegistryKey<DimensionType> field_240822_a_;
   private RegistryKey<World> dimensionID;
   /** First 8 bytes of the SHA-256 hash of the world's seed */
   private long hashedSeed;
   private GameType gameType;
   private GameType field_241787_e_;
   private boolean field_240823_e_;
   private boolean field_240824_f_;
   private boolean field_240825_g_;

   public SRespawnPacket() {
   }

   public SRespawnPacket(RegistryKey<DimensionType> p_i241269_1_, RegistryKey<World> p_i241269_2_, long p_i241269_3_, GameType p_i241269_5_, GameType p_i241269_6_, boolean p_i241269_7_, boolean p_i241269_8_, boolean p_i241269_9_) {
      this.field_240822_a_ = p_i241269_1_;
      this.dimensionID = p_i241269_2_;
      this.hashedSeed = p_i241269_3_;
      this.gameType = p_i241269_5_;
      this.field_241787_e_ = p_i241269_6_;
      this.field_240823_e_ = p_i241269_7_;
      this.field_240824_f_ = p_i241269_8_;
      this.field_240825_g_ = p_i241269_9_;
   }

   /**
    * Passes this Packet on to the NetHandler for processing.
    */
   public void processPacket(IClientPlayNetHandler handler) {
      handler.handleRespawn(this);
   }

   /**
    * Reads the raw packet data from the data stream.
    */
   public void readPacketData(PacketBuffer buf) throws IOException {
      this.field_240822_a_ = RegistryKey.func_240903_a_(Registry.field_239698_ad_, buf.readResourceLocation());
      this.dimensionID = RegistryKey.func_240903_a_(Registry.field_239699_ae_, buf.readResourceLocation());
      this.hashedSeed = buf.readLong();
      this.gameType = GameType.getByID(buf.readUnsignedByte());
      this.field_241787_e_ = GameType.getByID(buf.readUnsignedByte());
      this.field_240823_e_ = buf.readBoolean();
      this.field_240824_f_ = buf.readBoolean();
      this.field_240825_g_ = buf.readBoolean();
   }

   /**
    * Writes the raw packet data to the data stream.
    */
   public void writePacketData(PacketBuffer buf) throws IOException {
      buf.writeResourceLocation(this.field_240822_a_.func_240901_a_());
      buf.writeResourceLocation(this.dimensionID.func_240901_a_());
      buf.writeLong(this.hashedSeed);
      buf.writeByte(this.gameType.getID());
      buf.writeByte(this.field_241787_e_.getID());
      buf.writeBoolean(this.field_240823_e_);
      buf.writeBoolean(this.field_240824_f_);
      buf.writeBoolean(this.field_240825_g_);
   }

   @OnlyIn(Dist.CLIENT)
   public RegistryKey<DimensionType> func_240826_b_() {
      return this.field_240822_a_;
   }

   @OnlyIn(Dist.CLIENT)
   public RegistryKey<World> func_240827_c_() {
      return this.dimensionID;
   }

   /**
    * get value
    */
   @OnlyIn(Dist.CLIENT)
   public long getHashedSeed() {
      return this.hashedSeed;
   }

   @OnlyIn(Dist.CLIENT)
   public GameType getGameType() {
      return this.gameType;
   }

   @OnlyIn(Dist.CLIENT)
   public GameType func_241788_f_() {
      return this.field_241787_e_;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean func_240828_f_() {
      return this.field_240823_e_;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean func_240829_g_() {
      return this.field_240824_f_;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean func_240830_h_() {
      return this.field_240825_g_;
   }
}
