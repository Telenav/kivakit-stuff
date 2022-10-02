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

import com.telenav.kivakit.serialization.kryo.test.KryoUnitTest;
import com.telenav.kivakit.serialization.kryo.types.KivaKitCoreKryoTypes;
import com.telenav.kivakit.serialization.kryo.types.KryoTypes;

/**
 * This is the base test class for all unit tests. It provides some methods common to all tests.
 *
 * @author jonathanl (shibo)
 */
public abstract class PrimitiveCollectionsUnitTest extends KryoUnitTest
{
    @Override
    protected KryoTypes kryoTypes()
    {
        return new KivaKitCoreKryoTypes().mergedWith(new PrimitiveCollectionsKryoTypes());
    }
}
