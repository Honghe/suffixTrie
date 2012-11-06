/**
 * 
 */
package org.honghe;

/**后缀树叶结点类
 * @author honghe
 */
public class LeafNode extends Node{
	public LeafNode() {
		super.setC('$');
		super.setCount(0);
		super.setType(1);
	}
}
