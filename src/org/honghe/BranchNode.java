/**
 * Copyright 2012 Honghe Wu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.honghe;

import java.util.HashMap;

/**后缀树分支结点类
 * @author honghe
 */
public class BranchNode extends Node{
	/**
	 * 
	 */
	public BranchNode(char c) {
		super.setC(c);
		super.setType((byte) 1);
		super.setCount(0);
		super.setChildren(new HashMap<String, Node>());
	}
}
