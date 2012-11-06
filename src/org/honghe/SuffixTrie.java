/**
 * 
 */
package org.honghe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 后缀树类
 * @author honghe
 */
public class SuffixTrie implements Trie {
	private Node root;
	public SuffixTrie(){
		root = new BranchNode(' ');
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	@Override
	public void build(String dictName) {
		BufferedReader reader = null;
		int i = 0;	//单词的个数
		try {
			reader = new BufferedReader(new FileReader(new File(dictName)));
			String word = reader.readLine();
			while (word != null) {	//未到文件末尾
				if (!word.trim().equals("")) {	//非空行
					i++;
					word += '$';
					insert(word);
				}
				word = reader.readLine();
			}
			System.out.println("total words:" + i);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public boolean insert(String word) {
		if (search(word)) {
			System.out.println("the word: " + word + " has already bee added into the trie!");
			return false;
		}else {
			char[] chars = word.toCharArray();
			Node currentNode = root;
			char c;
			for (int i = 0; i < chars.length; i++) {
				c = chars[i];
				if (c == '$') {
					Node leaf = new LeafNode();
					currentNode.addChild('$', leaf);
					currentNode.increaseCount();
				}else {
					if (currentNode.contains(c)) {
						currentNode.increaseCount();
						currentNode = currentNode.next(c);
					}else {
						Node branch = new BranchNode(c);
						currentNode.addChild(c, branch);
						currentNode.increaseCount();
						currentNode = branch;
					}
				}
			}
			return true;
		}
	}
	
	@Override
	public boolean search(String word) {
		word += word + '$';
		char[] chars = word.toCharArray();
		Node currNode = root;
		char c;
		for (int i = 0; i < chars.length; i++) {
			c = chars[i];
			if (c == '$' && currNode.contains(c)) {
				return true;
			}else {
				if (currNode.contains(c)) {
					currNode = currNode.next(c);
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	 * 在SuffixTrie树中查找字符串
	 * @param string
	 * @return
	 */
	public boolean searchString(String string) {
		char[] chars = string.toCharArray();
		Node currNode = root;
		char c;
		for (int i = 0; i < chars.length; i++) {
			c = chars[i];
			if (!currNode.contains(c)) {
				return false;
			}else {
				currNode = currNode.next(c);
			}
		}
		return true;
	}
	
	/**
	 * 查找SuffrixTrie树中字符串出现的次数
	 * @param string
	 * @return
	 */
	public int getOccurences(String string) {
		char[] chars = string.toCharArray();
		Node currNode = root;
		char c;
		for (int i = 0; i < chars.length; i++) {
			c = chars[i];
			if (!currNode.contains(c)) {
				return -1;
			}else {
				currNode = currNode.next(c);
			}
		}
		return currNode.getCount();
	}
	public void read(String path) {
		
	}
	
	public void save(String path) {
		
	}

	/* (non-Javadoc)
	 * @see org.honghe.Trie#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String word) {
		// TODO Auto-generated method stub
		return false;
	}


}
