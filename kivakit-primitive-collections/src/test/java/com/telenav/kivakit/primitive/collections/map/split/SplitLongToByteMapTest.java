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

package com.telenav.kivakit.primitive.collections.map.split;

import com.telenav.kivakit.primitive.collections.CompressibleCollection;
import com.telenav.kivakit.primitive.collections.PrimitiveCollectionsUnitTest;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static com.telenav.kivakit.internal.testing.Repeats.ALLOW_REPEATS;
import static com.telenav.kivakit.internal.testing.Repeats.NO_REPEATS;

public class SplitLongToByteMapTest extends PrimitiveCollectionsUnitTest
{
    @FunctionalInterface
    interface MapTest
    {
        void test(SplitLongToByteMap map, List<Long> keys, List<Byte> values);
    }

    @Test
    public void testClear()
    {
        withPopulatedMap((map, keys, values) ->
        {
            ensureFalse(map.isEmpty());
            map.clear();
            ensure(map.isEmpty());
        });
    }

    @Test
    public void testContainsKey()
    {
        withPopulatedMap((map, keys, values) -> keys.forEach(key -> ensure(map.containsKey(key))));
    }

    @Test
    public void testEqualsHashCode()
    {
        withPopulatedMap((a, keys, values) ->
        {
            var b = map();
            putAll(b, keys, values);
            ensureEqual(a, b, "Should be equal: $ and $", a, b);
            b.put(-999999, (byte) -1);
            ensureNotEqual(a, b, "Should not be equal: $ and $", a, b);
        });
    }

    @Test
    public void testFreeze()
    {
        withPopulatedMap((a, keys, values) ->
        {
            var b = map();
            putAll(b, keys, values);
            ensureEqual(a, b);
            b.compress(CompressibleCollection.Method.FREEZE);
            ensureEqual(a, b);
        });
        withPopulatedMap((a, keys, values) ->
        {
            var b = map();
            putAll(b, keys, values);
            putAll(b, keys, values);
            ensureEqual(a, b);
            b.compress(CompressibleCollection.Method.FREEZE);
            ensureEqual(a, b);
        });
    }

    @Test
    public void testGetPut()
    {
        withPopulatedMap((map, keys, values) ->
        {
            index = 0;
            keys.forEach(key -> ensureEqual(map.get(key), values.get(index++)));
        });
    }

    @Test
    public void testKeys()
    {
        withPopulatedMap((map, keys, values) ->
        {
            var iterator = map.keys();
            var count = 0;
            while (iterator.hasNext())
            {
                var key = iterator.next();
                ensure((map.containsKey(key)));
                count++;
            }
            ensureEqual(map.size(), count);
        });
    }

    @Test
    public void testRemove()
    {
        withPopulatedMap((map, keys, values) ->
                keys.forEach(key ->
                {
                    var size = map.size();
                    var exists = map.containsKey(key);
                    map.remove(key);
                    ensure(map.isEmpty(map.get(key)));
                    if (exists)
                    {
                        ensureEqual(map.size(), size - 1);
                    }
                }));
    }

    @Test
    public void testSerialization()
    {
        withPopulatedMap((map, keys, values) -> testSerialization(map));
    }

    @Test
    public void testValues()
    {
        withPopulatedMap((map, keys, values) ->
        {
            var iterator = map.values();
            var count = 0;
            var valueSet = new HashSet<>(values);
            while (iterator.hasNext())
            {
                var value = iterator.next();
                ensure((valueSet.contains(value)));
                count++;
            }
            ensureEqual(map.size(), count);
        });
    }

    private SplitLongToByteMap map()
    {
        var map = new SplitLongToByteMap("test");
        map.initialize();
        return map;
    }

    private void putAll(SplitLongToByteMap map, List<Long> keys, List<Byte> values)
    {
        index = 0;
        keys.forEach(key -> map.put(key, values.get(index++)));
    }

    private void withPopulatedMap(SplitLongToByteMapTest.MapTest test)
    {
        var map = map();
        var keys = random().list(NO_REPEATS,  Long.class, value -> !map.isEmpty(value));
        var values = random().list(ALLOW_REPEATS,count(keys),  Byte.class, value -> !map.isEmpty(value));
        putAll(map, keys, values);
        test.test(map, keys, values);
    }
}
