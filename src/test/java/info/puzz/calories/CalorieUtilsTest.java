/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package info.puzz.calories;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CalorieUtilsTest {

    @Test
    public void testSimple() {
        Location start = new Location(0, 0, System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(40));
        Location end = new Location(0, 0.045, System.currentTimeMillis());
        double distance = start.distance(end);
        double calories = CalorieUtils.getCalorie(start, end, 80, CalorieUtils.ActivityType.RUNNING);
        System.out.println("distance=" + distance);
        System.out.println("calories=" + calories);
    }

}
