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
import com.telenav.kivakit.primitive.collections.iteration.CharIterable;
import com.telenav.kivakit.primitive.collections.iteration.CharIterator;
import com.telenav.kivakit.primitive.collections.internal.lexakai.DiagramPrimitiveCollection;
import com.telenav.lexakai.annotations.UmlClassDiagram;

import java.util.List;

import static com.telenav.kivakit.core.ensure.Ensure.unsupported;

/**
 * A collection of primitive char values. All primitive collections have a name that can be retrieved with {@link
 * #objectName()} and a size retrieved with {@link Sized#size()} and they can be emptied with {@link #clear()}. Values
 * in this collection can be iterated with an {@link CharIterator} returned by the {@link CharIterable#iterator()}
 * method.
 * <p>
 * A null value can be assigned to the collection with {@link #nullChar()} and a value can be tested for nullity with
 * {@link #isNull(char)}. In the case where null values may not be desired, {@link #hasNullChar(boolean)} can be used to
 * designate that a collection has no null value and {@link #hasNullChar()} will return true if the collection has a
 * null value.
 * <p>
 * New values can be added with {@link #add(char)}, {@link #addAll(CharCollection)} and {@link #addAll(char[])} and
 * removed with {@link #remove(char)}. In addition, {@link LongValued} values can be added with {@link #addAll(List)},
 * where each value is quantized via {@link LongValued#longValue()} before being added. Since many objects are
 * quantizable, this method is especially useful.
 * <p>
 * Whether a given value or collection of values is in the collection can be determined with {@link #contains(char)} and
 * {@link #containsAll(CharCollection)}.
 *
 * @author jonathanl (shibo)
 * @see Named
 * @see Sized
 * @see CharIterable
 * @see LongValued
 */
@SuppressWarnings("unused") @UmlClassDiagram(diagram = DiagramPrimitiveCollection.class)
public interface CharCollection extends CharIterable, Sized, NamedObject
{
    /**
     * Adds a value to this collection
     *
     * @return True if the value was added, false if there was no room to add it
     */
    boolean add(char value);

    /**
     * Adds all values in the given array
     */
    default boolean addAll(char[] that)
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
            add((char) value.longValue());
        }
    }

    /**
     * Adds all values in the given array
     */
    default boolean addAll(CharCollection that)
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
    default boolean contains(char value)
    {
        return unsupported();
    }

    /**
     * Returns true if this collection contains all the values in the given collection
     */
    default boolean containsAll(CharCollection that)
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
     * Returns true if there is a null char defined for this collection
     */
    boolean hasNullChar();

    /**
     * Sets whether this collection has a null value or not
     */
    PrimitiveCollection hasNullChar(boolean has);

    /**
     * Returns true if the given value is the null value
     */
    boolean isNull(char value);

    /**
     * Returns the char being used to represent the null value
     */
    char nullChar();

    /**
     * Removes the given value from this collection. Some collections may choose not to implement this method.
     *
     * @return True if the value was removed
     */
    default boolean remove(char value)
    {
        return unsupported();
    }
}
