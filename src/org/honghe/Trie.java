/**
 * 
 */
package org.honghe;

/**
 * Trie树接口
 * @author honghe
 * Nov 2, 2012
 */
public interface Trie {
	/**
	 * 由词典文件构造Trie树
	 * @param dictName
	 */
	public void build(String dictName);
	
	/**
	 * 在Trie树中查找一个单词
	 * @param word
	 * @return
	 */
	public boolean search(String word);
	
	/**
	 * 插入一个单词到Trie树中
	 * @param word
	 * @return
	 */
	public boolean insert(String word);
	
	/**
	 * 从Trie树中删除一个单词
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
