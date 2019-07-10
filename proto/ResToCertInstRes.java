// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ResToCertInstRes.proto

public final class ResToCertInstRes {
  private ResToCertInstRes() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ResToCertInstResFormatOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ResToCertInstResFormat)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required bytes v2gMessage = 1;</code>
     */
    boolean hasV2GMessage();
    /**
     * <code>required bytes v2gMessage = 1;</code>
     */
    com.google.protobuf.ByteString getV2GMessage();
  }
  /**
   * Protobuf type {@code ResToCertInstResFormat}
   */
  public  static final class ResToCertInstResFormat extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ResToCertInstResFormat)
      ResToCertInstResFormatOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ResToCertInstResFormat.newBuilder() to construct.
    private ResToCertInstResFormat(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ResToCertInstResFormat() {
      v2GMessage_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ResToCertInstResFormat(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              v2GMessage_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ResToCertInstRes.internal_static_ResToCertInstResFormat_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ResToCertInstRes.internal_static_ResToCertInstResFormat_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ResToCertInstRes.ResToCertInstResFormat.class, ResToCertInstRes.ResToCertInstResFormat.Builder.class);
    }

    private int bitField0_;
    public static final int V2GMESSAGE_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString v2GMessage_;
    /**
     * <code>required bytes v2gMessage = 1;</code>
     */
    public boolean hasV2GMessage() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required bytes v2gMessage = 1;</code>
     */
    public com.google.protobuf.ByteString getV2GMessage() {
      return v2GMessage_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasV2GMessage()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, v2GMessage_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, v2GMessage_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof ResToCertInstRes.ResToCertInstResFormat)) {
        return super.equals(obj);
      }
      ResToCertInstRes.ResToCertInstResFormat other = (ResToCertInstRes.ResToCertInstResFormat) obj;

      boolean result = true;
      result = result && (hasV2GMessage() == other.hasV2GMessage());
      if (hasV2GMessage()) {
        result = result && getV2GMessage()
            .equals(other.getV2GMessage());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasV2GMessage()) {
        hash = (37 * hash) + V2GMESSAGE_FIELD_NUMBER;
        hash = (53 * hash) + getV2GMessage().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ResToCertInstRes.ResToCertInstResFormat parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ResToCertInstRes.ResToCertInstResFormat parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ResToCertInstRes.ResToCertInstResFormat prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code ResToCertInstResFormat}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ResToCertInstResFormat)
        ResToCertInstRes.ResToCertInstResFormatOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ResToCertInstRes.internal_static_ResToCertInstResFormat_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ResToCertInstRes.internal_static_ResToCertInstResFormat_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ResToCertInstRes.ResToCertInstResFormat.class, ResToCertInstRes.ResToCertInstResFormat.Builder.class);
      }

      // Construct using ResToCertInstRes.ResToCertInstResFormat.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        v2GMessage_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ResToCertInstRes.internal_static_ResToCertInstResFormat_descriptor;
      }

      public ResToCertInstRes.ResToCertInstResFormat getDefaultInstanceForType() {
        return ResToCertInstRes.ResToCertInstResFormat.getDefaultInstance();
      }

      public ResToCertInstRes.ResToCertInstResFormat build() {
        ResToCertInstRes.ResToCertInstResFormat result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ResToCertInstRes.ResToCertInstResFormat buildPartial() {
        ResToCertInstRes.ResToCertInstResFormat result = new ResToCertInstRes.ResToCertInstResFormat(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.v2GMessage_ = v2GMessage_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ResToCertInstRes.ResToCertInstResFormat) {
          return mergeFrom((ResToCertInstRes.ResToCertInstResFormat)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ResToCertInstRes.ResToCertInstResFormat other) {
        if (other == ResToCertInstRes.ResToCertInstResFormat.getDefaultInstance()) return this;
        if (other.hasV2GMessage()) {
          setV2GMessage(other.getV2GMessage());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasV2GMessage()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ResToCertInstRes.ResToCertInstResFormat parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ResToCertInstRes.ResToCertInstResFormat) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.ByteString v2GMessage_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes v2gMessage = 1;</code>
       */
      public boolean hasV2GMessage() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required bytes v2gMessage = 1;</code>
       */
      public com.google.protobuf.ByteString getV2GMessage() {
        return v2GMessage_;
      }
      /**
       * <code>required bytes v2gMessage = 1;</code>
       */
      public Builder setV2GMessage(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        v2GMessage_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes v2gMessage = 1;</code>
       */
      public Builder clearV2GMessage() {
        bitField0_ = (bitField0_ & ~0x00000001);
        v2GMessage_ = getDefaultInstance().getV2GMessage();
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:ResToCertInstResFormat)
    }

    // @@protoc_insertion_point(class_scope:ResToCertInstResFormat)
    private static final ResToCertInstRes.ResToCertInstResFormat DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ResToCertInstRes.ResToCertInstResFormat();
    }

    public static ResToCertInstRes.ResToCertInstResFormat getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<ResToCertInstResFormat>
        PARSER = new com.google.protobuf.AbstractParser<ResToCertInstResFormat>() {
      public ResToCertInstResFormat parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new ResToCertInstResFormat(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ResToCertInstResFormat> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ResToCertInstResFormat> getParserForType() {
      return PARSER;
    }

    public ResToCertInstRes.ResToCertInstResFormat getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ResToCertInstResFormat_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResToCertInstResFormat_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026ResToCertInstRes.proto\",\n\026ResToCertIns" +
      "tResFormat\022\022\n\nv2gMessage\030\001 \002(\014B\022B\020ResToC" +
      "ertInstRes"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ResToCertInstResFormat_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ResToCertInstResFormat_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ResToCertInstResFormat_descriptor,
        new java.lang.String[] { "V2GMessage", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
