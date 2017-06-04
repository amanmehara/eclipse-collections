/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.test.map.mutable;

import java.util.Random;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.map.mutable.ConcurrentMutableHashMap;
import org.eclipse.collections.impl.test.junit.Java8Runner;
import org.eclipse.collections.test.NoDetectOptionalNullTestCase;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNull;

@RunWith(Java8Runner.class)
public class ConcurrentMutableHashMapTest implements MutableMapTestCase, NoDetectOptionalNullTestCase
{
    private static final long CURRENT_TIME_MILLIS = System.currentTimeMillis();

    @Override
    public <T> MutableMap<Object, T> newWith(T... elements)
    {
        Random random = new Random(CURRENT_TIME_MILLIS);
        MutableMap<Object, T> result = ConcurrentMutableHashMap.newMap();
        for (T each : elements)
        {
            assertNull(result.put(random.nextDouble(), each));
        }
        return result;
    }
}
