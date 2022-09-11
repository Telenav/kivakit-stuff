[//]: # (start-user-text)

<a href="https://www.kivakit.org">
<img src="https://telenav.github.io/telenav-assets/images/icons/web-32.png" srcset="https://telenav.github.io/telenav-assets/images/icons/web-32-2x.png 2x"/>
</a>
&nbsp;
<a href="https://twitter.com/openkivakit">
<img src="https://telenav.github.io/telenav-assets/images/logos/twitter/twitter-32.png" srcset="https://telenav.github.io/telenav-assets/images/logos/twitter/twitter-32-2x.png 2x"/>
</a>
&nbsp;
<a href="https://kivakit.zulipchat.com">
<img src="https://telenav.github.io/telenav-assets/images/logos/zulip/zulip-32.png" srcset="https://telenav.github.io/telenav-assets/images/logos/zulip/zulip-32-2x.png 2x"/>
</a>

[//]: # (end-user-text)

# kivakit-filesystems-hdfs &nbsp;&nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/communicate-32.png" srcset="https://telenav.github.io/telenav-assets/images/icons/communicate-32-2x.png 2x"/>

HDFS proxy due to large number of conflicts between HDFS and other projects, especially Spark.

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512-2x.png 2x"/>

### Index

[**Summary**](#summary)  
[**Example**](#example)  
[**Technical Note**](#technical-note)  

[**Dependencies**](#dependencies) | [**Class Diagrams**](#class-diagrams) | [**Package Diagrams**](#package-diagrams) | [**Javadoc**](#javadoc)

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512-2x.png 2x"/>

### Dependencies <a name="dependencies"></a> &nbsp;&nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/dependencies-32.png" srcset="https://telenav.github.io/telenav-assets/images/icons/dependencies-32-2x.png 2x"/>

[*Dependency Diagram*](https://www.kivakit.org/1.7.0/lexakai/kivakit-stuff/kivakit-hdfs-filesystem/hdfs/documentation/diagrams/dependencies.svg)

#### Maven Dependency

    <dependency>
        <groupId>com.telenav.kivakit</groupId>
        <artifactId>kivakit-filesystems-hdfs</artifactId>
        <version>1.7.0</version>
    </dependency>

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128-2x.png 2x"/>

[//]: # (start-user-text)

### Summary <a name = "summary"></a>

This module is a filesystem service provider, giving access to HDFS filesystem data under the
[*kivakit-resource*](../../kivakit/resource/README.md)
mini-framework. The service provider implementation will be discovered
using the Java service loader mechanism. All that is required to make use of HDFS paths
with the *File* and *Folder* objects is to:

1. Include the dependency above in *pom.xml*
2. Import *kivakit-filesystems-hdfs* in *module-info.java*
3. Provide an instance of *HdfsSettings* with *Settings.register(settings, cluster)*,
   where *cluster* identifies the HDFS cluster that is used in paths, such as hdfs://*cluster*/data.txt
4. Make use of HDFS path with *File*s and *Folders*

### Example <a name = "example"></a>

For example:

    var settings = new HdfsSettings();

        [...]

    Settings.register(settings, new InstanceIdentifier("my-cluster"));

    var file = File.parse("hdfs://my-cluster/myfile.txt")

### Technical Note <a name = "technical-note"></a>

The HDFS filesystem provider accesses HDFS through a proxy in another process. The reason for
this is that HDFS has many dependencies that cause conflicts, some of which are not easily resolved.
By placing the HDFS code out-of-process, it becomes seamless for a framework user to use HDFS with
any application.

[//]: # (end-user-text)

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128-2x.png 2x"/>

### Class Diagrams <a name="class-diagrams"></a> &nbsp; &nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/diagram-40.png" srcset="https://telenav.github.io/telenav-assets/images/icons/diagram-40-2x.png 2x"/>

[*diagram-hdfs*](https://www.kivakit.org/1.7.0/lexakai/kivakit-stuff/kivakit-hdfs-filesystem/hdfs/documentation/diagrams/diagram-hdfs.svg)

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128-2x.png 2x"/>

### Package Diagrams <a name="package-diagrams"></a> &nbsp;&nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/box-24.png" srcset="https://telenav.github.io/telenav-assets/images/icons/box-24-2x.png 2x"/>

[*com.telenav.kivakit.filesystems.hdfs*](https://www.kivakit.org/1.7.0/lexakai/kivakit-stuff/kivakit-hdfs-filesystem/hdfs/documentation/diagrams/com.telenav.kivakit.filesystems.hdfs.svg)  
[*com.telenav.kivakit.filesystems.hdfs.internal.lexakai*](https://www.kivakit.org/1.7.0/lexakai/kivakit-stuff/kivakit-hdfs-filesystem/hdfs/documentation/diagrams/com.telenav.kivakit.filesystems.hdfs.internal.lexakai.svg)

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128-2x.png 2x"/>

### Javadoc <a name="javadoc"></a> &nbsp;&nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/books-24.png" srcset="https://telenav.github.io/telenav-assets/images/icons/books-24-2x.png 2x"/>

Javadoc coverage for this project is 82.3%.  
  
&nbsp; &nbsp; <img src="https://telenav.github.io/telenav-assets/images/meters/meter-80-96.png" srcset="https://telenav.github.io/telenav-assets/images/meters/meter-80-96-2x.png 2x"/>




| Class | Documentation Sections |
|---|---|
| [*DiagramHdfs*](https://www.kivakit.org/1.7.0/javadoc/kivakit-stuff/kivakit.filesystems.hdfs//////////////////////////////////////////////////////////////////.html) |  |  
| [*HdfsFile*](https://www.kivakit.org/1.7.0/javadoc/kivakit-stuff/kivakit.filesystems.hdfs//////////////////////////////////////////////.html) |  |  
| [*HdfsFileSystemService*](https://www.kivakit.org/1.7.0/javadoc/kivakit-stuff/kivakit.filesystems.hdfs///////////////////////////////////////////////////////////.html) |  |  
| [*HdfsFolder*](https://www.kivakit.org/1.7.0/javadoc/kivakit-stuff/kivakit.filesystems.hdfs////////////////////////////////////////////////.html) |  |  
| [*HdfsProxyClient*](https://www.kivakit.org/1.7.0/javadoc/kivakit-stuff/kivakit.filesystems.hdfs/////////////////////////////////////////////////////.html) |  |  
| [*HdfsProxyIO*](https://www.kivakit.org/1.7.0/javadoc/kivakit-stuff/kivakit.filesystems.hdfs/////////////////////////////////////////////////.html) |  |  
| [*HdfsSettings*](https://www.kivakit.org/1.7.0/javadoc/kivakit-stuff/kivakit.filesystems.hdfs//////////////////////////////////////////////////.html) | Settings |  

[//]: # (start-user-text)



[//]: # (end-user-text)

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512-2x.png 2x"/>

<sub>Copyright &#169; 2011-2021 [Telenav](https://telenav.com), Inc. Distributed under [Apache License, Version 2.0](LICENSE)</sub>  
<sub>This documentation was generated by [Lexakai](https://lexakai.org). UML diagrams courtesy of [PlantUML](https://plantuml.com).</sub>
