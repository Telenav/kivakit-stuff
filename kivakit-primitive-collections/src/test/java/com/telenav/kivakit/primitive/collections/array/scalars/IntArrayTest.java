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

package com.telenav.kivakit.primitive.collections.array.scalars;

import com.telenav.kivakit.primitive.collections.PrimitiveCollectionsUnitTest;
import org.junit.Test;

import java.util.HashMap;

import static com.telenav.kivakit.core.value.count.Count._10;

public class IntArrayTest extends PrimitiveCollectionsUnitTest
{
    @Test
    public void testAdd()
    {
        var array = array();
        array.hasNullInt(false);

        var values = random().list(Integer.class);
        values.forEach(array::add);

        index = 0;
        values.forEach(value -> ensureEqual(array.get(index++), value));
    }

    @Test
    public void testClear()
    {
        var array = array();
        array.hasNullInt(false);

        random().intSequence(array::add);
        random().indexes(array.size(), index ->
        {
            ensure(!array.isNull(array.get(index)));
            array.clear(index);
            ensure(!array.isNull(array.get(index)));
        });

        array.nullInt(-1);
        random().intSequence(value ->
        {
            if (!array.isNull(value))
            {
                array.add(value);
            }
        });

        random().indexes(array.size(), index ->
        {
            if (index < array.size())
            {
                array.set(index, 99);
                ensure(!array.isNull(array.get(index)));
                array.clear(index);
                ensure(array.isNull(array.get(index)));
            }
        });
    }

    @Test
    public void testEqualsHashCode()
    {
        var map = new HashMap<IntArray, Integer>();
        _10.loop(() ->
        {
            var array = array();
            random().intSequence(array::add);
            map.put(array, 99);
            ensureEqual(99, map.get(array));
        });
    }

    @Test
    public void testFirstLast()
    {
        var array = array();

        ensureThrows(array::first);
        ensureThrows(array::last);

        index = 0;
        maximumIndex = Integer.MIN_VALUE;
        random().intSequence(value ->
        {
            array.set(index, value);
            maximumIndex = Math.max(index, maximumIndex);
            ensureEqual(array.get(0), array.first());
            ensureEqual(array.get(maximumIndex), array.last());
            index++;
        });
    }

    @Test
    public void testGetSet()
    {
        var array = array();

        index = 0;
        random().intSequence(value ->
        {
            array.set(index, value);
            ensureEqual(array.get(index), value);
            index++;
        });

        index = 0;
        random().intSequence(value ->
        {
            index++;
            array.set(index, value);
            ensureEqual(array.get(index), value);
        });

        array.clear();
        array.nullInt(-1);
        random().intSequence(value -> !value.equals(-1), array::add);
        random().loop(() ->
        {
            int index = random().randomIndex(array.size() * 2);
            var value = array.safeGet(index);
            ensureEqual(index >= array.size(), array.isNull(value));
        });
    }

    @Test
    public void testIsNull()
    {
        var array = array();
        var nullValue = random().randomInt();
        array.nullInt(nullValue);
        ensure(array.hasNullInt());
        index = 0;
        random().intSequence(value -> value != array.nullInt(), value ->
        {
            index++;

            array.set(index, value);
            ensure(!array.isNull(array.get(index)));

            array.set(index, array.nullInt());
            ensure(array.isNull(array.get(index)));
        });
    }

    @Test
    public void testIteration()
    {
        var array = array();
        array.hasNullInt(false);

        array.add(0);
        array.add(1);
        array.add(2);
        array.set(32, 100);

        var values = array.iterator();
        ensureEqual(0, values.next());
        ensureEqual(1, values.next());
        ensureEqual(2, values.next());
        ensureEqual(array.nullInt(), values.next());
        ensure(values.hasNext());

        array.hasNullInt(true);

        values = array.iterator();
        ensureEqual(1, values.next());
        ensureEqual(2, values.next());
        ensureEqual(100, values.next());
        ensureFalse(values.hasNext());
    }

    @Test
    public void testSerialization()
    {
        var array = array();
        random().intSequence(array::add);
        testSerialization(array);
    }

    @Test
    public void testSizeIsEmpty()
    {
        var array = array();

        ensure(array.isEmpty());
        ensure(array.size() == 0);
        array.add(0);
        ensure(array.size() == 1);
        array.add(1);
        ensure(array.size() == 2);
        array.add(2);
        ensure(array.size() == 3);
        array.set(1000, 1000);
        ensure(array.size() == 1001);
        array.clear(2);
        ensure(array.size() == 1001);
        array.clear();
        ensure(array.isEmpty());
        ensure(array.size() == 0);

        maximumIndex = Integer.MIN_VALUE;
        index = 0;
        random().intSequence(value ->
        {
            index++;
            maximumIndex = Math.max(index, maximumIndex);
            array.set(index, value);
            ensure(array.size() == maximumIndex + 1);
        });
    }

    @Test
    public void testSubArray()
    {
        var array = array();
        random().intSequence(array::add);
        var last = array.size() - 1;
        int offset = Math.abs(random().randomIntExclusive(0, last));
        int length = Math.abs(random().randomIntExclusive(0, last - offset));
        ensure(offset < array.size());
        ensure(length >= 0);
        ensure(offset + length < array.size());
        var subArray = array.subArray(offset, length);
        for (int i = 0; i < length; i++)
        {
            ensureEqual(array.get(offset + i), subArray.get(i));
        }
    }

    private IntArray array()
    {
        var array = new IntArray("test");
        array.initialize();
        return array;
    }
}
