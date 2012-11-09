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
 * 后缀树测试类
 * 
 * @author honghe
 */
public class SuffixTrieTest {
	public static void main(String[] args) {
		String path = "./dict/test.txt";
		SuffixTrie trie = new SuffixTrie();
		// 构建后缀树
		trie.build(path);

		// 使用CPD Model类测试相似性
		String testString = "91E66028";
		CPDModel cpdModel = new CPDModel();
		System.out.println("相似性："
				+ cpdModel.calculateSimilarity(trie, testString));
		// 测试是否有给定字符串
		System.out.println(trie.searchString(testString) ? "has string: "
				+ testString : "does not have string: " + testString);

		// 测试字符串出现的次数
		// System.out.println("字符串A出现的次数: " + trie.getOccurences("A"));

		// 测试儿子节点的个数
		// System.out.println(trie.getRoot().sizeOfChildren());

		// //测试是否构建了所有单词
		// BufferedReader reader = null;
		// try {
		// reader = new BufferedReader(new FileReader(new File(path)));
		// String word = reader.readLine();
		// while (word != null) { //未到文件末尾
		// if (!word.trim().equals("")) { //非空行
		// word += '$';
		// System.out.println(trie.search(word));
		// }
		// word = reader.readLine();
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}
}
