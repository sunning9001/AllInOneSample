/*******************************************************************************
 * Copyright (c) 2015 Christos Froussios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *******************************************************************************/
package com.intro.chapter2.aggregation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import rx.Observable;
import rx.observers.TestSubscriber;

public class CollectExample {

	public void example() {
		Observable<Integer> values = Observable.range(10,5);
		
		values
			.collect(
				() -> new ArrayList<Integer>(),
				(acc, value) -> acc.add(value))
			.subscribe(v -> System.out.println(v));
		
		// [10, 11, 12, 13, 14]
	}
	
	@Test
	public void test() {
		TestSubscriber<List<Integer>> tester = new TestSubscriber<>();
		
		Observable<Integer> values = Observable.range(10,5);
		
		values
			.collect(
				() -> new ArrayList<Integer>(),
				(acc, value) -> acc.add(value))
			.subscribe(tester);
		
		tester.assertReceivedOnNext(Arrays.asList(
				Arrays.asList(10, 11, 12, 13, 14)
		));
		tester.assertTerminalEvent();
		tester.assertNoErrors();
	}

}
