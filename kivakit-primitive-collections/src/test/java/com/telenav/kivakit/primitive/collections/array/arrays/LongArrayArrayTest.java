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

import com.telenav.kivakit.primitive.collections.array.scalars.LongArray;
import com.telenav.kivakit.primitive.collections.PrimitiveCollectionsUnitTest;
import org.junit.Test;

public class LongArrayArrayTest extends PrimitiveCollectionsUnitTest
{
    @Test
    public void test()
    {
        var store = new LongArrayArray("test");
        store.initialize();
        var a = longs(10, 20, 30, 40);
        var aIndex = store.add(a);
        var b = longs(2, 3, 5, 7, 11);
        var bIndex = store.add(b);
        ensureEqual(a, store.get(aIndex));
        ensureEqual(b, store.get(bIndex));
        ensureEqual(4, store.length(aIndex));
        ensureEqual(5, store.length(bIndex));
    }

    private LongArray longs(long... values)
    {
        var array = new LongArray("test");
        array.initialize();
        for (long value : values)
        {
            array.add(value);
        }
        return array;
    }
}
