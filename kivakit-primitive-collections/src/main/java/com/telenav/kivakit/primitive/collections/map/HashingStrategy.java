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

package com.telenav.kivakit.primitive.collections.map;

import com.telenav.kivakit.core.value.count.Count;
import com.telenav.kivakit.core.value.count.Estimate;
import com.telenav.kivakit.core.value.level.Percent;
import com.telenav.kivakit.primitive.collections.internal.lexakai.DiagramPrimitiveMap;
import com.telenav.lexakai.annotations.UmlClassDiagram;

/**
 * Pluggable hashing algorithm.
 *
 * @author jonathanl (shibo)
 */
@UmlClassDiagram(diagram = DiagramPrimitiveMap.class)
public interface HashingStrategy
{
    /**
     * Returns the occupancy level for rehashing
     */
    Percent maximumOccupancy();

    /**
     * Returns the recommended capacity when initializing or resizing
     */
    Estimate recommendedSize();

    /**
     * Returns the number of elements at which resizing should occur. This will typically be a prime number to improve
     * hashing performance
     */
    Count rehashThreshold();

    /**
     * Returns with the given capacity
     */
    HashingStrategy withCapacity(Estimate size);

    /**
     * Returns with an acceptable increased capacity
     */
    HashingStrategy withIncreasedCapacity();
}
