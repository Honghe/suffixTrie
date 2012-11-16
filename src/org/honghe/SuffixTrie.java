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
 * 后缀树类
 * @author honghe
 */
public class SuffixTrie implements Trie {
	private Node root = null;
	private int symbolAccount = 0;	//统计序列集总共字符数
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
		StringBuffer stringBuffer = null;
		String string = null;
		try {
			reader = new BufferedReader(new FileReader(new File(dictName)));
			string = reader.readLine();
			while (string != null) {
				stringBuffer = new StringBuffer(string);
//				System.out.println("read: " + stringBuffer);
				while (stringBuffer.length() > 0) {					
					insert(stringBuffer.toString() + '$');
					symbolAccount++;
					stringBuffer.deleteCharAt(0);
				}
				string = reader.readLine();
			}
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
			Node currentNode = root;
			char c;
			for (int i = 0; i < string.length(); i++) {
				c = string.charAt(i);
				if (c == '$') {	//到序列末尾
					if (currentNode.contains(c)) {	//如果已有这个序列，则只要结点计数加1
						currentNode.increaseCount();  
					}else {
						Node leaf = new LeafNode();
						currentNode.addChild('$', leaf);
						currentNode.increaseCount();
					}
					
				}else {	//未到序列末尾，就增加枝结点
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
	 * 在SuffixTrie树中查找子序列
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
	 * 查找SuffrixTrie树中子序列出现的次数
	 * @param string
	 * @return 没有就返回-1
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
