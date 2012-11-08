/**
 * 
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
