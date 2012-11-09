/**
 * 
 */
package org.honghe;

/**
 * CPD Model分类算法类
 * @author honghe
 */
public class CPDModel {

	/**
	 * 计算序列与序列集的相似性
	 * @param trie
	 * @param testString
	 * @return
	 */
	public float calculateSimilarity(SuffixTrie trie, String testString) {
		float probability = 1.0f;
		//TODO 对于子序列出现概率为0的情况，如何处理
		probability *= (float)trie.getOccurences(testString.substring(0, 1)) / trie.getSymbolAccount();
		System.out.println("初始相似性" + probability);
		for (int i = 1; i < testString.length(); i++) {
			System.out.println("次数 " + i);
			System.out.println(trie.getOccurences(testString.substring(0, i + 1)));
			System.out.println(trie.getOccurences(testString.substring(0, i)));
			probability *= (float)trie.getOccurences(testString.substring(0, i + 1)) /
					trie.getOccurences(testString.substring(0, i));
			System.out.println("相似性：" + probability);
		}
		return probability;
	}
}
