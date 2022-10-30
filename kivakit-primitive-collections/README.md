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

# kivakit-primitive-collections &nbsp;&nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/set-32.png" srcset="https://telenav.github.io/telenav-assets/images/icons/set-32-2x.png 2x"/>

The primitive collections store data in primitive data structures.

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512-2x.png 2x"/>

### Index

[**Summary**](#summary)  

[**Dependencies**](#dependencies) | [**Code Quality**](#code-quality) | [**Class Diagrams**](#class-diagrams) | [**Package Diagrams**](#package-diagrams)

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512-2x.png 2x"/>

### Dependencies <a name="dependencies"></a> &nbsp;&nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/dependencies-32.png" srcset="https://telenav.github.io/telenav-assets/images/icons/dependencies-32-2x.png 2x"/>

[*Dependency Diagram*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/dependencies.svg)

#### Maven Dependency

    <dependency>
        <groupId>com.telenav.kivakit</groupId>
        <artifactId>kivakit-primitive-collections</artifactId>
        <version>1.8.2</version>
    </dependency>

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128-2x.png 2x"/>

[//]: # (start-user-text)

### Summary <a name = "summary"></a>

The *primitive* package contains an extensive set of classes for storing data in primitive data structures, including:

- Dynamic primitive arrays (1 and 2 dimensional)
- Primitive lists, maps, sets and multi-maps
- Bit arrays and bitwise I/O
- Bit-packed arrays
- *Split* versions of many data structures which virtualize several primitive data structures into a single
  large one. This can be beneficial in keeping object allocation and garbage collection under control.

[//]: # (end-user-text)

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128-2x.png 2x"/>

### Code Quality <a name="code-quality"></a> &nbsp;&nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/ruler-32.png" srcset="https://telenav.github.io/telenav-assets/images/icons/ruler-32-2x.png 2x"/>

Code quality for this project is 11.8%.  
  
&nbsp; &nbsp; <img src="https://telenav.github.io/telenav-assets/images/meters/meter-10-96.png" srcset="https://telenav.github.io/telenav-assets/images/meters/meter-10-96-2x.png 2x"/>

| Measurement   | Value                    |
|---------------|--------------------------|
| Stability     | 8.4%&nbsp; &nbsp; <img src="https://telenav.github.io/telenav-assets/images/meters/meter-10-96.png" srcset="https://telenav.github.io/telenav-assets/images/meters/meter-10-96-2x.png 2x"/>     |
| Testing       | 8.4%&nbsp; &nbsp; <img src="https://telenav.github.io/telenav-assets/images/meters/meter-10-96.png" srcset="https://telenav.github.io/telenav-assets/images/meters/meter-10-96-2x.png 2x"/>       |
| Documentation | 18.5%&nbsp; &nbsp; <img src="https://telenav.github.io/telenav-assets/images/meters/meter-20-96.png" srcset="https://telenav.github.io/telenav-assets/images/meters/meter-20-96-2x.png 2x"/> |

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128-2x.png 2x"/>

### Class Diagrams <a name="class-diagrams"></a> &nbsp; &nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/diagram-40.png" srcset="https://telenav.github.io/telenav-assets/images/icons/diagram-40-2x.png 2x"/>

[*Primitive Arrays*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/diagram-primitive-array.svg)  
[*Primitive Bit I/O*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/diagram-primitive-array-bit-io.svg)  
[*Primitive Collections*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/diagram-primitive-collection.svg)  
[*Primitive Lists*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/diagram-primitive-list.svg)  
[*Primitive Maps*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/diagram-primitive-map.svg)  
[*Primitive Multi-Maps*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/diagram-primitive-multi-map.svg)  
[*Primitive Sets*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/diagram-primitive-set.svg)  
[*Split Primitive Arrays*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/diagram-primitive-split-array.svg)  
[*Two-Dimensional Arrays*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/diagram-primitive-array-array.svg)

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-128-2x.png 2x"/>

### Package Diagrams <a name="package-diagrams"></a> &nbsp;&nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/box-24.png" srcset="https://telenav.github.io/telenav-assets/images/icons/box-24-2x.png 2x"/>

[*com.telenav.kivakit.primitive.collections*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.svg)  
[*com.telenav.kivakit.primitive.collections.array*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.array.svg)  
[*com.telenav.kivakit.primitive.collections.array.arrays*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.array.arrays.svg)  
[*com.telenav.kivakit.primitive.collections.array.bits*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.array.bits.svg)  
[*com.telenav.kivakit.primitive.collections.array.bits.io*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.array.bits.io.svg)  
[*com.telenav.kivakit.primitive.collections.array.bits.io.input*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.array.bits.io.input.svg)  
[*com.telenav.kivakit.primitive.collections.array.bits.io.output*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.array.bits.io.output.svg)  
[*com.telenav.kivakit.primitive.collections.array.packed*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.array.packed.svg)  
[*com.telenav.kivakit.primitive.collections.array.scalars*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.array.scalars.svg)  
[*com.telenav.kivakit.primitive.collections.array.strings*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.array.strings.svg)  
[*com.telenav.kivakit.primitive.collections.internal.lexakai*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.internal.lexakai.svg)  
[*com.telenav.kivakit.primitive.collections.iteration*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.iteration.svg)  
[*com.telenav.kivakit.primitive.collections.list*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.list.svg)  
[*com.telenav.kivakit.primitive.collections.list.adapters*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.list.adapters.svg)  
[*com.telenav.kivakit.primitive.collections.list.store*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.list.store.svg)  
[*com.telenav.kivakit.primitive.collections.map*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.map.svg)  
[*com.telenav.kivakit.primitive.collections.map.multi*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.map.multi.svg)  
[*com.telenav.kivakit.primitive.collections.map.multi.dynamic*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.map.multi.dynamic.svg)  
[*com.telenav.kivakit.primitive.collections.map.objects*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.map.objects.svg)  
[*com.telenav.kivakit.primitive.collections.map.scalars*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.map.scalars.svg)  
[*com.telenav.kivakit.primitive.collections.map.scalars.fixed*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.map.scalars.fixed.svg)  
[*com.telenav.kivakit.primitive.collections.map.split*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.map.split.svg)  
[*com.telenav.kivakit.primitive.collections.set*](https://www.kivakit.org/1.8.2/lexakai/kivakit-stuff/kivakit-primitive-collections/documentation/diagrams/com.telenav.kivakit.primitive.collections.set.svg)

### Javadoc <a name="code-quality"></a> &nbsp;&nbsp; <img src="https://telenav.github.io/telenav-assets/images/icons/books-24.png" srcset="https://telenav.github.io/telenav-assets/images/icons/books-24-2x.png 2x"/>

| Class | Documentation Sections  |
|-------|-------------------------|
| [*BaseBitReader*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*BaseBitWriter*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*BigSplitPackedArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////.html) |  |  
| [*BitArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////.html) |  |  
| [*BitInput*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*BitOutput*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////////.html) |  |  
| [*BitReader*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////.html) |  |  
| [*BitWriter*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////.html) |  |  
| [*ByteArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////.html) |  |  
| [*ByteArrayArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////.html) |  |  
| [*ByteCollection*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////.html) |  |  
| [*ByteIterable*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////.html) |  |  
| [*ByteIterator*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////.html) |  |  
| [*ByteList*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////.html) |  |  
| [*CharArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////.html) |  |  
| [*CharArray.Converter*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*CharCollection*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////.html) |  |  
| [*CharIterable*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////.html) |  |  
| [*CharIterator*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////.html) |  |  
| [*CharList*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////.html) |  |  
| [*CompressibleCollection*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////.html) |  |  
| [*CompressibleCollection.CompressionEvent*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*CompressibleCollection.Method*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////.html) |  |  
| [*DefaultHashingStrategy*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////.html) |  |  
| [*DiagramPrimitiveArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*DiagramPrimitiveArrayArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*DiagramPrimitiveArrayBitIo*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*DiagramPrimitiveCollection*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*DiagramPrimitiveList*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*DiagramPrimitiveMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*DiagramPrimitiveMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*DiagramPrimitiveSet*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*DiagramPrimitiveSplitArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*DoubleQuantizable*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////.html) |  |  
| [*FixedSizeBitArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*HashingStrategy*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////.html) |  |  
| [*IntArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////.html) |  |  
| [*IntArray.Converter*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////.html) |  |  
| [*IntArrayArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////.html) |  |  
| [*IntCollection*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////.html) |  |  
| [*IntIterable*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////.html) |  |  
| [*IntIterator*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////.html) |  |  
| [*IntLinkedListStore*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////.html) |  |  
| [*IntList*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////.html) |  |  
| [*IntListAdapter*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*IntMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////.html) |  |  
| [*IntToByteFixedMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*IntToByteMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////.html) |  |  
| [*IntToByteMap.EntryVisitor*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*IntToIntFixedMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*IntToIntMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////.html) |  |  
| [*IntToIntMap.EntryVisitor*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*IntToLongFixedMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*IntToLongMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////.html) |  |  
| [*IntToLongMap.EntryVisitor*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*IntToPackedArrayFixedMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////.html) |  |  
| [*LongArray.Converter*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongArrayArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongCollection*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////.html) |  |  
| [*LongIterable*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////.html) |  |  
| [*LongIterator*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////.html) |  |  
| [*LongKeyed*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////.html) |  |  
| [*LongLinkedListStore*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongList*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////.html) |  |  
| [*LongMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////.html) |  |  
| [*LongSet*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////.html) |  |  
| [*LongToByteFixedMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToByteMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToByteMap.EntryVisitor*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToIntFixedMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToIntMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToIntMap.EntryVisitor*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToIntMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToLongFixedMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToLongMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToLongMap.EntryVisitor*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToLongMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*LongToObjectMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////.html) |  |  
| [*PackedArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////.html) |  |  
| [*PackedPrimitiveArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PackedPrimitiveArray.OverflowHandling*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PackedStringArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PackedStringArray.Type*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PackedStringStore*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveArrayArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveCollection*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveCollection.AllocationStackTrace*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveCollection.CompressionRecord*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveCollection.IndexedToString*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveCollectionsKryoTypes*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveIterator*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveList*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveListStore*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveMap.MapToString*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveMultiMap.MultiMapToString*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveScalarMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveScalarMultiMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveSet*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveSet.SetToString*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*PrimitiveSplitArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////.html) |  |  
| [*ShortArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////.html) |  |  
| [*ShortArray.Converter*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////////////.html) |  |  
| [*ShortCollection*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////.html) |  |  
| [*ShortIterable*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////.html) |  |  
| [*ShortIterator*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////.html) |  |  
| [*ShortList*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////.html) |  |  
| [*SplitByteArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*SplitCharArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*SplitIntArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////.html) |  |  
| [*SplitIntToIntMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////.html) |  |  
| [*SplitLongArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*SplitLongSet*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////.html) |  |  
| [*SplitLongToByteMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*SplitLongToIntMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections//////////////////////////////////////////////////////////////////////.html) |  |  
| [*SplitLongToLongMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////.html) |  |  
| [*SplitPackedArray*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////.html) |  |  
| [*SplitPrimitiveMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////.html) |  |  
| [*StringToIntMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections/////////////////////////////////////////////////////////////////////.html) |  |  
| [*StringToObjectMap*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections////////////////////////////////////////////////////////////////////////.html) |  |  
| [*VariableReadSizeBitInput*](https://www.kivakit.org/1.8.2/javadoc/kivakit-stuff/kivakit.primitive.collections///////////////////////////////////////////////////////////////////////////////////////.html) |  |  

[//]: # (start-user-text)



[//]: # (end-user-text)

<img src="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512.png" srcset="https://telenav.github.io/telenav-assets/images/separators/horizontal-line-512-2x.png 2x"/>

<sub>Copyright &#169; 2011-2021 [Telenav](https://telenav.com), Inc. Distributed under [Apache License, Version 2.0](LICENSE)</sub>  
<sub>This documentation was generated by [Lexakai](https://lexakai.org). UML diagrams courtesy of [PlantUML](https://plantuml.com).</sub>
