////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// © 2011-2021 Telenav, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.telenav.kivakit.primitive.collections;

import com.telenav.kivakit.interfaces.collection.Sized;
import com.telenav.kivakit.interfaces.naming.Named;
import com.telenav.kivakit.interfaces.naming.NamedObject;
import com.telenav.kivakit.interfaces.value.LongValued;
import com.telenav.kivakit.primitive.collections.internal.lexakai.DiagramPrimitiveCollection;
import com.telenav.kivakit.primitive.collections.iteration.ByteIterable;
import com.telenav.kivakit.primitive.collections.iteration.ByteIterator;
import com.telenav.lexakai.annotations.UmlClassDiagram;

import java.util.List;

import static com.telenav.kivakit.core.ensure.Ensure.unsupported;

/**
 * A collection of primitive byte values. All primitive collections have a name that can be retrieved with
 * {@link #objectName()} and a size retrieved with {@link Sized#size()} and they can be emptied with {@link #clear()}.
 * Values in this collection can be iterated with an {@link ByteIterator} returned by the
 * {@link ByteIterable#iterator()} method.
 * <p>
 * A null value can be assigned to the collection with {@link #nullByte()} and a value can be tested for nullity with
 * {@link #isNull(byte)}. In the case where null values may not be desired, {@link #hasNullByte(boolean)} can be used to
 * designate that a collection has no null value and {@link #hasNullByte()} will return true if the collection has a
 * null value.
 * <p>
 * New values can be added with {@link #add(byte)}, {@link #addAll(ByteIterable)} and {@link #addAll(byte[])} and
 * removed with {@link #remove(byte)}. In addition, {@link LongValued} values can be added with {@link #addAll(List)},
 * where each value is quantized via {@link LongValued#longValue()} before being added. Since many objects are
 * quantizable, this method is especially useful.
 * <p>
 * Whether a given value or collection of values is in the collection can be determined with {@link #contains(byte)} and
 * {@link #containsAll(ByteCollection)}.
 *
 * @author jonathanl (shibo)
 * @see Named
 * @see Sized
 * @see ByteIterable
 * @see LongValued
 */
@SuppressWarnings("unused")
@UmlClassDiagram(diagram = DiagramPrimitiveCollection.class)
public interface ByteCollection extends
        ByteIterable,
        Sized,
        NamedObject
{
    /**
     * Adds a value to this collection
     *
     * @return True if the value was added, false if there was no room to add it
     */
    boolean add(byte value);

    /**
     * Adds all values in the given array
     */
    default boolean addAll(byte[] that)
    {
        for (var value : that)
        {
            if (!add(value))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds the given quantizable values
     */
    default void addAll(List<? extends LongValued> values)
    {
        for (var value : values)
        {
            add((byte) value.longValue());
        }
    }

    /**
     * Adds all values in the given array
     */
    default boolean addAll(ByteIterable that)
    {
        var iterator = that.iterator();
        while (iterator.hasNext())
        {
            if (!add(iterator.next()))
            {
                return false;
            }
        }
        return false;
    }

    /**
     * Removes all values from this collection
     */
    default void clear()
    {
        unsupported();
    }

    /**
     * Returns true if this collection contains the given value. Some collections may choose not to implement this
     * method if the search is too inefficient.
     */
    default boolean contains(byte value)
    {
        return unsupported();
    }

    /**
     * Returns true if this collection contains all the values in the given collection
     */
    default boolean containsAll(ByteCollection that)
    {
        var values = that.iterator();
        while (values.hasNext())
        {
            if (!contains(values.next()))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if there is a null byte defined for this collection
     */
    boolean hasNullByte();

    /**
     * Sets whether this collection has a null value or not
     */
    PrimitiveCollection hasNullByte(boolean has);

    /**
     * Returns true if the given value is the null value
     */
    boolean isNull(byte value);

    /**
     * Returns the byte being used to represent the null value
     */
    byte nullByte();

    /**
     * Removes the given value from this collection. Some collections may choose not to implement this method.
     *
     * @return True if the value was removed
     */
    default boolean remove(byte value)
    {
        return unsupported();
    }
}
