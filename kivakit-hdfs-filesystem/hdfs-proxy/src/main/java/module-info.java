module kivakit.filesystems.hdfs.proxy {
    requires transitive kivakit.application;
    requires transitive kivakit.filesystems.hdfs.proxy.spi;
    requires hadoop.doubly.shaded.protobuf;
    requires java.rmi;
}
