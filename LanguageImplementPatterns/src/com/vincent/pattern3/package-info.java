/**
 * 《编程语言实现模式》模式3：LL(1)递归下降的语法解析器
 * 
 *  目的：采用一个向前看符号，分析词法单元流的语法结构
 *	
 *	下图是[a, [b, c], d]的解析树(图中*代表连线)
 *	               
 *				list
 *		     *   *   *
 *          *    *     * 
 *		  [   elements  ]
 *           * *   *    * *
 *         *  *    *     *  *
 *  element  ,  element   ,  element 
 *    *            *           
 *    *            * 
 *	  a           list
 *             *   *   *
 *            *    *    *  
 *           [  elements  ] 
 *             *    *   * 
 *            *     *    *
 *         element  ,   element
 *            *           *
 *            *           *
 *            b           c
 *            
 *    解析树便定义了各种语法，然后根据语法递归调用
 *    
 *    1、计算向前看集合
 *    “实际使用时等价于哪些词法单元可能出现在这个解析选项的开头”
 *    
 *    
 *    
 */           
/**
 * @author vincent
 *
 */
package com.vincent.pattern3;