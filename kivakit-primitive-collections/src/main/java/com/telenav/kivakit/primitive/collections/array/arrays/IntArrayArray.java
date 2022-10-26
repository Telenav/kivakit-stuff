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

package com.telenav.kivakit.primitive.collections.array.arrays;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.telenav.kivakit.core.language.Hash;
import com.telenav.kivakit.core.language.Objects;
import com.telenav.kivakit.primitive.collections.CompressibleCollection;
import com.telenav.kivakit.primitive.collections.array.PrimitiveArrayArray;
import com.telenav.kivakit.primitive.collections.array.scalars.IntArray;
import com.telenav.kivakit.primitive.collections.iteration.IntIterable;
import com.telenav.kivakit.primitive.collections.iteration.IntIterator;
import com.telenav.kivakit.primitive.collections.internal.lexakai.DiagramPrimitiveArrayArray;
import com.telenav.lexakai.annotations.UmlClassDiagram;

/**
 * Optimized storage of two-dimensional int arrays. A sequence of {@link IntArray} objects can be added by calling
 * {@link #add(IntIterable)}. The stored array can be retrieved later by calling {@link #get(int)} passing in the
 * identifier that was returned by add. The number of int arrays can be retrieved with {@link #size()}
 * <p>
 * This class supports the {@link #hashCode()} / {@link #equals(Object)} contract and is {@link KryoSerializable}
 *
 * @author jonathanl (shibo)
 * @see IntIterable
 * @see IntIterator
 * @see IntArray
 * @see KryoSerializable
 */
@SuppressWarnings("DuplicatedCode") @UmlClassDiagram(diagram = DiagramPrimitiveArrayArray.class)
public final class IntArrayArray extends PrimitiveArrayArray
{
    private IntArray indexes;

    private IntArray sizes;

    private IntArray store;

    public IntArrayArray(String objectName)
    {
        super(objectName);
    }

    private IntArrayArray()
    {
    }

    /**
     * Adds the given values and returns an identifier that can be used to retrieve the values as a {@link IntArray}
     * with {@link #get(int)}.
     *
     * @param values The values to add
     * @return An identifier for the values that were added
     */
    public int add(IntIterable values)
    {
        return add(values.iterator());
    }

    /**
     * Adds the given values and returns an identifier that can be used to retrieve the values as a {@link IntArray}
     * with {@link #get(int)}.
     *
     * @param values The values to add
     * @return An identifier for the values that were added
     */
    public int add(int[] values)
    {
        assert ensureHasRoomFor(1);

        var index = store.size();
        indexes.add(index);
        sizes.add(values.length);
        store.addAll(values);

        return index;
    }

    /**
     * Adds the given values and returns an identifier that can be used to retrieve the values as a {@link IntArray}
     * with {@link #get(int)}.
     *
     * @param values The values to add
     * @return An identifier for the values that were added
     */
    public int add(IntIterator values)
    {
        assert ensureHasRoomFor(1);

        var index = store.size();
        indexes.add(index);

        // Add all the values to the store
        var size = 0;
        while (values.hasNext())
        {
            store.add(values.next());
            size++;
        }
        sizes.add(size);

        return indexes.size() - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object)
    {
        if (object instanceof IntArrayArray that)
        {
            return Objects.areEqualPairs(indexes, that.indexes, sizes, that.sizes, store, that.store);
        }
        return false;
    }

    /**
     * Returns the int array for the given identifier
     */
    public IntArray get(int identifier)
    {
        return store.subArray(indexes.get(identifier), sizes.get(identifier));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return Hash.hashMany(indexes, sizes, store);
    }

    /**
     * Returns the size of the identified array
     */
    public int length(int identifier)
    {
        return sizes.get(identifier);
    }

    @Override
    public CompressibleCollection.Method onCompress(CompressibleCollection.Method method)
    {
        indexes.compress(method);
        sizes.compress(method);
        store.compress(method);

        return CompressibleCollection.Method.RESIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onInitialize()
    {
        super.onInitialize();

        store = new IntArray(objectName() + ".bytes");
        store.initialSize(initialSizeAsInt());
        indexes = new IntArray(objectName() + ".indexes");
        sizes = new IntArray(objectName() + ".sizes");

        store.initialize();
        indexes.initialize();
        sizes.initialize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(Kryo kryo, Input input)
    {
        super.read(kryo, input);

        indexes = kryo.readObject(input, IntArray.class);
        sizes = kryo.readObject(input, IntArray.class);
        store = kryo.readObject(input, IntArray.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size()
    {
        return indexes.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(Kryo kryo, Output output)
    {
        super.write(kryo, output);

        kryo.writeObject(output, indexes);
        kryo.writeObject(output, sizes);
        kryo.writeObject(output, store);
    }
}
