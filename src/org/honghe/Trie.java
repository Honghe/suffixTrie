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

/**
 * Trie树接口
 * @author honghe
 * Nov 2, 2012
 */
public interface Trie {
	/**
	 * 由序列集文件构造Trie树
	 * @param dictName
	 */
	public void build(String dictName);
	
	/**
	 * 在Trie树中查找一个序列
	 * @param word
	 * @return
	 */
	public boolean search(String word);
	
	/**
	 * 插入一个序列到Trie树中
	 * @param word
	 * @return
	 */
	public boolean insert(String word);
	
	/**
	 * 从Trie树中删除一个序列
	 * @param word
	 * @return
	 */
	public boolean delete(String word);
	
	/**
	 * 将Trie树保存到文件中
	 * @param path
	 */
	public void save(String path);
	
	/**
	 * 从文件中读取Trie树
	 * @param path
	 */
	public void read(String path);
}
