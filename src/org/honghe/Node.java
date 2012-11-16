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

import java.util.Map;

/**
 * 后缀树结点类
 * @author honghe
 */
public class Node {
	private char c;		//取字符串中的一个字符
	private byte type;	//节点类型
	private int count; //统计从根到此结点的子序列出现次数
	
	private Map<String, Node> children;
	public Node() {
		this.c = ' ';
		this.type = -1;
		this.count = 0;
		this.children = null;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//增加一次计数
	public void increaseCount() {
		this.count++;
	}
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public Map<String, Node> getChildren() {
		return children;
	}
	public void setChildren(Map<String, Node> children) {
		this.children = children;
	}
	public boolean contains(char c) {
		if (children.containsKey(c + "")) {
			return true;
		}
		return false;
	}
	
	public Node next(char c) {
		return children.get(c + "");
	}
	
	public int sizeOfChildren() {
		return children.size();
	}
	
	public void addChild(char c, Node child) {
		children.put(c + "", child);
	}
	public void removeChild(char c) {
		children.remove(c + "");
	}
}
