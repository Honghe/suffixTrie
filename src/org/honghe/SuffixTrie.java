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
	private Node root = null;
	private int symbolAccount = 0;
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
		try {
			reader = new BufferedReader(new FileReader(new File(dictName)));
			StringBuffer stringBuffer = new StringBuffer(reader.readLine());	
			while (stringBuffer.length() > 0) {
				symbolAccount++;
				insert(stringBuffer.toString() + '$');
				stringBuffer.deleteCharAt(0);
			}
			System.out.println("total words:" + symbolAccount);
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
	public boolean insert(String string) {
		if (search(string)) {
			System.out.println("the word: " + string + " has already bee added into the trie!");
			return false;
		}else {
			Node currentNode = root;
			char c;
			for (int i = 0; i < string.length(); i++) {
				c = string.charAt(i);
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
	public boolean search(String string) {
		string += string + '$';
		Node currNode = root;
		char c;
		for (int i = 0; i < string.length(); i++) {
			c = string.charAt(i);
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
		Node currNode = root;
		char c;
		for (int i = 0; i < string.length(); i++) {
			c = string.charAt(i);
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
		Node currNode = root;
		char c;
		for (int i = 0; i < string.length(); i++) {
			c = string.charAt(i);
			if (!currNode.contains(c)) {
				return -1;
			}else {
				currNode = currNode.next(c);
			}
		}
		return currNode.getCount();
	}
	@Override
	public void read(String path) {
		
	}
	
	@Override
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

	/**
	 * @return the symbolAccount
	 */
	public int getSymbolAccount() {
		return symbolAccount;
	}

	/**
	 * @param symbolAccount the symbolAccount to set
	 */
	public void setSymbolAccount(int symbolAccount) {
		this.symbolAccount = symbolAccount;
	}


}
