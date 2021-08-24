/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.divinecraft.zaraza.common.api.reactor;

import org.jetbrains.annotations.NotNull;

/**
 * Atomic compare-and-set operation.
 *
 * @param <T> type of manipulated values
 * @see ReactiveCompareAndSetOperation reactive equivalent
 */
@FunctionalInterface
public interface CompareAndSetOperation<T> {

    /**
     * Performs compare-and-set operation
     *
     * @param oldValue the expected value
     * @param newValue the new value
     * @return {@code true} if the operation succeeds or {@code false} otherwise
     */
    boolean compareAndSet(T oldValue, T newValue);

    /**
     * Creates a compare-ans-set operation which never succeeds.
     *
     * @param <T> type of manipulated values
     * @return created impossible compare-and-set operation
     */
    static @NotNull <T> CompareAndSetOperation<T> impossible() {
        return (oldValue, newValue) -> false;
    }
}
