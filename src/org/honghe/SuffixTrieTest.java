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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 后缀树测试类
 * 
 * @author honghe
 */
public class SuffixTrieTest {
	String path = null;
	SuffixTrie trie = null;
	BufferedReader reader = null;

	/**
	 * 测试后缀树
	 */
	private void test() {
		//训练的文件格式是第一行一个训练字符序列
		this.path = "./dict/train.txt";
		this.trie = new SuffixTrie();
		// 构建后缀树
		trie.build(path);
		
		//测试字符串出现的次数
		System.out.println("字符串A出现的次数: " + trie.getOccurences("A"));
		 
		//测试儿子节点的个数
		System.out.println(trie.getRoot().sizeOfChildren());
		 
		//测试是否构建了所有单词 没有递归测试子序列
		try {
			reader = new BufferedReader(new FileReader(new File(path)));			 
			String word = reader.readLine();
			while (word != null) { //未到文件末尾
			if (!word.trim().equals("")) { //非空行
				word += '$';
				System.out.println(trie.search(word));
			}
			word = reader.readLine();
			}
		} catch (Exception e) {
		 e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SuffixTrieTest suffixTrieTest = new SuffixTrieTest();
		suffixTrieTest.test();
	}

}
